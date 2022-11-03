/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciapractica4;

/**
 *
 * @author UTN
 */
public class mago extends Personaje {

    private String poder;

    public mago(String poder, String Nombre, int energia) {
        super(Nombre, energia);
        this.poder = poder;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public String encantar() {
        super.setEnergia(super.getEnergia() - 2);
        return ("Al mago le quedan " + super.getEnergia() + " de energia");
    }
}
