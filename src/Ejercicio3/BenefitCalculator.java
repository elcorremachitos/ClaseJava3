package Ejercicio3;

public class BenefitCalculator {
    Users user;

    public BenefitCalculator(Users user) {
        this.user = user;
    }

    public void calculateGender(){
        int benefit = user.getGender().equals("Hombre") ? 120000 : 150000;
        user.setBenefit(benefit);
    }

    public void calculateExtra(){
        if (user.getAge() > 60) {
            user.setExtra(40000);
        } else {
            user.setExtra(0);
        }
    }
}
