/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciapractica4;

/**
 *
 * @author UTN
 */
public class Personaje {

    protected String Nombre;
    protected int energia;
    protected int vida;

    public Personaje(String Nombre, int energia) {
        this.Nombre = Nombre;
        this.energia = energia;
        this.vida = 1000;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void comer(int comer) {
        this.energia = this.energia + comer;

    }

    public void gastarenerjia(int gastodeenergia) {
        this.energia = this.energia - gastodeenergia;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

}
