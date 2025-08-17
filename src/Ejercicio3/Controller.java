package Ejercicio3;

public class Controller {
    private final String appName;
    private final Window visualWindow;
    private BenefitCalculator benefitCalculator;
    private static final String[] optionsSisben = {"Si", "No"};
    private static final String[] optionsGender = {"Hombre", "Mujer"};

    public Controller(String appName) {
        this.appName = appName;
        this.visualWindow = new Window(appName);
    }

    public void startApp(){
        int age = askAge();
        String gender = askGender();
        boolean sisben = askSisben();
        User user = new User(age,gender,sisben);
        this.benefitCalculator = new BenefitCalculator(user);
        benefitCalculator.calculateGender();
        benefitCalculator.calculateExtra();
        openMainWindow(user);
    }

    public void openMainWindow(User user){
        if (user.isSisben()){
            visualWindow.showMessageWindow("Beneficio Base: " + user.getBenefit() + "$\nAdicional: " + user.getExtra() + "$\nTotal: " + (user.getBenefit()+user.getExtra()) + "$");
        } else {
            visualWindow.showMessageWindow("No recibe beneficio");
        }
    }

    public int askAge(){
        while (true){
            try{
                int age = Integer.parseInt(visualWindow.showInputWindow("¿Cual es la edad del usuario?"));
                if (age > 0){
                    return age;
                } else {
                    visualWindow.showMessageWindow("¡Debes ingresar una edad mayor a 0!");
                }
            } catch (NumberFormatException e){
                visualWindow.showMessageWindow("¡Debes ingresar una edad valida!");
            }
        }
    }

    public boolean askSisben(){
        while (true) {
            int choose = visualWindow.showOptionWindow("¿Pertenece al Sisben?",optionsSisben);
            if (choose == -1){
                visualWindow.showMessageWindow("¡Debes ingresar una opcion valida!");
                continue;
            }
            return choose == 0;
        }
    }

    public String askGender(){
        while (true){
            try{
                int choose = visualWindow.showOptionWindow("¿Cual es tu genero?",optionsGender);
                return (choose == 0) ? "Hombre" : "Mujer";
            } catch (NumberFormatException e){
                visualWindow.showMessageWindow("¡Debes ingresar una opcion validad!");
            }
        }
    }


}
