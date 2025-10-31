//I worked on the homework assignment alone, using only course materials.

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Used to manage market inventory.
 * 
 * @author Thomas Wen
 * @version 1
 */
public class MarketInventoryManager {
    private Product[] products;
    private int money;

    /**
     * Two-arg constructor.
     * 
     * @param products
     * @param money
     */
    private MarketInventoryManager(Product[] products, int money) {
        this.products = products;
        this.money = money;
    }

    /**
     * market inventory manager.
     * 
     * @param f
     * @return
     * @throws IOException
     * @throws MalformedInventoryFileException
     */
    public static MarketInventoryManager fromFile(File f) throws IOException, MalformedInventoryFileException {
        Scanner scanner = null;
        try {
            scanner = new Scanner(f);

            if (!scanner.hasNextLine()) {
                throw new MalformedInventoryFileException("Invalid inventory header");
            }

            String header = scanner.nextLine();
            String[] headerParts = header.split(" ");

            if (headerParts.length != 2) {
                throw new MalformedInventoryFileException("Invalid inventory header");
            }

            int numProducts;
            int currentMoney;
            try {
                numProducts = Integer.parseInt(headerParts[0]);
                currentMoney = Integer.parseInt(headerParts[1]);

                if (numProducts < 0 || currentMoney < 0) {
                    throw new MalformedInventoryFileException("Invalid inventory header");
                }
            } catch (NumberFormatException e) {
                throw new MalformedInventoryFileException("Invalid inventory header");
            }

            Product[] products = new Product[numProducts];

            for (int i = 0; i < numProducts; i++) {
                if (!scanner.hasNextLine()) {
                    throw new MalformedInventoryFileException("Product information incomplete");
                }

                int productNumber = i + 1;
                String line = scanner.nextLine();
                String[] lineParts = line.split(",");
                if (lineParts.length != 4) {
                    throw new MalformedInventoryFileException(
                            "Product information invalid for product " + productNumber);
                }

                if (lineParts[0].equals("") || lineParts[0].contains(" ")) {
                    throw new MalformedInventoryFileException(
                            "Product information invalid for product " + productNumber);
                }

                for (int j = 0; j < i; j++) {
                    if (products[j].getId().equals(lineParts[0])) {
                        throw new MalformedInventoryFileException("Duplicate product ID: " + lineParts[0]);
                    }
                }

                int buyPrice, sellPrice, quantity;
                try {
                    buyPrice = Integer.parseInt(lineParts[1]);
                    sellPrice = Integer.parseInt(lineParts[2]);
                    quantity = Integer.parseInt(lineParts[3]);

                    if (buyPrice < 0 || sellPrice < 0 || quantity < 0) {
                        throw new MalformedInventoryFileException(
                                "Product information invalid for product " + productNumber);
                    }
                } catch (NumberFormatException e) {
                    throw new MalformedInventoryFileException(
                            "Product information invalid for product " + productNumber);
                }

                products[i] = new Product(lineParts[0], buyPrice, sellPrice, quantity);
            }

            return new MarketInventoryManager(products, currentMoney);

        } catch (IOException e) {
            throw e;
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Used when buying products from suppliers.
     * 
     * @param id
     * @param quantity
     * @throws CannotFulfillTransactionException
     */
    public void buy(String id, int quantity) throws CannotFulfillTransactionException {
        if (quantity < 0) {
            throw new CannotFulfillTransactionException("Quantity is negative");
        }

        int idIndex = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId().equals(id)) {
                idIndex = i;
                break;
            }
        }
        if (idIndex < 0) {
            throw new CannotFulfillTransactionException("Product ID not found");
        }

        if (money < products[idIndex].getBuyPrice() * quantity) {
            throw new CannotFulfillTransactionException("Not enough money to buy");
        }

        products[idIndex].setQuantity(products[idIndex].getQuantity() + quantity);
        money -= products[idIndex].getBuyPrice() * quantity;
    }

    /**
     * Sell products.
     * 
     * @param id
     * @param quantity
     * @throws CannotFulfillTransactionException
     */
    public void sell(String id, int quantity) throws CannotFulfillTransactionException {
        if (quantity < 0) {
            throw new CannotFulfillTransactionException("Quantity is negative");
        }

        int idIndex = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId().equals(id)) {
                idIndex = i;
                break;
            }
        }
        if (idIndex < 0) {
            throw new CannotFulfillTransactionException("Product ID not found");
        }

        if (products[idIndex].getQuantity() < quantity) {
            throw new CannotFulfillTransactionException("Not enough quantity to sell");
        }

        products[idIndex].setQuantity(products[idIndex].getQuantity() - quantity);
        money += products[idIndex].getSellPrice() * quantity;
    }

    /**
     * Return ids.
     * 
     * @return
     */
    public String[] marketProducts() {
        String[] ids = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            ids[i] = products[i].getId();
        }

        return ids;
    }

    /**
     * Save to a file.
     * 
     * @param f
     * @throws IOException
     */
    public void saveToFile(File f) throws IOException {
        PrintWriter p = null;

        try {
            p = new PrintWriter(f);
            p.println(products.length + " " + money);
            for (Product a : products) {
                p.println(a.getId() + "," + a.getBuyPrice() + "," + a.getSellPrice() + "," + a.getQuantity());
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (p != null) {
                p.close();
            }
        }
    }

    /**
     * Main method.
     * 
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java MarketInventoryManager <inventory-file>");
            System.exit(1);
        }

        MarketInventoryManager m = null;
        File file = null;

        try {
            file = new File(args[0]);
            m = MarketInventoryManager.fromFile(file);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }

        Scanner scanner = new Scanner(System.in);
        boolean inCommand = true;
        while (inCommand) {
            System.out.print("> ");
            String line = scanner.nextLine();

            if (line.equals("quit")) {
                inCommand = false;
                continue;
            }

            if (line.equals("products")) {
                String[] products = m.marketProducts();
                if (products.length > 0) {
                    System.out.print(products[0]);
                    for (int i = 1; i < products.length; i++) {
                        System.out.print(", " + products[i]);
                    }
                    System.out.println();
                }
                continue;
            }

            if (line.startsWith("buy ")) {
                String[] buy = line.split(" ");
                if (buy.length != 3) {
                    System.out.println("Error: Invalid command");
                    continue;
                }
                try {
                    m.buy(buy[1], Integer.parseInt(buy[2]));
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid command");
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                continue;
            }

            if (line.startsWith("sell ")) {
                String[] sell = line.split(" ");
                if (sell.length != 3) {
                    System.out.println("Error: Invalid command");
                    continue;
                }
                try {
                    m.sell(sell[1], Integer.parseInt(sell[2]));
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid command");
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                continue;
            }

            System.out.println("Error: Invalid command");
        }

        if (scanner != null) {
            scanner.close();
        }

        try {
            m.saveToFile(file);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
