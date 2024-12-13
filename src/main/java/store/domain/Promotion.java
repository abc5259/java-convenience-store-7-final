package store.domain;

import java.time.LocalDate;

public class Promotion {
    private final String name;
    private final int buyCount;
    private final int freeCount;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Promotion(String name, int buyCount, int freeCount, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.buyCount = buyCount;
        this.freeCount = freeCount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isEqualName(String name) {
        return this.name.equals(name.trim());
    }

    public String getName() {
        return name;
    }

    public int getFreeCount() {
        return freeCount;
    }

    public boolean canMorePurchaseQuantity(int promotionQuantity, int purchaseQuantity) {
        if (purchaseQuantity + freeCount > promotionQuantity) {
            return false;
        }

        return purchaseQuantity % (buyCount + freeCount) == buyCount;
    }

    public int getTotalBenefitQuantity() {
        return buyCount + freeCount;
    }

    public boolean isApply(LocalDate date) {
        return (startDate.isEqual(date) || startDate.isBefore(date)) &&
                (endDate.isEqual(date) || endDate.isAfter(date));
    }
}
