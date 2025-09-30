package Ejercicio5;

public class Controller {
    private final String appName;
    private final Window visualWindow;

    public Controller(String appName) {
        this.appName = appName;
        this.visualWindow = new Window(appName);
    }

    public void startApp() {
        int id_card = Integer.parseInt(visualWindow.showInputWindow("Ingresa tu numero de cedula"));
        int last_digit = getLastDigitId(id_card);
        showDays(last_digit);
    }



    private int getLastDigitId(int id){
        return id%10;
    }

    private boolean isEven(int number){
        return number % 2 == 0;
    }

    private String daysBase(int number){
        if(number >= 0 &&  number < 5){
            return "Lunes - Miercoles";
        } else if(number >= 6 && number < 9){
            return "Martes - Jueves";
        }
        return "Invalido";
    }

    private String daysExtra(int number){
        if(isEven(number)){
            return " - Viernes";
        } else {
            return " - Sabado";
        }
    }

    private void showDays(int number){
       String daysTotal = daysBase(number);
       daysTotal = daysTotal +  daysExtra(number);
       visualWindow.showMessageWindow(daysTotal);
    }

}
