package com.devoxxfr.scdf.demo.domain.toy;

import java.util.Objects;

public class Toy {
  private String codeBar;

  public Toy() {
  }

  public Toy(final String codeBar) {
    this.codeBar = codeBar;
  }

  public String getCodeBar() {
    return codeBar;
  }

  public void setCodeBar(final String codeBar) {
    this.codeBar = codeBar;
  }

  @Override
  public int hashCode() {
    return Objects.hash(codeBar);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Toy toy = (Toy) o;
    return Objects.equals(codeBar, toy.codeBar);
  }

  @Override
  public String toString() {
    return "Toy{" +
      codeBar +
      '}';
  }
}
