package store.domain;

import java.util.Arrays;

public enum Answer {
    YES("Y"), NO("N");

    private final String symbol;

    Answer(String symbol) {
        this.symbol = symbol;
    }

    public static Answer findBySymbol(String symbol) {
        return Arrays.stream(Answer.values())
                .filter(day -> day.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된입력입니다. 다시입력해주세요."));
    }
}
