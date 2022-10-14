/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciapractica2;

/**
 *
 * @author UTN
 */
public class cilindro extends circulo {

    private double altura;

    public cilindro(double altura, double radio, double puntox, double puntoy) {
        super(radio, puntox, puntoy);
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calcularSuperficiocilindro() {
        double areas = super.calculaArea() * 2;
        double areadepared = super.calculaArea() * super.circurferenciaDelCirculo();
        return (areas + areadepared);
    }

    public double volumendelcilindro() {
        return (super.calculaArea() * this.altura);
    }

    public String toStringCilindro() {
        return ("Cilindro:" + "\n" + super.toStringPunto() + " Radio: " + super.getRadio() + " Altura:" + this.altura + "\n"
                + "Area de la Superficie del Cilindro: " + calcularSuperficiocilindro() + "\n"
                + "Volumen del Cilindro:" + volumendelcilindro());
    }

}
