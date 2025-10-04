//I worked on the homework assignment alone, using only course materials.

import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;

public class Apothecary {
    public static void main(String[] args) {
        System.out.print("Welcome to my apothecary! Please enter your name here: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (name.equals("")) {
            name = "Apprentice";
        }
        name = name.toLowerCase();
        char firstLetter = name.charAt(0);
        firstLetter -= 32;
        name = firstLetter + name.substring(1);
        System.out.println();
        System.out.print("Hello " + name + ", which potion do you want me to brew? ");
        String potion = scanner.nextLine().toLowerCase();
        switch(potion) {
            case "potion of clarity":
                System.out.print("The Potion of Clarity requires 2 Vials of Crystal Dew. How many would you like? ");
                break;
            case "elixir of agility":
                System.out.print("The Elixir of Agility requires 3 Swift Feathers. How many would you like? ");
                break;
            case "healing draught":
                System.out.print("The Healing Draught requires 1 Phoenix Feather and 2 Vials of Moonlit Dew. How many would you like? ");
                break;
            case "elixir of elemental power":
                System.out.print("The Elixir of Elemental Power requires 1 Vial of Moonlit Dew, 3 Lava Stones, and 2 Phoenix Feathers. How many would you like? ");
                break;
            case "death poison":
                System.out.println("GUARDS!");
                System.exit(0);
                break;
            default:
                System.out.println("I am sorry, I cannot brew that potion.");
                System.exit(0);
                break;
        }

        String input = scanner.nextLine();
        int num = 1;
        
        if(input.matches("\\d+")) {
            num = Integer.parseInt(input);
            if(num < 1) {
                num = 1;
            }
        }
        System.out.println();

        double cost=0;
        if(potion.equals("potion of clarity")) {
            System.out.print("How many Vials of Crystal Dew will you provide? ");
            int a = scanner.nextInt();
            cost += (a-(2*num)>=0) ? 0 : ((2*num)-a)*10;
            cost += 10 + 15*num;
        }
        if(potion.equals("elixir of agility")) {
            System.out.print("How many Swift Feathers will you provide? ");
            int b = scanner.nextInt();
            cost += (b-(3*num)>=0) ? 0 : ((3*num)-b)*20;
            cost += 10 + 15*num;
        }
        if(potion.equals("healing draught")) {
            System.out.print("How many Phoenix Feathers will you provide? ");
            int c = scanner.nextInt();
            cost += (c-(1*num)>=0) ? 0 : ((1*num)-c)*50;
            //System.out.println();
            System.out.print("How many Vials of Moonlit Dew will you provide? ");
            int d = scanner.nextInt();
            cost += (d-(2*num)>=0) ? 0 : ((2*num)-d)*15;
            cost += 20 + 25*num;
        }
        if(potion.equals("elixir of elemental power")) {
            System.out.print("How many Vials of Moonlit Dew will you provide? ");
            int e = scanner.nextInt();
            cost += (e-(1*num)>=0) ? 0 : ((1*num)-e)*15;
            //System.out.println();
            System.out.print("How many Lava Stones will you provide? ");
            int f = scanner.nextInt();
            cost += (f-(3*num)>=0) ? 0 : ((3*num)-f)*30;
            ///System.out.println();
            System.out.print("How many Phoenix Feathers will you provide? ");
            int g = scanner.nextInt();
            cost += (g-(2*num)>=0) ? 0 : ((2*num)-g)*50;
            cost += 20 + 25*num;
        }
        System.out.println();

        scanner.nextLine();
        System.out.print("Is there anything I should know? ");
        String discount = scanner.nextLine();
        if(discount.equals("The order is for the King")) {
            cost /= 2;
        }
        System.out.println();

        if(num > 1) {
            potion = (potion.equals("potion of clarity")) ? "Potions of Clarity" : potion;
            potion = (potion.equals("elixir of agility")) ? "Elixirs of Agility" : potion;
            potion = (potion.equals("healing draught")) ? "Healing Draughts" : potion;
            potion = (potion.equals("elixir of elemental power")) ? "Elixirs of Elemental Power" : potion;
        } else {
            potion = (potion.equals("potion of clarity")) ? "Potion of Clarity" : potion;
            potion = (potion.equals("elixir of agility")) ? "Elixir of Agility" : potion;
            potion = (potion.equals("healing draught")) ? "Healing Draught" : potion;
            potion = (potion.equals("elixir of elemental power")) ? "Elixir of Elemental Power" : potion;
        }

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        String finalCost = currencyFormatter.format(cost);
        System.out.println(name + ", thank you for requesting the " + potion + ". The cost is " + finalCost + ".");
    }
}
