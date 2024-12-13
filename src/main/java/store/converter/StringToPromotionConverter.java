package store.converter;

import java.time.LocalDate;
import store.domain.Promotion;

public class StringToPromotionConverter implements Converter<String, Promotion> {
    @Override
    public Promotion convert(String source) {
        String[] sources = source.split(",");
        StringToIntConverter stringToIntConverter = new StringToIntConverter();

        if (sources.length != 5) {
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        return new Promotion(
                sources[0].trim(),
                stringToIntConverter.convert(sources[1].trim()),
                stringToIntConverter.convert(sources[2].trim()),
                LocalDate.parse(sources[3].trim()),
                LocalDate.parse(sources[4].trim())
        );
    }
}
