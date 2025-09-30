package Ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final String appName;
    private final Window visualWindow;
    private final String[] optionListMenu = {"Realizar compra","Consultar Puntos"};
    // Se crea de esta manera para usar el .contains y otros metodos y sera un array dinamico
    ArrayList<String> users_list = new ArrayList<>();

    public Controller(String appName) {
        this.appName = appName;
        this.visualWindow = new Window(appName);
    }

    public void startApp(){
        askForOptionMenu();
    }

    public void askForOptionMenu(){
        while (true){
            int choose = visualWindow.showOptionWindow("Escoge que quieres hacer",optionListMenu);
            switch (choose){
                case 0:
                    visualWindow.showMessageWindow("Escogiste comprar");
                    break;
                case 1:
                    visualWindow.showMessageWindow("Escogiste Consultar");
                    break;
                default:
                    return;
            }
        }
    }

    public void startBuy (){
        String name = askForUserName();
        double charge = askForBuyCharge();
        if (users_list.contains(name)){
            visualWindow.showMessageWindow("Este usuario ya existe ¡ERROR!");
            return;
        }
        User user = new User(name,);

    }

    public double askForBuyCharge(){
        return Double.parseDouble(visualWindow.showInputWindow("Ingrese el monto de la compra"));
    }

    public String askForUserName(){
        return visualWindow.showInputWindow("Ingrese el id del Usuario");
    }
}
