package Ejercicio2;

public class Verifications {
    private static final String error1 = "Monto invalido";
    private static final String error2 = "Debes escoger un operador";
    private static final String error3 = "Debes ingresar un numero valido (Minimo 10 numeros)";

    public double askValidDouble(Window visualWindow,String text){
        while (true){
            try {
                return Double.parseDouble(visualWindow.showInputWindow(text));
            } catch (NumberFormatException | NullPointerException e){
                visualWindow.showMessageWindow(error1);
            }
        }
    }

    public String askValidOperator(Window visualWindow,String[] list,String text){
        while (true){
            int operator = visualWindow.showOptionWindow(text,list);
            if (operator >= 0){
                return list[operator];
            } else {
                visualWindow.showMessageWindow(error2);
            }
        }
    }

    public String askValidPhoneNumber(Window visualWindow, String text) {
        while (true) {
            String numberPhone = visualWindow.showInputWindow(text);
            if (numberPhone == null || numberPhone.length() < 10 || !numberPhone.matches("\\d+")) {
                visualWindow.showMessageWindow(error3);
            } else {
                return numberPhone;
            }
        }
    }

}
