package machine;
import java.util.Scanner;

public class CoffeeMachine{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        getVariables(scanner);
    }
    private static void setup (int water, int milk, int coffeeBeans, int disposableCups, int money, Scanner scanner) {
        String decision;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            decision = scanner.nextLine();
            switch (decision) {
                case "buy" -> buyADrink(water, milk, coffeeBeans, disposableCups, money, scanner);
                case "fill" -> fillMachine(water, milk, coffeeBeans, disposableCups, money, scanner);
                case "remaining" -> remainingStats(water, milk, coffeeBeans, disposableCups, money, scanner);
                case "take" -> takeMoney(water, milk, coffeeBeans, disposableCups, money, scanner);
                case "exit" -> System.exit(0);
            }
        } while (scanner.hasNext());
    }

    private static void remainingStats(int water, int milk, int coffeeBeans, int disposableCups, int money, Scanner scanner) {
        System.out.println("\nThe coffee machine has:\n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                coffeeBeans + " g of coffee beans\n" +
                disposableCups + " disposable cups\n" +
                "$" + money + " of money\n");
        setup(water, milk, coffeeBeans, disposableCups, money, scanner);

    }

    private static void getVariables(Scanner scanner) {
        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int disposableCups = 9;
        int money = 550;

        setup(water, milk, coffeeBeans, disposableCups, money, scanner);
    }
    private static void buyADrink(int water, int milk, int coffeeBeans, int disposableCups, int money, Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String input = scanner.nextLine();

        switch (input) {
            case "1" -> {
                if (water < 250) {
                    System.out.println("\nSorry, not enough water!\n");
                } else if (coffeeBeans < 16) {
                    System.out.println("\nSorry, not enough coffee beans!\n");
                } else if (disposableCups < 1) {
                    System.out.println("\nSorry, not enough disposable cups!\n");
                } else{
                    System.out.println("I have enough resources, making you a coffee!\n");
                    water = water - 250;
                    coffeeBeans = coffeeBeans - 16;
                    disposableCups = disposableCups - 1;
                    money = money + 4;
                }
            }
            case "2" -> {
                if (water < 350) {
                    System.out.println("\nSorry, not enough water!\n");
                } else if (milk < 75) {
                    System.out.println("\nSorry, not enough milk!\n");
                } else if (coffeeBeans < 20) {
                    System.out.println("\nSorry, not enough coffee beans!\n");
                } else if (disposableCups < 1) {
                    System.out.println("\nSorry, not enough disposable cups!\n");
                } else {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    water = water - 350;
                    milk = milk - 75;
                    coffeeBeans = coffeeBeans - 20;
                    disposableCups = disposableCups - 1;
                    money = money + 7;
                }
            }
            case "3" -> {
                System.out.println("I have enough resources, making you a coffee!\n");
                if (water < 200) {
                    System.out.println("\nSorry, not enough water!\n");
                } else if (milk < 100) {
                    System.out.println("\nSorry, not enough milk!\n");
                } else if (coffeeBeans < 12) {
                    System.out.println("\nSorry, not enough coffee beans!\n");
                } else if (disposableCups < 1) {
                    System.out.println("\nSorry, not enough disposable cups!\n");
                } else {
                    water = water - 200;
                    milk = milk - 100;
                    coffeeBeans = coffeeBeans - 12;
                    disposableCups = disposableCups - 1;
                    money = money + 6;
                }
            }
            case "back" -> setup(water, milk, coffeeBeans, disposableCups, money, scanner);
        }
        setup(water, milk, coffeeBeans, disposableCups, money, scanner);
    }
    private static void fillMachine(int water, int milk, int coffeeBeans, int disposableCups, int money, Scanner scanner) {
        int waterToAdd;
        int milkToAdd;
        int coffeeBeansToAdd;
        int disposableCupsToAdd;

        System.out.println("Write how many ml of water you want to add:");
        waterToAdd = scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        milkToAdd = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeansToAdd = scanner.nextInt();

        System.out.println("Write how many disposable cups you want to add:");
        disposableCupsToAdd = scanner.nextInt();

        water = water + waterToAdd;
        milk = milk + milkToAdd;
        coffeeBeans = coffeeBeans + coffeeBeansToAdd;
        disposableCups = disposableCups + disposableCupsToAdd;


        setup(water, milk, coffeeBeans, disposableCups, money, scanner);
    }
    private static void takeMoney(int water, int milk, int coffeeBeans, int disposableCups, int money, Scanner scanner) {
        System.out.println("\nI gave you $" + money +"\n");
        money = 0;
        setup(water, milk, coffeeBeans, disposableCups, money, scanner);
    }
}
