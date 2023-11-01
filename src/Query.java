import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.Format;

public class Query {
    private double totalRevenue;
    public Query() {
        this.totalRevenue = 0;
        try {
            TransactionManagement transactionManagement = new TransactionManagement();
            Transaction[][] transactions = transactionManagement.getTransactions();
            higTotPriTra(transactions);
            expInLowestTra(transactions);
            lowTraFee(transactions);
            SalaryManagement salaryManagement = new SalaryManagement();
            highSalaryShopAssistant(salaryManagement.getSalaries());
            total_revenue(transactions);
            totalProfit(salaryManagement.getSalaries());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void higTotPriTra(Transaction[][] transactions) throws IOException {
        double max = transactions[0][0].getTotalPrice();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 15; j++) {
                if (max < transactions[i][j].getTotalPrice()) {
                    max = transactions[i][j].getTotalPrice();
                }
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String formattedMax = decimalFormat.format(max);
        System.out.println("The highest total price transaction is " + formattedMax);
    }
    private void expInLowestTra(Transaction[][] transactions) throws IOException {
        Transaction minimumTransaction = transactions[0][0];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 15; j++) {
                if (minimumTransaction.getTotalPrice() > transactions[i][j].getTotalPrice()) {
                    minimumTransaction = transactions[i][j];
                }
            }
        }
        Product[] products = minimumTransaction.getProducts();
        Product maxPriceProduct = null;
        if ((products[0].getPrice() >= products[1].getPrice()) && (products[0].getPrice() >= products[2].getPrice())) {
            maxPriceProduct = products[0];
        } else if ((products[1].getPrice() >= products[2].getPrice()) && (products[1].getPrice() >= products[0].getPrice())) {
            maxPriceProduct = products[1];
        } else {
            maxPriceProduct = products[2];
        }
        System.out.println("The most expensive product in lowest price transaction is " + maxPriceProduct.getProductName());
    }
    private void lowTraFee(Transaction[][] transactions) throws IOException {
        Transaction minFeeTransaction = transactions[0][0];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 15; j++) {
                if (minFeeTransaction.getTransactionFee() > transactions[i][j].getTransactionFee()) {
                    minFeeTransaction = transactions[i][j];
                }
            }
        }
        double minFee = minFeeTransaction.getTransactionFee();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String formattedMinFee = decimalFormat.format(minFee);
        System.out.println("The lowest transaction fee is " + formattedMinFee);
    }
    private void highSalaryShopAssistant(Salary[] salaries) throws IOException {
        FileIO fileIO = new FileIO();
        ShopAssistant[] shopAssistants = fileIO.getShopAssistants();
        Salary maximumSalary = salaries[0];
        int maxIndex = 0;
        for (int i = 0; i < salaries.length; i++) {
            if (maximumSalary.getTotalMoney() < salaries[i].getTotalMoney()) {
                maxIndex = i;
            }
        }
        double commission = salaries[maxIndex].getCommission();
        Format format = new DecimalFormat("0.00");
        String formattedCommission = format.format(salaries[maxIndex].getCommission());
        String formattedTotalSalary = format.format(salaries[maxIndex].getTotalMoney());
        System.out.print("The highest-salary shop assistant is ");
        System.out.print(shopAssistants[maxIndex].toString() + " ");
        System.out.print(salaries[maxIndex].getSalary() / 4 + " " + formattedCommission + " " + formattedTotalSalary);
        System.out.println();
    }
    private void total_revenue(Transaction[][] transactions) throws IOException {
        for (int i = 0; i < 100; i++) {
            for (int j = 0 ; j < 15; j++) {
                totalRevenue += transactions[i][j].getTotalPrice() + transactions[i][j].getTransactionFee();
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String formattedTotalRevenue = decimalFormat.format(totalRevenue);
        System.out.println("The total revenue that is earned from both total prices and transaction fees is " + formattedTotalRevenue);
    }
    private void totalProfit(Salary[] salaries) throws IOException {
        double totalSalary = 0;
        for (int i = 0; i < salaries.length; i++) {
            totalSalary += salaries[i].getTotalMoney();
        }
        double totalProfit = (totalRevenue - totalSalary);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String formattedTotalProfit = decimalFormat.format(totalProfit);
        System.out.println("The total profit that is earned after paying the shop assistant salaries is " + formattedTotalProfit);
    }
}
