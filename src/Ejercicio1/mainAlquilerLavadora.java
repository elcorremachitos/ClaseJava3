package Ejercicio1;
import javax.swing.JOptionPane;


public class mainAlquilerLavadora {
    public static void main(String[] args) {
        Ejercicio1.AlquilerLavadora lavadora = new Ejercicio1.AlquilerLavadora();
        lavadora.setHoras();
        lavadora.setTarifa();
        JOptionPane.showMessageDialog(null,"Subtotal: " + lavadora.calcularSubtotal() + " Descuento: " + lavadora.calcularDescuento() + " Totall: " + lavadora.calcularTotal());
    }
}
