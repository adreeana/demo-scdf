package com.devoxxfr.scdf.demo.domain.child;

import com.devoxxfr.scdf.demo.domain.toy.Toy;

public class ChildService {
  public Wish makeAWish(Toy toy) {
    return new Wish(toy, "Wawwww, this toy is wonderful! Santa please bring it " +
      "to me.");
  }
}
