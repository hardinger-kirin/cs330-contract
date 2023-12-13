import java.util.ArrayList;

public class BeverageFactory {
  ArrayList<Base> bases = new ArrayList<Base>();
  ArrayList<Boba> bobas = new ArrayList<Boba>();
  ArrayList<Topping> toppings = new ArrayList<Topping>();

  public BeverageFactory() {
    this.bases.add(new Base("Strawberry"));
    this.bases.add(new Base("Choco"));
    this.bases.add(new Base("Matcha"));
    this.bases.add(new Base("Taro"));
    this.bases.add(new Base("Coconut"));
    this.bases.add(new Base("Mango"));

    this.bobas.add(new Boba("Strawberry"));
    this.bobas.add(new Boba("Lychee"));
    this.bobas.add(new Boba("Apple"));
    this.bobas.add(new Boba("Peach"));
    this.bobas.add(new Boba("Mango"));
    this.bobas.add(new Boba("Plain"));

    this.toppings.add(new Topping("Cocoa Powder"));
    this.toppings.add(new Topping("Matcha Powder"));
    this.toppings.add(new Topping("Mango Syrup"));
    this.toppings.add(new Topping("Whipcream"));
    this.toppings.add(new Topping("Chocolate Syrup"));
    this.toppings.add(new Topping("Strawberry Syrup"));
  }

  public Beverage createRandomBeverage() {
    return new Beverage(bases.get((int) (Math.random() * bases.size())),
        bobas.get((int) (Math.random() * bobas.size())), toppings.get((int) (Math.random() * toppings.size())));
  }

  public ArrayList<Base> getBases() {
    return this.bases;
  }

  public ArrayList<Boba> getBobas() {
    return this.bobas;
  }

  public ArrayList<Topping> getToppings() {
    return this.toppings;
  }
}