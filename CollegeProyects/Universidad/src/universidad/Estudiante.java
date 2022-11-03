/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

/**
 *
 * @author UTN
 */
public class Estudiante {

    private int Cedula;
    private int Sexo;
    private int trabaja;
    private int sueldo;

    public Estudiante(int Cedula, int Sexo, int trabaja, int sueldo) {
        this.Cedula = Cedula;
        this.Sexo = Sexo;
        this.trabaja = trabaja;
        this.sueldo = sueldo;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public int getSexo() {
        return Sexo;
    }

    public void setSexo(int Sexo) {
        this.Sexo = Sexo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getTrabaja() {
        return trabaja;
    }

    public void setTrabaja(int trabaja) {
        this.trabaja = trabaja;
    }

}
