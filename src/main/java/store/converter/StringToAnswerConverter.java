package store.converter;

import store.domain.Answer;

public class StringToAnswerConverter implements Converter<String, Answer> {
    @Override
    public Answer convert(String source) {
        return Answer.findBySymbol(source.trim());
    }
}
