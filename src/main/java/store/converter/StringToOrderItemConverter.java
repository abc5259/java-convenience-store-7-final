package store.converter;

import store.domain.OrderItem;

public class StringToOrderItemConverter implements Converter<String, OrderItem> {
    @Override
    public OrderItem convert(String source) {
        source = source.trim();
        if (!source.startsWith("[") || !source.endsWith("]")) {
            throw new IllegalArgumentException("올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.");
        }

        source = source.substring(1, source.length() - 1);
        String[] sources = source.split("-");
        if (sources.length != 2) {
            throw new IllegalArgumentException("올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.");
        }

        try {
            return new OrderItem(sources[0].trim(), Integer.parseInt(sources[1]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.");
        }
    }
}
