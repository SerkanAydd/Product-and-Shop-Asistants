public class Salary {
    double salary;
    double commission;
    public Salary(double salary, double total) {
        if (total > 7500) {
            commission = 0.03;
        } else {
            commission = 0.01;
        }
        this.salary = salary * 4;
        this.commission = total * commission;
    }
    public double getSalary() {
        return salary;
    }
    public double getCommission() {
        return commission;
    }
    public double getTotalMoney() {
        return salary + commission;
    }
    public String toString() {
        return salary + "; " + commission;
    }
    public boolean equals(Salary other) {
        return toString().equals(other.toString());
    }
}

