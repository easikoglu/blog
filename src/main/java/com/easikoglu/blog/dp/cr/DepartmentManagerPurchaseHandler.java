package com.easikoglu.blog.dp.cr;

import java.math.BigDecimal;

public class DepartmentManagerPurchaseHandler extends PurchaseHandler {

  public void handlePurchase(PurchaseRequest request) {
    // can handle if less than 1500$ if it is not furniture
    if (request.getAmount().compareTo(BigDecimal.valueOf(1500)) < 0
        && !PurchaseRequest.PurchaseType.FURNITURE.equals(request.getType())) {
      System.out.println("Department Manager approved the purchase request");
    } else {
      successor.handlePurchase(request); // calling next handler.
    }
  }
}
