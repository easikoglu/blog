package com.easikoglu.blog.dp.cr;

public class GeneralManagerPurchaseHandler extends PurchaseHandler {

  public void handlePurchase(PurchaseRequest request) {
    // can handle everything

    System.out.println("GM approved the purchase request");
  }
}
