package com.easikoglu.blog.dp.cr;

import java.math.BigDecimal;

public class Demo {

  public static void main(String[] args) {

    GeneralManagerPurchaseHandler generalManager = new GeneralManagerPurchaseHandler();
    PurchaseManagerPurchaseHandler purchaseManager = new PurchaseManagerPurchaseHandler();
    DepartmentManagerPurchaseHandler departmentManager = new DepartmentManagerPurchaseHandler();
    LineManagerPurchaseHandler lineManager = new LineManagerPurchaseHandler();

    // setting up next handler from chain as successors due to handle all requests.
    lineManager.setNextHandler(departmentManager);
    departmentManager.setNextHandler(purchaseManager);
    purchaseManager.setNextHandler(generalManager);

    PurchaseRequest simpleReq = new PurchaseRequest();
    simpleReq.setType(PurchaseRequest.PurchaseType.ELECTRONIC);
    simpleReq.setAmount(new BigDecimal(999));

    lineManager.handlePurchase(simpleReq); //approved


    PurchaseRequest laptopReq = new PurchaseRequest();
    laptopReq.setType(PurchaseRequest.PurchaseType.ELECTRONIC);
    laptopReq.setAmount(new BigDecimal(1499));

    lineManager.handlePurchase(laptopReq); //send to deparmentManager


    PurchaseRequest furnitureReq = new PurchaseRequest();
    furnitureReq.setType(PurchaseRequest.PurchaseType.FURNITURE);
    furnitureReq.setAmount(new BigDecimal(1499));


    lineManager.handlePurchase(furnitureReq); //send to purchaseManager

    PurchaseRequest expensiveReq = new PurchaseRequest();
    expensiveReq.setType(PurchaseRequest.PurchaseType.FURNITURE);
    expensiveReq.setAmount(new BigDecimal(2000));

    lineManager.handlePurchase(expensiveReq); //send to generalManager

  }
}
