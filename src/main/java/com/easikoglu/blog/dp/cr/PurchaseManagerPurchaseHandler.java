package com.easikoglu.blog.dp.cr;

import java.math.BigDecimal;

public class PurchaseManagerPurchaseHandler extends PurchaseHandler {

  public void handlePurchase(PurchaseRequest request) {
    // can handle if less than 1500$
    if (request.getAmount().compareTo(BigDecimal.valueOf(1500)) < 0) {
      System.out.println("Purchase Manager approved request");
    } else {
      successor.handlePurchase(request); // calling next handler.
    }
  }
}
