package store.io;

import java.nio.file.Path;
import java.util.List;
import store.converter.Converter;
import store.domain.Promotion;

public class ProductInit {

    public static final Path PROMOTION_PATH = Path.of("src/main/resources/promotions.md");

    private final Converter<String, Promotion> converter;
    private final FileReader fileReader;

    public ProductInit(Converter<String, Promotion> converter, FileReader fileReader) {
        this.converter = converter;
        this.fileReader = fileReader;
    }

    public List<Promotion> init() {
        List<String> lines = fileReader.readAllLines(PROMOTION_PATH);
        return lines.stream()
                .map(converter::convert)
                .toList();
    }
}
