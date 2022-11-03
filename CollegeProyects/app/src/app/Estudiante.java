/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author UTN
 */
public class Estudiante {

    // Atributos de la clase
    private String Cedula;
    private String Nombre;
    private int cursos;

    // Metodo constructor
    public Estudiante(String Cedula, String Nombre, int cursos) {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.cursos = cursos;

    }

    public String toString() {
        return ("Cedula: " + this.Cedula + " Nombre; " + this.Nombre + "," + " Cantida  de cursos " + this.cursos);
    }

}
