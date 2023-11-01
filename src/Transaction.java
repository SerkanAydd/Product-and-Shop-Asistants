public class Transaction {
    int ID;
    Product[] products;
    double totalPrice;
    double transactionFee;
    public Transaction(int ID, Product[] products, double totalPrice, double transactionFee) {
        this.ID = ID;
        this.products = products;
        this.totalPrice = totalPrice;
        this.transactionFee = transactionFee;
    }
    public int getID() {
        return ID;
    }
    public Product[] getProducts() {
        return products;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public double getTransactionFee() {
        return transactionFee;
    }
    public String toString() {
        return ID + "; " + products[0] + ", " + products[1] + ", " + products[2] + "; " + totalPrice + "; " + transactionFee;
    }
    public boolean equals(Transaction other) {
        return toString().equals(other.toString());
    }
}
