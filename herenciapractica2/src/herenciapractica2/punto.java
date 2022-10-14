/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciapractica2;

/**
 *
 * @author UTN
 */
public class punto {

    //atributos de la clase
    protected double puntox;
    protected double puntoy;

    //metodo constructor
    public punto(double puntox, double puntoy) {
        this.puntox = puntox;
        this.puntoy = puntoy;
    }

    public double getPuntox() {
        return puntox;
    }

    public void setPuntox(double puntox) {
        this.puntox = puntox;
    }

    public double getPuntoy() {
        return puntoy;
    }

    public void setPuntoy(double puntoy) {
        this.puntoy = puntoy;
    }

    public String toStringPunto() {
        return ("Punto - Coordenadas [" + this.puntox + "," + 0 + " ||  " + this.puntoy + "," + 0 + "]");
    }
}
