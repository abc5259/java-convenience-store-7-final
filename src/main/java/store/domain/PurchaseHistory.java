package store.domain;

import java.time.LocalDate;

public record PurchaseHistory(
        Product product,
        OrderItem orderItem
) {
    public int getPromotionNotApplyAmount(LocalDate date) {
        return product.calculateOutOfPromotionQuantity(orderItem.count(), date);
    }

    public PurchaseInfo getPurchaseInfo() {
        return new PurchaseInfo(orderItem.name(), product.getPrice(), orderItem.count());
    }

    public PurchaseInfo getGiveawayPurchaseInfo(LocalDate date) {
        return new PurchaseInfo(
                orderItem.name(),
                product.getPrice(),
                product.calculateGiveawayQuantity(orderItem.count(), date)
        );
    }

    public int getPurchaseAmount() {
        return product.calculatePrice(orderItem.count());
    }
}
