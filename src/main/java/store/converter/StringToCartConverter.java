package store.converter;

import java.util.Arrays;
import java.util.List;
import store.domain.Cart;
import store.domain.OrderItem;

public class StringToCartConverter implements Converter<String, Cart> {
    @Override
    public Cart convert(String source) {
        String[] sources = source.split(",");
        if (source.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다. 다시 입력해 주세요.");
        }
        StringToOrderItemConverter stringToOrderItemConverter = new StringToOrderItemConverter();
        List<OrderItem> orderItems = Arrays.stream(sources)
                .map(stringToOrderItemConverter::convert)
                .toList();
        return new Cart(orderItems);
    }
}
