package store;

import store.controller.StoreController;
import store.io.PromotionInit;

public class Application {
    public static void main(String[] args) {
        StoreConfig storeConfig = new StoreConfig();
        PromotionInit promotionInit = storeConfig.promotionInit();
        promotionInit.init();
        
        StoreController storeController = storeConfig.storeController();
        storeController.process();
    }
}
