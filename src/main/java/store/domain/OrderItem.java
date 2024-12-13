package store.domain;

public record OrderItem(
        String name,
        int count
) {
    public OrderItem {
        if (count <= 0) {
            throw new IllegalArgumentException("잘못된 입력입니다. 다시 입력해 주세요.");
        }
    }
}
