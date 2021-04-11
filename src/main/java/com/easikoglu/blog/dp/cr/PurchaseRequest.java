package com.easikoglu.blog.dp.cr;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PurchaseRequest {

  private PurchaseType type;
  private BigDecimal amount;

  public enum PurchaseType {
    FURNITURE,
    ELECTRONIC
  }
}
