import java.util.Random;

public class ShopAssistant {
    int ID;
    String name;
    String surname;
    String phoneNumber;
    int seniority;
    public ShopAssistant(int ID, String name, String surname, String phoneNumber) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        Random random = new Random();
        this.seniority = random.nextInt(16);
    }
    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public int getSeniority() {
        return seniority;
    }

    public String toString() {
        return ID + "; " + name + "; " + surname + "; " + seniority;
    }
    public boolean equals(ShopAssistant other) {
        return toString().equals(other.toString()) && phoneNumber.equals(other.phoneNumber);
    }
}
