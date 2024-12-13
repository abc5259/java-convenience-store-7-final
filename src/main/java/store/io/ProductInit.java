package store.io;

import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import store.converter.StringToIntConverter;
import store.domain.Product;
import store.domain.Promotion;

public class ProductInit {

    public static final Path PRODUCT_PATH = Path.of("src/main/resources/products.md");

    private final FileReader fileReader;

    public ProductInit(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public Map<String, Product> init(List<Promotion> promotions) {
        List<String> lines = fileReader.readAllLines(PRODUCT_PATH);

        Map<String, Product> products = new LinkedHashMap<>();
        StringToIntConverter stringToIntConverter = new StringToIntConverter();
        for (String line : lines) {
            String[] sources = line.split(",");
            if (sources.length != 4) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
            String name = sources[0].trim();
            int price = stringToIntConverter.convert(sources[1].trim());
            int quantity = stringToIntConverter.convert(sources[2].trim());
            String promotionName = sources[3].trim();
            Promotion promotion = promotions.stream()
                    .filter(promo -> promo.isEqualName(promotionName))
                    .findFirst().orElse(null);
            putProduct(products, name, promotion, quantity, price);
        }

        return products;
    }

    private void putProduct(Map<String, Product> products,
                            String name,
                            Promotion promotion,
                            int quantity,
                            int price) {
        if (products.containsKey(name)) {
            incrementQuantity(products, name, promotion, quantity);
            return;
        }
        Product product = new Product(name, price, promotion, quantity);
        products.put(name, product);
    }

    private void incrementQuantity(Map<String, Product> products, String name, Promotion promotion,
                                   int quantity) {
        Product product = products.get(name);
        if (promotion == null) {
            product.incrementSimpleQuantity(quantity);
            return;
        }
        product.incrementPromotionQuantity(quantity);
    }
}
