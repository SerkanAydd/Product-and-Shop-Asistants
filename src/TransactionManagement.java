
import java.io.IOException;
import java.util.Random;

public class TransactionManagement {
    Transaction[][] transactions;
    Product[] products;
    public TransactionManagement() throws IOException {
        FileIO fileIO = new FileIO();
        this.products = fileIO.getProducts();
        this.transactions = new Transaction[100][15];
        createTransactionObjects();
    }
    private void createTransactionObjects() {
        Random random = new Random();
        int ID = 0, outerCursor = 0;
        for (int i = 0; i < 100; i++) {
            int innerCursor = 0;
            for (int j = 0; j < 15; j++) {
                Product[] transactionProducts = new Product[3];
                double totalPrice = 0;
                for (int index = 0; index < 3; index++) {
                    transactionProducts[index] = products[random.nextInt(90)];
                    totalPrice += transactionProducts[index].getPrice() * (random.nextInt(10) + 1);
                }
                double transactionFee = feeCalculator(totalPrice);
                transactions[outerCursor][innerCursor] = new Transaction(ID, transactionProducts, totalPrice, transactionFee);
                innerCursor++;
                ID++;
            }
            outerCursor++;
        }
    }
    private double feeCalculator(double totalPrice) {
        double transactionFee = 0;
        if (totalPrice <= 499) {
            transactionFee = totalPrice * (1.0 / 100.0);
        } else if (totalPrice <= 799) {
            transactionFee = totalPrice * (3 / 100);
        } else if (totalPrice <= 999) {
            transactionFee = totalPrice * (5 / 100);
        } else {
            transactionFee = totalPrice * (9 / 100);
        }
        return transactionFee;
    }
    public Transaction[][] getTransactions() {
        return transactions;
    }
}
