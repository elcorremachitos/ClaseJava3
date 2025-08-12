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
            int choose = JOptionPane.showOptionDialog(null,"¿Que necesitas hacer?","Recargas Chamo",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null,optionsMenu,optionsMenu[0]);
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
            this.numberPhone = JOptionPane.showInputDialog(null, "¿Cual es tu numero celular?", "Recargas Chamo", JOptionPane.PLAIN_MESSAGE);
            if (numberPhone.length() < 10 || !numberPhone.matches("\\d+")) {
                showMessageWindow("Debes ingresar un numero valido");
            } else {
                return;
            }
        }
    }

    public void openOperatorWindow(){
        String[] optionsOperator = {"VzlaPhone","ColPhone"};
        int choose = JOptionPane.showOptionDialog(null,"¿Cual es tu operador?","Recargas Chamo",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null,optionsOperator,optionsOperator[0]);
        this.operatorPhone = optionsOperator[choose];
    }

    public void openBalanceWindow(){
        while (true){
            try {
                this.balancePhone = Double.parseDouble(JOptionPane.showInputDialog(null,"¿Cual es tu saldo inicial?","Recargas Chamo",JOptionPane.PLAIN_MESSAGE));
                return;
            } catch (NumberFormatException e){
                showMessageWindow("Debes ingresar un monto valido");
            }
        }
    }

    public void rechargePhone(){
        while (true){
            try {
                double rechargeValue = Double.parseDouble(JOptionPane.showInputDialog(null,"¿Cuanto quieres recargar?","Recargas Chamo",JOptionPane.PLAIN_MESSAGE));
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
}
