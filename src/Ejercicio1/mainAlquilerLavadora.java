package Ejercicio9;
import javax.swing.JOptionPane;


public class mainAlquilerLavadora {
    public static void main(String[] args) {
        Ejercicio9.AlquilerLavadora lavadora = new Ejercicio9.AlquilerLavadora();
        lavadora.setHoras();
        lavadora.setTarifa();
        JOptionPane.showMessageDialog(null,"Subtotal: " + lavadora.calcularSubtotal() + " Descuento: " + lavadora.calcularDescuento() + " Totall: " + lavadora.calcularTotal());
    }
}
