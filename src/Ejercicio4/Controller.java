package Ejercicio4;

public class Controller {
    private final String appName;
    private final Window visualWindow;
    private final String[] optionListMenu = {"Realizar compra","Consultar Puntos"};
    // Se crea de esta manera para usar el .contains y otros metodos y sera un array dinamico

    public Controller(String appName) {
        this.appName = appName;
        this.visualWindow = new Window(appName);
    }

    public void startApp(){
        askForOptionMenu();
    }

    private void askForOptionMenu(){
        while (true){
            int choose = visualWindow.showOptionWindow("Escoge que quieres hacer",optionListMenu);
            switch (choose){
                case 0:
                    startBuy();
                    break;
                case 1:
                    checkPoints();
                    break;
                default:
                    return;
            }
        }
    }

    private void startBuy (){
        String name = askForUserName();
        double charge = askForBuyCharge();

        if (!UserManager.isExists(name)){
            User user = new User(name,0);
            UserManager.addUser(user);
        }
        User user = UserManager.getUser(name);
        FidelityPointsCalculator(charge, user);
    }

    private void checkPoints(){
        String name = askForUserName();
        User user = UserManager.getUser(name);
        visualWindow.showMessageWindow("Puntaje de Puntos \n" + user.getPoints());
    }

    private double askForBuyCharge(){
        return Double.parseDouble(visualWindow.showInputWindow("Ingrese el monto de la compra"));
    }

    private String askForUserName(){
        return visualWindow.showInputWindow("Ingrese el nombre del Usuario");
    }

    private void FidelityPointsCalculator(double charge, User user){
        if (charge <= 0){
            visualWindow.showMessageWindow("Monto invalido");
            return;
        }
        if (charge > 100000 && charge < 500000){
            user.setPoints(user.getPoints()+100);
            visualWindow.showMessageWindow("Felicitaciones " + user.getPoints() + "\nObtuviste 100 puntos\nPuntos actuales: " + user.getPoints());
        } else if (charge >= 500000) {
            user.setPoints(user.getPoints()+400);
            visualWindow.showMessageWindow("Felicitaciones " + user.getPoints() + "\nObtuviste 400 puntos\nPuntos actuales: " + user.getPoints());
        } else {
        }
    }
}
