package store.view;

import java.util.List;
import java.util.Map;
import store.domain.Product;
import store.domain.PurchaseInfo;
import store.domain.Receipt;

public class OutputView {

    private static final String HELLO_MESSAGE = "안녕하세요. W편의점입니다.";
    private static final String PRODUCT_INFO_NOTICE_MESSAGE = "현재 보유하고있는 상품입니다.";
    private static final String PROMOTION_PRODUCT_FORMAT = "- %s %,d원 %d개 %s%n";
    private static final String PRODUCT_FORMAT = "- %s %,d원 %d개%n";
    private static final String PRODUCT_NO_QUANTITY_FORMAT = "- %s %,d원 재고 없음%n";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s%n";
    private static final String PRODUCT_RECEIPT_HEAD = "=========W 편의점===========";
    private static final String PRODUCT_INFO_TITLE = "%-16s %-6s %-10s%n";
    private static final String PRODUCT_INFO = "%-16s %-6d %-,10d%n";

    private static final String GIVEAWAY_RECEIPT_HEAD = "=========증   정===========";
    private static final String GIVEAWAY_PRODUCT_INFO = "%-16s %-6d%n";

    private static final String PRICE_HEAD = "=========================";

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

    public void printReceipt(Receipt receipt) {
        List<PurchaseInfo> purchaseInfos = receipt.getPurchaseInfo();
        System.out.println(PRODUCT_RECEIPT_HEAD);
        System.out.printf(PRODUCT_INFO_TITLE, "상품명", "수량", "금액");
        purchaseInfos.forEach(
                purchaseInfo -> System.out.printf(
                        PRODUCT_INFO,
                        purchaseInfo.name(),
                        purchaseInfo.quantity(),
                        purchaseInfo.price()));

        System.out.println(GIVEAWAY_RECEIPT_HEAD);
        List<PurchaseInfo> giveawayPurchaseInfos = receipt.getGiveawayPurchaseInfo();
        giveawayPurchaseInfos.forEach(
                giveawayPurchaseInfo -> System.out.printf(
                        GIVEAWAY_PRODUCT_INFO,
                        giveawayPurchaseInfo.name(),
                        giveawayPurchaseInfo.quantity()));
        System.out.println(PRICE_HEAD);
        System.out.printf("%-16s %-6d %,6d%n", "총구매액", receipt.getTotalQuantity(), receipt.getTotalAmount());
        System.out.printf("%-16s %-6s -%-,6d%n", "행사할인", "", receipt.getGiveawayPrice());
        System.out.printf("%-16s %-6s -%-,6d%n", "멤버십할인", "", receipt.getDiscountAmount());
        System.out.printf("%-16s %-6s %,6d%n", "내실돈", "", receipt.getFinalAmount());
    }

    public void printErrorMessage(Exception exception) {
        System.out.printf(ERROR_MESSAGE_FORMAT, exception.getMessage());
    }
}
