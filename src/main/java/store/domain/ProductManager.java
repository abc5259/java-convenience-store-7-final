package store.domain;

import java.util.Map;

public class ProductManager {

    private final Map<Product, ProductInfos> products;

    public ProductManager(Map<Product, ProductInfos> products) {
        this.products = products;
    }
}
