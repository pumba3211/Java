/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class Universidad {

    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Profesor> profesores;
    private String nombre;
    private Carreras carrera;

    public Universidad(String nombre, Carreras pcarrera) {
        this.estudiantes = new ArrayList();
        this.profesores = new ArrayList();
        this.nombre = nombre;
        this.carrera = pcarrera;
    }

    public void agregarprofesor(Profesor profe) {
        this.profesores.add(profe);
    }

    public void agregarestudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
    }

    public String toString() {
        String result = " ";
        for (int i = 0; i < estudiantes.size(); i++) {
            result = result + estudiantes.get(i).toString() + "\n";
        }
        result = result + "\n" + "<html><h1> Profesores </h1></html>";
        for (int i = 0; i < profesores.size(); i++) {
            result = result + profesores.get(i).tostringp() + "\n";
        }
        return (result);
    }

}
