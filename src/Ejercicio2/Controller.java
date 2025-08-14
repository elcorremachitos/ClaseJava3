package Ejercicio2;

public class Controller {
    private final String appName;
    private final String[] phoneOperators = {"VzlaPhone", "ColPhone"};
    private final String[] optionsMenu = {"Consultar Saldo", "Recargar", "Salir"};
    private final Window visualWindow;
    private static final Verifications verf = new Verifications();

    public Controller(String appName) {
        this.appName = appName;
        this.visualWindow = new Window(appName);
    }

    public void startApp(){
        String phoneNumber = askNumber();
        String phoneOperator = askOperator();
        double phoneBalance = askBalance();
        Phone phone = new Phone(phoneNumber,phoneOperator,phoneBalance);
        openGeneralWindow(phone);
    }

    public void openGeneralWindow(Phone phone){
        while (true){
            int choose = visualWindow.showOptionWindow("¿Que necesitas hacer?",optionsMenu);
            switch (choose){
                case 0:
                    checkBalance(phone);
                    break;
                case 1:
                    rechargePhone(phone);
                    break;
                default:
                    return;
            }
        }
    }

    public void checkBalance(Phone phone){
        visualWindow.showMessageWindow("Tu saldo es de " + phone.getPhoneBalance() + "$");
    }

    public void rechargePhone(Phone phone){
        double rechargeValue = verf.readValidDouble(visualWindow,"¿Cuanto quieres recargar?");
        phone.setPhoneBalance(phone.getPhoneBalance()+rechargeValue);
        visualWindow.showMessageWindow("¡Recarga exitosa!\nNumero de celular: " + phone.getPhoneNumber() + "\nOperador: " + phone.getPhoneOperator() + "\nRecargaste el monto de: " + rechargeValue + "$\nTu saldo actual es de: " + phone.getPhoneBalance() + "$");
    }

    public String askNumber() {
        return verf.readValidPhoneNumber(visualWindow,"¿Cual es tu numero celular?");
    }

    public String askOperator(){
        return verf.readValidOperator(visualWindow,phoneOperators,"¿Cual es tu operador?");
    }

    public double askBalance(){
        return verf.readValidDouble(visualWindow,"¿Cuanto quieres recargar?");
    }

}
