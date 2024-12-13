package store;

import java.util.List;
import java.util.Map;
import store.controller.StoreController;
import store.domain.Product;
import store.domain.Promotion;
import store.io.ProductInit;
import store.io.PromotionInit;

public class Application {
    public static void main(String[] args) {
        StoreConfig storeConfig = new StoreConfig();
        PromotionInit promotionInit = storeConfig.promotionInit();
        ProductInit productInit = storeConfig.productInit();
        StoreController storeController = storeConfig.storeController();

        List<Promotion> promotions = promotionInit.init();
        Map<String, Product> products = productInit.init(promotions);
        storeController.process(products);
    }
}
