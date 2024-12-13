package store.domain;

public record PurchaseNoticeResult(
        OrderItem orderItem,
        Notice notice,
        int quantity
) {

    public OrderItem calculateNewOrderItem(Answer answer) {
        if (notice == Notice.MORE_QUANTITY && answer == Answer.YES) {

            return orderItem.incrementCount(quantity);
        }

        if (notice == Notice.NO_PROMOTION_APPLY && answer == Answer.NO) {
            return orderItem.decrementCount(quantity);
        }

        return orderItem;
    }
}
