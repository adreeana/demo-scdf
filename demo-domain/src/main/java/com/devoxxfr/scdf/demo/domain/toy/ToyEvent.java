package com.devoxxfr.scdf.demo.domain.toy;

public class ToyEvent {
  private Toy toy;
  private Boolean availability;

  public ToyEvent() {
    this.availability = false;
  }

  public ToyEvent(final Toy toy, final Boolean availability) {
    this.toy = toy;
    this.availability = availability;
  }

  public Toy getToy() {
    return toy;
  }

  public Boolean getAvailability() {
    return availability;
  }

  public void setToy(final Toy toy) {
    this.toy = toy;
  }

  public void setAvailability(final Boolean availability) {
    this.availability = availability;
  }

  @Override
  public String toString() {
    return "ToyEvent{"
      + toy +
      ", " + availability +
      '}';
  }
}
