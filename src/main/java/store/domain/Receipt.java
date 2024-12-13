package store.domain;

import java.time.LocalDate;
import java.util.List;

public class Receipt {

    private final List<PurchaseHistory> purchaseHistories;
    private final MemberShipDiscount memberShipDiscount;
    private final LocalDate date;

    public Receipt(List<PurchaseHistory> purchaseHistories, MemberShipDiscount memberShipDiscount, LocalDate date) {
        this.purchaseHistories = purchaseHistories;
        this.memberShipDiscount = memberShipDiscount;
        this.date = date;
    }

    public int getTotalPromotionNotApplyAmount() {
        return purchaseHistories.stream()
                .mapToInt(purchaseHistory -> purchaseHistory.getPromotionNotApplyAmount(date))
                .sum();
    }
}
