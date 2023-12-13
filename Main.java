import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    ////////////////////////////////////////////////////
    // Factory
    ////////////////////////////////////////////////////
    BeverageFactory beverageFactory = new BeverageFactory();

    ////////////////////////////////////////////////////
    // Intro
    ////////////////////////////////////////////////////
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to your new boba café!");
    System.out.print("Enter a name for your café: ");
    String cafeName = scanner.nextLine();
    SaveFile saveFile = SaveFile.getInstance(cafeName);

    ////////////////////////////////////////////////////
    // Main game loop
    ////////////////////////////////////////////////////
    int day = 1;
    int num_right = 0;
    int total_customers = 0;
    String cont;
    do {
      cont = "";
      System.out.println("\n~~~~~~~~~~\nDay " + day + " at " + cafeName + " Café\n~~~~~~~~~~\n");
      int num_customers = (int) (Math.round((day + 1.5) * 1.2));
      total_customers += num_customers;

      ////////////////////////////////////////////////////
      // Day loop
      ////////////////////////////////////////////////////
      for (int i = 0; i < num_customers; i++) {
        // generate random beverage
        Beverage beverage = beverageFactory.createRandomBeverage();
        System.out.println("Customer ordered: " + beverage.getDescription());

        // prompt user when ready to memorize the order
        String ready = "";
        do {
          System.out.print("Ready to make it? [yes]: ");
          ready = scanner.next();
        } while (!ready.equals("yes"));
        // clear console

        System.out.print("\033[H\033[2J");
        System.out.flush();

        // pick base
        for (int j = 0; j < beverageFactory.getBases().size(); j++) {
          System.out.println((j + 1) + ". " + beverageFactory.getBases().get(j).getDescription());
        }
        System.out.print("Choose a base: ");
        int baseChoice = scanner.nextInt();
        Base base = new Base(beverageFactory.getBases().get(baseChoice - 1).getDescription());

        // pick boba
        for (int k = 0; k < beverageFactory.getBobas().size(); k++) {
          System.out.println((k + 1) + ". " + beverageFactory.getBobas().get(k).getDescription());
        }
        System.out.print("Choose a boba: ");
        int bobaChoice = scanner.nextInt();
        Boba boba = new Boba(beverageFactory.getBobas().get(bobaChoice - 1).getDescription());

        // pick topping
        for (int h = 0; h < beverageFactory.getToppings().size(); h++) {
          System.out.println((h + 1) + ". " + beverageFactory.getToppings().get(h).getDescription());
        }
        System.out.print("Choose a topping: ");
        int toppingChoice = scanner.nextInt();
        Topping topping = new Topping(beverageFactory.getToppings().get(toppingChoice - 1).getDescription());

        // create drink and check for correctness
        Beverage createdDrink = new Beverage(base, boba, topping);
        if (createdDrink.getDescription().equals(beverage.getDescription())) {
          System.out.println("You made it!");
          num_right++;
        } else {
          System.out.println("You didn't make it... :(");
        }
      }

      // ask to move on to next day
      while (!cont.equals("yes") && !cont.equals("no")) {
        System.out.print("Would you like to move on to day " + (day + 1) + "? [yes or no]: ");
        cont = scanner.next();
      }

      if (cont.equals("yes")) {
        day++;
      }
    } while (cont.equals("yes"));

    ////////////////////////////////////////////////////
    // End game
    ////////////////////////////////////////////////////
    saveFile.saveInfo(cafeName, num_right);
    System.out.println("Congratulations! You served a total of " + total_customers + " customers for " + day
        + " days.\nYou earned " + num_right + "/" + total_customers + " points.\nCome play again soon! :)");

    scanner.close();
  }
}