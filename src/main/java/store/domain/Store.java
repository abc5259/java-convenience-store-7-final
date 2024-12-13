package store.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Store {

    private final Map<String, Product> products;

    public Store(Map<String, Product> products) {
        this.products = products;
    }

    public void validatePurchase(Cart cart) {
        cart.getOrderItems().forEach(this::validatePurchase);
    }

    public void validatePurchase(OrderItem orderItem) {
        if (!products.containsKey(orderItem.name())) {
            throw new IllegalArgumentException("존재하지 않는 상품입니다. 다시 입력해 주세요.");
        }

        Product product = products.get(orderItem.name());
        if (!product.canPurchase(orderItem.count())) {
            throw new IllegalArgumentException("재고 수량을 초과하여 구매할 수 없습니다.");
        }
    }

    public List<PurchaseNoticeResult> calculatePurchaseNoticeResults(Cart cart, LocalDate date) {
        List<PurchaseNoticeResult> purchaseNoticeResults = new ArrayList<>();
        for (OrderItem orderItem : cart.getOrderItems()) {
            Product product = products.get(orderItem.name());
            purchaseNoticeResults.add(calculatePurchaseNoticeResult(date, orderItem, product));
        }
        return purchaseNoticeResults;
    }

    private PurchaseNoticeResult calculatePurchaseNoticeResult(
            LocalDate date,
            OrderItem orderItem,
            Product product) {
        if (product.canMorePurchaseQuantity(orderItem.count(), date)) {
            return new PurchaseNoticeResult(
                    orderItem,
                    Notice.MORE_QUANTITY,
                    product.calculatePromotionFreeQuantity(orderItem.count(), date));
        }

        if (product.isOutOfPromotionQuantity(orderItem.count(), date)) {
            return new PurchaseNoticeResult(
                    orderItem,
                    Notice.NO_PROMOTION_APPLY,
                    product.calculateOutOfPromotionQuantity(orderItem.count(), date));
        }

        return new PurchaseNoticeResult(orderItem, Notice.GOOD, 0);
    }
}
