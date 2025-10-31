/**
 * Represents products for market inventory.
 *
 * @author Thomas Wen
 * @version 1
 */
public class Product {
    private String id;
    private int buyPrice;
    private int sellPrice;
    private int quantity;

    /**
     * Four-arg constructor.
     *
     * @param id product id
     * @param buyPrice product buy price
     * @param sellPrice product sell price
     * @param quantity product quantity
     */
    public Product(String id, int buyPrice, int sellPrice, int quantity) {
        this.id = id;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
    }

    /**
     * get id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * get buy price.
     *
     * @return the buy price
     */
    public int getBuyPrice() {
        return buyPrice;
    }

    /**
     * get sell price.
     *
     * @return the sell price
     */
    public int getSellPrice() {
        return sellPrice;
    }

    /**
     * get quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * set quantity.
     *
     * @param n the new quantity
     */
    public void setQuantity(int n) {
        quantity = n;
    }

    /**
     * to string.
     *
     * @return String representation of product
     */
    @Override
    public String toString() {
        return id + "," + buyPrice + "," + sellPrice + "," + quantity;
    }
}
