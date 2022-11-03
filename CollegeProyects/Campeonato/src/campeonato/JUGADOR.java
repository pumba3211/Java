/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package campeonato;

/**
 *
 * @author UTN
 */
public class JUGADOR {

    private int num;
    private String nombre;
    private int edad;
    private double costo;

    public JUGADOR(int num, String nombre, int edad, double costo) {
        this.num = num;
        this.nombre = nombre;
        this.edad = edad;
        this.costo = costo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String toStringjugador() {
        return ("Nombre:" + this.nombre + " Numero: " + this.num + " Edad: " + this.edad + " Costo: " + this.costo);
    }
}
