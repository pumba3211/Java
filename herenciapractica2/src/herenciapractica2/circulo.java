/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciapractica2;

/**
 *
 * @author UTN
 */
public class circulo extends punto {

    private double radio;

    public circulo(double radio, double puntox, double puntoy) {
        super(puntox, puntoy);
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double circurferenciaDelCirculo() {
        return (2 * Math.PI * radio);
    }

    public double calculaArea() {
        return ((Math.PI) * (this.radio * this.radio));
    }

    public String toStringcCirculo() {
        return ("Circulo:" + "\n" + super.toStringPunto() + " Radio=" + this.radio + "\n"
                + "Circunferencia del Circulo:" + circurferenciaDelCirculo() + "\n"
                + "Area del Circulo:" + calculaArea());
    }
}
