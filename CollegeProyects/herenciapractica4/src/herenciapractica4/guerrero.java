/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciapractica4;

/**
 *
 * @author UTN
 */
public class guerrero extends Personaje {

    private String Arma;

    public guerrero(String Arma, String Nombre, int energia) {
        super(Nombre, energia);
        this.Arma = Arma;
    }

    public String getArma() {
        return Arma;
    }

    public void setArma(String Arma) {
        this.Arma = Arma;
    }

    public String combatir() {
        int x = (int) Math.random() * 10 + 1;
        int defensa = (int) Math.random() * 10 + 1;
        super.gastarenerjia(x);
        return (this.Arma + "Energia restante " + super.getEnergia());
    }

}
