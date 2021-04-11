package com.easikoglu.blog.dp.cr;

public abstract class PurchaseHandler {

    protected PurchaseHandler successor;

    public void setSuccessor(PurchaseHandler successor) {
        this.successor = successor;
    }

    public abstract void handlePurchase(PurchaseRequest request);
}
