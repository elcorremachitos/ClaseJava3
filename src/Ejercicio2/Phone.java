package Ejercicio2;

public class Phone {
    private String phoneNumber;
    private String phoneOperator;
    private double phoneBalance;

    public Phone(String phoneNumber, String phoneOperator, double phoneBalance) {
        this.phoneNumber = phoneNumber;
        this.phoneOperator = phoneOperator;
        this.phoneBalance = phoneBalance;
    }

    public double getPhoneBalance() {
        return phoneBalance;
    }

    public void setPhoneBalance(double phoneBalance) {
        this.phoneBalance = phoneBalance;
    }

    public String getPhoneOperator() {
        return phoneOperator;
    }

    public void setPhoneOperator(String phoneOperator) {
        this.phoneOperator = phoneOperator;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
