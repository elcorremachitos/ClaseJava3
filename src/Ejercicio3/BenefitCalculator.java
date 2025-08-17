package Ejercicio3;

public class BenefitCalculator {
    User user;

    public BenefitCalculator(User user) {
        this.user = user;
    }

    public int calculateBenefitGender(){
        return (user.getGender().equals("Hombre")) ? 120000 : 150000;
    }

    public int calculateBenefitExtra(){
        return (user.getAge() > 60) ? 40000 : 0;
    }
}
