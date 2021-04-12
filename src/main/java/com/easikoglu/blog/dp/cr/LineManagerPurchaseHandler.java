package com.easikoglu.blog.dp.cr;

import java.math.BigDecimal;

public class LineManagerPurchaseHandler extends PurchaseHandler {

  public void handlePurchase(PurchaseRequest request) {
    // can handle if less than 1000$
    if (request.getAmount().compareTo(BigDecimal.valueOf(1000)) < 0) {
      System.out.println("Line Manager approved the purchase request");
    } else {
      nextHandler.handlePurchase(request); // calling next handler.
    }
  }
}
