package com.devoxxfr.scdf.demo.domain.child;

import com.devoxxfr.scdf.demo.domain.toy.Toy;

public class Wish {
  private Toy toy;
  private String reason;

  public Wish() {
  }

  public Wish(final Toy toy, final String reason) {
    this.toy = toy;
    this.reason = reason;
  }

  public Toy getToy() {
    return toy;
  }

  public void setToy(final Toy toy) {
    this.toy = toy;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(final String reason) {
    this.reason = reason;
  }

  @Override
  public String toString() {
    return "Wish{" +
      toy +
      ", " + reason +
      '}';
  }
}
