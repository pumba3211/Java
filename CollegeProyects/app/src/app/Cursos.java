/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author UTN
 */
public class Cursos {

    private String Nombre;
    private String Codigo;

    public Cursos(String Nombre, String Codigo) {
        this.Nombre = Nombre;
        this.Codigo = Codigo;
    }

    public String toStringc() {
        return ("Codigo: " + this.Codigo + " Nombre del curso" + this.Nombre);
    }
}
