package store.view;

import java.util.Map;
import store.domain.Product;

public class OutputView {

    private static final String HELLO_MESSAGE = "안녕하세요. W편의점입니다.";
    private static final String PRODUCT_INFO_NOTICE_MESSAGE = "현재 보유하고있는 상품입니다.";
    private static final String PROMOTION_PRODUCT_FORMAT = "- %s %,d원 %d개 %s%n";
    private static final String PRODUCT_FORMAT = "- %s %,d원 %d개%n";
    private static final String PRODUCT_NO_QUANTITY_FORMAT = "- %s %,d원 재고 없음%n";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s%n";

    public void printHelloMessage() {
        System.out.println(HELLO_MESSAGE);
    }

    public void printProducts(Map<String, Product> products) {
        System.out.println(PRODUCT_INFO_NOTICE_MESSAGE);
        System.out.println();
        products.forEach((name, product) -> {
            if (product.hasPromotion()) {
                System.out.printf(PROMOTION_PRODUCT_FORMAT,
                        name,
                        product.getPrice(),
                        product.getPromotionQuantity(),
                        product.getPromotionName());
            }
            if (product.getSimpleProductQuantity() == 0) {
                System.out.printf(PRODUCT_NO_QUANTITY_FORMAT, name, product.getPrice());
                return;
            }
            System.out.printf(PRODUCT_FORMAT,
                    name,
                    product.getPrice(),
                    product.getSimpleProductQuantity());
        });
    }

    public void printErrorMessage(Exception exception) {
        System.out.printf(ERROR_MESSAGE_FORMAT, exception.getMessage());
    }
}
