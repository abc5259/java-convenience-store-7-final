package store.controller;

import store.converter.StringToCartConverter;
import store.domain.Cart;
import store.domain.Store;
import store.view.InputView;

public class IteratorInputHandler {

    private final InputView inputView;
    private final IteratorInputTemplate iteratorInputTemplate;

    public IteratorInputHandler(InputView inputView, IteratorInputTemplate iteratorInputTemplate) {
        this.inputView = inputView;
        this.iteratorInputTemplate = iteratorInputTemplate;
    }

    public Cart inputCart(Store store) {
        StringToCartConverter stringToCartConverter = new StringToCartConverter();
        return iteratorInputTemplate.execute(
                inputView::readPurchaseProduct,
                value -> {
                    Cart cart = stringToCartConverter.convert(value);
                    store.validatePurchase(cart);
                    return cart;
                }
        );
    }
}
