package store.domain;

import java.time.LocalDate;

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

    public boolean hasPromotion() {
        return this.promotion != null;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getSimpleProductQuantity() {
        return simpleProductQuantity;
    }

    public int getPromotionQuantity() {
        return promotionQuantity;
    }

    public String getPromotionName() {
        return promotion.getName();
    }

    public boolean canPurchase(int count) {
        return this.simpleProductQuantity + this.promotionQuantity >= count;
    }

    public boolean canMorePurchaseQuantity(int purchaseQuantity, LocalDate date) {
        if (isNotApplyPromotion(date)) {
            return false;
        }
        return promotion.canMorePurchaseQuantity(promotionQuantity, purchaseQuantity);
    }

    public int calculatePromotionFreeQuantity(int purchaseQuantity, LocalDate date) {
        if (!canMorePurchaseQuantity(purchaseQuantity, date)) {
            return 0;
        }
        return promotion.getFreeCount();
    }

    public int calculateOutOfPromotionQuantity(int purchaseQuantity, LocalDate date) {
        if (isNotApplyPromotion(date)) {
            return 0;
        }
        if (canMorePurchaseQuantity(purchaseQuantity, date)) {
            return 0;
        }

        int totalBenefitQuantity = promotion.getTotalBenefitQuantity();
        int currPromotionQuantity = promotionQuantity;
        int currPurchaseQuantity = purchaseQuantity;
        int count = 0;
        while (currPromotionQuantity - totalBenefitQuantity >= 0 && currPurchaseQuantity > 0) {
            currPromotionQuantity -= totalBenefitQuantity;
            currPurchaseQuantity -= totalBenefitQuantity;
            count++;
        }

        if (currPurchaseQuantity < 0) {
            return purchaseQuantity;
        }

        return purchaseQuantity - count * totalBenefitQuantity;
    }

    private boolean isNotApplyPromotion(LocalDate date) {
        if (promotion == null || !promotion.isApply(date)) {
            return true;
        }
        return false;
    }
}
