package store.domain;

public class SimpleProductInfo implements ProductInfo {

    private final Product product;
    private final int quantity;

    public SimpleProductInfo(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
