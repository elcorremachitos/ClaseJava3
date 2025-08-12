package Ejercicio2;
import javax.swing.JOptionPane;

public class ejercicio2 {
    private String numberPhone;
    private String operatorPhone;
    private double balancePhone;

    public void openGeneralWindow(){
        String[] optionsMenu = {"Consultar Saldo","Recargar"};
        boolean flag = true;
        while (flag){
            int choose = showOptionWindow("¿Que necesitas hacer?",optionsMenu);
            switch (choose){
                case 0:
                    checkBalance();
                    break;
                case 1:
                    rechargePhone();
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }

    public void openNumberWindow() {
        while (true) {
        this.numberPhone = showInputWindow("¿Cual es tu numero de celular?");
            if (numberPhone == null || numberPhone.length() < 10 || !numberPhone.matches("\\d+")) {
                showMessageWindow("Debes ingresar un numero valido");
            } else {
                return;
            }
        }
    }

    public void openOperatorWindow(){
        String[] optionsOperator = {"VzlaPhone","ColPhone"};
        int choose = showOptionWindow("¿Cual es tu operador?",optionsOperator);
        this.operatorPhone = optionsOperator[choose];
    }

    public void openBalanceWindow(){
        while (true){
            try {
                this.balancePhone = Double.parseDouble(showInputWindow("¿Cual es tu saldo inicial?"));
                return;
            } catch (NumberFormatException e){
                showMessageWindow("Debes ingresar un monto valido");
            }
        }
    }

    public void rechargePhone(){
        while (true){
            try {
                double rechargeValue = Double.parseDouble(showInputWindow("¿Cuanto quieres recargar?"));
                this.balancePhone = balancePhone + rechargeValue;
                showMessageWindow("¡Recarga exitosa!\nNumero de celular: " + numberPhone + "\nOperador: " + operatorPhone + "\nRecargaste el monto de: " + rechargeValue + "$\nTu saldo actual es de: " + balancePhone + "$");
                return;
            } catch (NumberFormatException e){
                showMessageWindow("Monto Invalido");
            }
        }
    }

    public void checkBalance(){
        showMessageWindow("Tu saldo es de " + balancePhone + "$");
    }

    public void showMessageWindow(String text){
        JOptionPane.showMessageDialog(null,text,"Recargas Chamo",JOptionPane.PLAIN_MESSAGE);
    }

    public String showInputWindow(String text){
        return JOptionPane.showInputDialog(null,text,"Recargas Chamo",JOptionPane.PLAIN_MESSAGE);
    }

    public int showOptionWindow(String text,String[] list){
        return JOptionPane.showOptionDialog(null,text,"Recargas Chamo",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null,list,list[0]);
    }
}
