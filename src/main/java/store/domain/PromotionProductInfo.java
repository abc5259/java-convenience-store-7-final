package store.domain;

public class PromotionProductInfo implements ProductInfo {

    private final Promotion promotion;
    private final Product product;
    private final int quantity;

    public PromotionProductInfo(Promotion promotion, Product product, int quantity) {
        this.promotion = promotion;
        this.product = product;
        this.quantity = quantity;
    }
}
