package store.domain;

public record PurchaseInfo(
        String name,
        int price,
        int quantity
) {
    public int calculatePrice() {
        return price * quantity;
    }
}
