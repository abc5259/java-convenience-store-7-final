package store.domain;

import java.util.Collections;
import java.util.List;

public class Cart {
    private final List<OrderItem> orderItems;

    public Cart(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public List<OrderItem> getOrderItems() {
        return Collections.unmodifiableList(orderItems);
    }
}
