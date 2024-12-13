package store.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProductTest {

    @ParameterizedTest
    @CsvSource({
            "7, 10, 2, 1, 4",
            "8, 10, 2, 1, 4",
            "9, 10, 2, 1, 1",
            "3, 10, 2, 1, 7",
            "3, 2, 2, 1, 0",
            "3, 1, 2, 1, 1",
            "5, 5, 1, 1, 1",
    })
    void 프로모션_혜택을_받지못하는_수량을_계산한다(
            int promotionQuantity,
            int purchaseQuantity,
            int buyCount,
            int freeCount,
            int expected) {
        //given
        LocalDate startDate = LocalDate.of(2024, 12, 11);
        LocalDate endDate = LocalDate.of(2024, 12, 14);
        Promotion promotion = new Promotion("test", buyCount, freeCount, startDate, endDate);
        Product product = new Product("test", 1000, promotion, 10, promotionQuantity);

        //when
        int result = product.calculateOutOfPromotionQuantity(purchaseQuantity, LocalDate.of(2024, 12, 12));

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "3, 2, 1",
            "4, 3, 0",
            "5, 3, 0",
            "5, 5, 0",
            "6, 5, 1",
            "20, 5, 1",
    })
    void 얼마나_더_프로모션_혜택을_받을_수_있는지_계산한다(int promotionQuantity, int purchaseQuantity, int expected) {
        //given
        LocalDate startDate = LocalDate.of(2024, 12, 11);
        LocalDate endDate = LocalDate.of(2024, 12, 14);
        Promotion promotion = new Promotion("test", 2, 1, startDate, endDate);
        Product product = new Product("test", 1000, promotion, 10, promotionQuantity);

        //when
        int result = product.calculatePromotionFreeQuantity(purchaseQuantity, LocalDate.of(2024, 12, 12));

        //then
        assertThat(result).isEqualTo(expected);
    }
}