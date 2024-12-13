package store.controller;


import camp.nextstep.edu.missionutils.DateTimes;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import store.domain.Answer;
import store.domain.Cart;
import store.domain.MembershipDiscount;
import store.domain.Notice;
import store.domain.OrderItem;
import store.domain.Product;
import store.domain.PurchaseNoticeResult;
import store.domain.Receipt;
import store.domain.Store;
import store.view.OutputView;

public class StoreController {

    private final IteratorInputHandler iteratorInputHandler;
    private final OutputView outputView;

    public StoreController(IteratorInputHandler iteratorInputHandler, OutputView outputView) {
        this.iteratorInputHandler = iteratorInputHandler;
        this.outputView = outputView;
    }

    public void process(Map<String, Product> products) {
        Store store = new Store(products);
        outputView.printHelloMessage();
        outputView.printProducts(store.getProducts());

        Cart cart = iteratorInputHandler.inputCart(store);
        List<PurchaseNoticeResult> purchaseNoticeResults = store.calculatePurchaseNoticeResults(
                cart, DateTimes.now().toLocalDate());

        List<OrderItem> newOrderItems = new ArrayList<>();
        for (PurchaseNoticeResult purchaseNoticeResult : purchaseNoticeResults) {
            if (purchaseNoticeResult.notice() == Notice.GOOD) {
                newOrderItems.add(purchaseNoticeResult.orderItem());
                continue;
            }
            Answer answer = iteratorInputHandler.inputPurchaseNoticeResultAnswer(purchaseNoticeResult);
            newOrderItems.add(purchaseNoticeResult.calculateNewOrderItem(answer));
        }
        Answer answer = iteratorInputHandler.inputMembershipDiscountAnswer();
        MembershipDiscount memberShipDiscount = new MembershipDiscount(answer);
        Receipt receipt = store.purchase(cart, memberShipDiscount, DateTimes.now().toLocalDate());
    }
}
