package Ejercicio2;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ejercicio2 {
    private String numberPhone;
    private String operatorPhone;
    private int balancePhone;

    public void openGeneralWindow(){
        String[] optionsMenu = {"Consultar Saldo","Recargar"};
        int choose = JOptionPane.showOptionDialog(null,"¿Que necesitas hacer?","Recargas Chamo",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null,optionsMenu,optionsMenu[0]);
        switch (choose){
            case 0:
                checkBalance();
                break;
            case 1:
                rechargePhone();
                break;
        }
    }

    public void openNumberWindow(){
        this.numberPhone = JOptionPane.showInputDialog(null,"¿Cual es tu numero celular?","Recargas Chamo",JOptionPane.PLAIN_MESSAGE);
        if (numberPhone.length() < 10 || !numberPhone.matches("\\d+")){
            JOptionPane.showMessageDialog(null,"Debes ingresar un numero valido");
            openNumberWindow();
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
                this.balancePhone = Integer.parseInt(JOptionPane.showInputDialog(null,"¿Cual es tu saldo inicial?","Recargas Chamo",JOptionPane.PLAIN_MESSAGE));
                return;
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Monto invalido");
            }
        }
    }

    public void rechargePhone(){
        while (true){
            try {
                float rechargeValue = Integer.parseInt(JOptionPane.showInputDialog(null,"¿Cuanto quieres recargar?","Recargas Chamo",JOptionPane.PLAIN_MESSAGE));
                this.balancePhone = (int) (balancePhone + rechargeValue);
                JOptionPane.showMessageDialog(null,"¡Recarga exitosa!\nNumero de celular: " + numberPhone + "\nOperador: " + operatorPhone + "\nRecargaste el monto de: " + rechargeValue + "$\nTu saldo actual es de: " + balancePhone + "$");
                openGeneralWindow();
                return;
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Monto invalido");
            }
        }
    }

    public void checkBalance(){
        JOptionPane.showMessageDialog(null,"Tu saldo es de " + balancePhone + "$");
        openGeneralWindow();
    }

}
