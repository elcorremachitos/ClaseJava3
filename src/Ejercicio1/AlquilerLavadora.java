package Ejercicio9;
import javax.swing.JOptionPane;

public class AlquilerLavadora {
    private float horas;
    private float tarifa;
    private float descuento;
    private float subTotal;

    public void setHoras(){
        float horasUsadas = Float.parseFloat(JOptionPane.showInputDialog(null,"¿Cuantas horas uso la lavadora?"));
        if (horasUsadas > 0){
            this.horas = horasUsadas;
        }
    }

    public void setTarifa(){
        float tarifaUsada = Float.parseFloat(JOptionPane.showInputDialog(null,"¿Cual es la tarifa por hora?"));
        if (tarifaUsada > 0){
            this.tarifa = tarifaUsada;
        }
    }

    public float calcularSubtotal(){
        this.subTotal = horas*tarifa;
        return subTotal;
    }

    public float calcularDescuento(){
        if (horas > 5){
            this.descuento = (float) (subTotal*0.03);
        } else {
            this.descuento = 0;
        }
        return descuento;
    }

    public float calcularTotal(){
        return subTotal - descuento;
    }

}
