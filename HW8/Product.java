/**
 * Represents products for market inventory;
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
     * @param id
     * @param buyPrice
     * @param sellPrice
     * @param quantity
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
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * get buy price.
     * 
     * @return
     */
    public int getBuyPrice() {
        return buyPrice;
    }

    /**
     * get sell price.
     * 
     * @return
     */
    public int getSellPrice() {
        return sellPrice;
    }

    /**
     * get quantity.
     * 
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * set id.
     * 
     * @param str
     */
    public void setId(String str) {
        id = str;
    }

    /**
     * set buy price.
     * 
     * @param n
     */
    public void setBuyPrice(int n) {
        buyPrice = n;
    }

    /**
     * set sell price.
     * 
     * @param n
     */
    public void setSellPrice(int n) {
        sellPrice = n;
    }

    /**
     * set quantity.
     * 
     * @param n
     */
    public void setQuantity(int n) {
        quantity = n;
    }

    /**
     * to string.
     * 
     * @return
     */
    @Override
    public String toString() {
        return id + "," + buyPrice + "," + sellPrice + "," + quantity;
    }
}
