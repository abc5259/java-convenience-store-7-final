package store.controller;


import java.util.Map;
import store.domain.Cart;
import store.domain.Product;
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
        outputView.printHelloMessage();
        outputView.printProducts(products);
        Store store = new Store(products);

        Cart cart = iteratorInputHandler.inputCart(store);
    }
}
