package com.easikoglu.blog.dp.cr;

public abstract class PurchaseHandler {

    protected PurchaseHandler nextHandler;

    public void setNextHandler(PurchaseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract void handlePurchase(PurchaseRequest request);
}
