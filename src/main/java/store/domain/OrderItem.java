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

    public OrderItem incrementCount(int count) {
        return new OrderItem(name, this.count + count);
    }

    public OrderItem decrementCount(int count) {
        return new OrderItem(name, this.count - count);
    }
}
