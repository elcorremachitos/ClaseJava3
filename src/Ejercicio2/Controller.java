package Ejercicio2;

public class Controller {
    private final String appName;
    private static final String[] phoneOperators = {"VzlaPhone", "ColPhone"};
    private static final String[] optionsMenu = {"Consultar Saldo", "Recargar", "Salir"};
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

    private void openGeneralWindow(Phone phone){
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

    private void checkBalance(Phone phone){
        visualWindow.showMessageWindow("Tu saldo es de " + phone.getPhoneBalance() + "$");
    }

    private void rechargePhone(Phone phone){
        double rechargeValue = verf.askValidDouble(visualWindow,"¿Cuanto quieres recargar?");
        phone.setPhoneBalance(phone.getPhoneBalance()+rechargeValue);
        visualWindow.showMessageWindow("¡Recarga exitosa!\nNumero de celular: " + phone.getPhoneNumber() + "\nOperador: " + phone.getPhoneOperator() + "\nRecargaste el monto de: " + rechargeValue + "$\nTu saldo actual es de: " + phone.getPhoneBalance() + "$");
    }

    private String askNumber() {
        return verf.askValidPhoneNumber(visualWindow,"¿Cual es tu numero celular?");
    }

    private String askOperator(){
        return verf.askValidOperator(visualWindow,phoneOperators,"¿Cual es tu operador?");
    }

    private double askBalance(){
        return verf.askValidDouble(visualWindow,"¿Cuanto quieres recargar?");
    }

}
