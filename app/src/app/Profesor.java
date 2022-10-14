/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author UTN
 */
public class Profesor {

    // Atributos de la Clase
    private String Cedula;
    private String Nombre;
    private String cursosimpartidos;
    // Metodo constructor

    public Profesor(String Cedula, String Nombre, String cursosimpartidos) {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.cursosimpartidos = cursosimpartidos;
    }

    public String tostringp() {
        return ("Cedula: " + this.Cedula + "," + " Nombre: " + this.Nombre + "," + " Cursos que imparte: " + this.cursosimpartidos);
    }

}
