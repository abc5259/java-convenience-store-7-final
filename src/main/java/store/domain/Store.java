package store.domain;

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
}
