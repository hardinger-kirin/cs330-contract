public class Beverage {
  public Base base = null;
  public Boba boba = null;
  public Topping topping = null;

  public Beverage(Base base, Boba boba, Topping topping) {
    this.base = base;
    this.boba = boba;
    this.topping = topping;
  }

  public String getDescription() {
    return base.getDescription() + " tea with " + boba.getDescription() + " boba and " + topping.getDescription()
        + " on top.";
  }
}