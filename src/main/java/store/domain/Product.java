package store.domain;

public class Product {
    private final String name;
    private final int price;
    private final Promotion promotion;
    private int simpleProductQuantity;
    private int promotionQuantity;

    public Product(String name, int price, Promotion promotion, int simpleProductQuantity, int promotionQuantity) {
        this.name = name;
        this.price = price;
        this.promotion = promotion;
        this.simpleProductQuantity = simpleProductQuantity;
        this.promotionQuantity = promotionQuantity;
    }

    public Product(String name, int price, Promotion promotion, int quantity) {
        this.name = name;
        this.price = price;
        this.promotion = promotion;
        if (promotion == null) {
            this.promotionQuantity = 0;
            this.simpleProductQuantity = quantity;
            return;
        }
        this.promotionQuantity = quantity;
        this.simpleProductQuantity = 0;
    }

    public void incrementSimpleQuantity(int quantity) {
        this.simpleProductQuantity += quantity;
    }

    public void incrementPromotionQuantity(int quantity) {
        this.promotionQuantity += quantity;
    }
}
