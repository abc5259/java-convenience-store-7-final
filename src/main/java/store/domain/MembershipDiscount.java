package store.domain;

public class MembershipDiscount {

    private static final int MAX_DISCOUNT_AMOUNT = 8000;

    private final Answer answer;

    public MembershipDiscount(Answer answer) {
        this.answer = answer;
    }

    public int calculateDiscountAmount(Receipt receipt) {
        if (answer == Answer.NO) {
            return 0;
        }

        int amount = (int) (receipt.getTotalPromotionNotApplyAmount()
                - receipt.getTotalPromotionNotApplyAmount() * 0.3);
        return Math.min(amount, MAX_DISCOUNT_AMOUNT);
    }
}
