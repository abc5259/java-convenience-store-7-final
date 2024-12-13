package store.view;

public class OutputView {

    private static final String HELLO_MESSAGE = "안녕하세요. W편의점입니다.";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s%n";

    public void printHelloMessage() {
        System.out.println(HELLO_MESSAGE);
    }

    public void printErrorMessage(Exception exception) {
        System.out.printf(ERROR_MESSAGE_FORMAT, exception.getMessage());
    }
}
