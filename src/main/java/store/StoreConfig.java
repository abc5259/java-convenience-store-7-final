package store;

import store.controller.IteratorInputHandler;
import store.controller.IteratorInputTemplate;
import store.controller.StoreController;
import store.converter.StringToPromotionConverter;
import store.io.FileReader;
import store.io.PromotionInit;
import store.view.InputView;
import store.view.OutputView;

public class StoreConfig {

    private InputView inputView;
    private OutputView outputView;
    private IteratorInputTemplate iteratorInputTemplate;
    private IteratorInputHandler iteratorInputHandler;
    private StoreController storeController;
    private FileReader fileReader;
    private PromotionInit promotionInit;

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public IteratorInputTemplate iteratorInputTemplate() {
        if (iteratorInputTemplate == null) {
            iteratorInputTemplate = new IteratorInputTemplate(outputView());
        }
        return iteratorInputTemplate;
    }

    public IteratorInputHandler iteratorInputHandler() {
        if (iteratorInputHandler == null) {
            iteratorInputHandler = new IteratorInputHandler(inputView(), iteratorInputTemplate());
        }
        return iteratorInputHandler;
    }

    public StoreController storeController() {
        if (storeController == null) {
            storeController = new StoreController(iteratorInputHandler(), outputView());
        }
        return storeController;
    }

    public FileReader fileReader() {
        if (fileReader == null) {
            fileReader = new FileReader();
        }
        return fileReader;
    }

    public PromotionInit promotionInit() {
        if (promotionInit == null) {
            promotionInit = new PromotionInit(new StringToPromotionConverter(), fileReader());
        }
        return promotionInit;
    }
}
