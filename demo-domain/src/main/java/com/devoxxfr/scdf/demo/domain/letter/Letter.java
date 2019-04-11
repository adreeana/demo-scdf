package com.devoxxfr.scdf.demo.domain.letter;

import com.devoxxfr.scdf.demo.domain.child.Wish;
import com.devoxxfr.scdf.demo.domain.toy.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Letter {
  private final List<Wish> wishes;
  private int allowedWishesNumber;

  public Letter() {
    this(10);
  }

  public Letter(final int allowedWishesNumber) {
    this.allowedWishesNumber = allowedWishesNumber;
    wishes = new ArrayList<>();
  }

  public int addWish(Wish wish) {
    if (! finished()) {
      this.wishes.add(wish);
    }
    return wishes.size();
  }

  public String santasLetter() {
    return wishes.stream()
      .limit(allowedWishesNumber)
      .map(item -> item.toString())
      .collect(Collectors.joining(","));
  }

  public boolean finished() {
    return wishes.size() == allowedWishesNumber;
  }

  @Override
  public String toString() {
    return "Santa's Letter{" +
      "wishes: " +
      santasLetter() +
      '}';
  }
}
