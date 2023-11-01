import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
public class SalaryManagement {
    ShopAssistant[] shopAssistants;
    Salary[] salaries;
    public SalaryManagement() throws IOException {
        this.salaries = new Salary[100];
        FileIO fileIO = new FileIO();
        this.shopAssistants = fileIO.getShopAssistants();
        calculateSalary();
    }
    public void calculateSalary() throws IOException {
        Random random = new Random();
        TransactionManagement transactionManagement = new TransactionManagement();
        Transaction[][] transactions = transactionManagement.getTransactions();
        for (int i = 0; i < 100; i++) {
            double totalRevenue = 0;
            for (int j = 0; j < 15; j++) {
                 totalRevenue += transactions[i][j].getTotalPrice() + transactions[i][j].getTransactionFee();
            }
            salaries[i] = new Salary(weeklySalaryCalculator(shopAssistants[i].getSeniority()), totalRevenue);
        }
    }
    private int weeklySalaryCalculator(int seniority) {
        int weeklySalary;
        if (seniority < 1) {
            weeklySalary = 1500;
        } else if (seniority < 3) {
            weeklySalary = 2000;
        } else if (seniority < 5) {
            weeklySalary = 2500;
        } else {
            weeklySalary = 3000;
        }
        return weeklySalary;
    }
    public Salary[] getSalaries() {
        return salaries;
    }
}
