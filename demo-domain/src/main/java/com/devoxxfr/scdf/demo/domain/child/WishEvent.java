package com.devoxxfr.scdf.demo.domain.child;

public class WishEvent {
  public static final WishEvent NO_WISH = new WishEvent();

  private Wish wish;

  public WishEvent() {
    wish = null;
  }

  public WishEvent(Wish wish) {
    this.wish = wish;
  }

  public Wish getWish() {
    return wish;
  }

  public void setWish(final Wish wish) {
    this.wish = wish;
  }

  public boolean wishMade() {
    return wish != null;
  }

  @Override
  public String toString() {
    return "WishEvent{" +
      wish +
      '}';
  }
}
