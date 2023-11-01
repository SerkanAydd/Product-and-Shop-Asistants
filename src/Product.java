public class Product {
    private int ID;
    private String productName;
    private double price;
    public Product(int ID, String productName, double price) {
        this.ID = ID;
        this.productName = productName;
        this.price = price;
    }
    public int getID() {
        return ID;
    }
    public String getProductName() {
        return productName;
    }
    public double getPrice() {
        return price;
    }
    public String toString() {
        return ID + "; " + productName + "; " + price;
    }
    public boolean equals(Product other) {
        return toString().equals(other.toString());
    }
}
