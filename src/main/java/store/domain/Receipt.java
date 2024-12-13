package store.domain;

import java.time.LocalDate;
import java.util.List;

public class Receipt {

    private final List<PurchaseHistory> purchaseHistories;
    private final MembershipDiscount memberShipDiscount;
    private final LocalDate date;

    public Receipt(List<PurchaseHistory> purchaseHistories, MembershipDiscount memberShipDiscount, LocalDate date) {
        this.purchaseHistories = purchaseHistories;
        this.memberShipDiscount = memberShipDiscount;
        this.date = date;
    }

    public int getTotalPromotionNotApplyAmount() {
        return purchaseHistories.stream()
                .mapToInt(purchaseHistory -> purchaseHistory.getPromotionNotApplyAmount(date))
                .sum();
    }

    public List<PurchaseInfo> getPurchaseInfo() {
        return purchaseHistories.stream()
                .map(PurchaseHistory::getPurchaseInfo)
                .toList();
    }

    public List<PurchaseInfo> getGiveawayPurchaseInfo() {
        return purchaseHistories.stream()
                .map(purchaseHistory -> purchaseHistory.getGiveawayPurchaseInfo(date))
                .filter(purchaseInfo -> purchaseInfo.quantity() != 0)
                .toList();
    }

    public int getTotalAmount() {
        return purchaseHistories.stream()
                .mapToInt(PurchaseHistory::getPurchaseAmount)
                .sum();
    }

    public int getDiscountAmount() {
        return memberShipDiscount.calculateDiscountAmount(this);
    }

    public int getFinalAmount() {
        int giveawayPrice = getGiveawayPrice();
        return getTotalAmount() - giveawayPrice - getDiscountAmount();
    }

    public int getGiveawayPrice() {
        return getGiveawayPurchaseInfo().stream()
                .mapToInt(PurchaseInfo::calculatePrice)
                .sum();
    }

    public int getTotalQuantity() {
        return purchaseHistories.stream()
                .mapToInt(PurchaseHistory::getQuantity)
                .sum();
    }
}
