package store.view;

import camp.nextstep.edu.missionutils.Console;
import store.domain.Notice;
import store.domain.PurchaseNoticeResult;

public class InputView {

    private static final String INPUT_PURCHASE_PRODUCT = "구매하실 상품명과 수량을 입력해 주세요. (예: " + "[사이다-2],[감자칩-1])";
    private static final String INPUT_MORE_QUANTITY = "현재 %s은(는) %d개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)%n";
    private static final String INPUT_NO_APPLY_PROMOTION = "현재 %s %d개는 프로모션 할인이 적용되지 않습니다. 그래도구매하시겠습니까? (Y/N)%n";
    private static final String INPUT_MEMBERSHIP_DISCOUNT = "멤버십 할인을 받으시겠습니까? (Y/N)";

    public String readPurchaseProduct() {
        System.out.println();
        System.out.println(INPUT_PURCHASE_PRODUCT);
        return Console.readLine();
    }

    public String readPurchaseNoticeAnswer(PurchaseNoticeResult purchaseNoticeResult) {
        if (purchaseNoticeResult.notice() == Notice.MORE_QUANTITY) {
            System.out.printf(INPUT_MORE_QUANTITY, purchaseNoticeResult.orderItem().name(),
                    purchaseNoticeResult.quantity());
        }

        if (purchaseNoticeResult.notice() == Notice.NO_PROMOTION_APPLY) {
            System.out.printf(INPUT_NO_APPLY_PROMOTION, purchaseNoticeResult.orderItem().name(),
                    purchaseNoticeResult.quantity());
        }
        return Console.readLine();
    }

    public String inputMembershipDiscount() {
        System.out.println();
        System.out.println(INPUT_MEMBERSHIP_DISCOUNT);
        return Console.readLine();
    }
}
