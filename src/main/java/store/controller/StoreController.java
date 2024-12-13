package store.controller;


import store.view.OutputView;

public class StoreController {

    private final IteratorInputHandler iteratorInputHandler;
    private final OutputView outputView;

    public StoreController(IteratorInputHandler iteratorInputHandler, OutputView outputView) {
        this.iteratorInputHandler = iteratorInputHandler;
        this.outputView = outputView;
    }

    public void process() {

    }
}
