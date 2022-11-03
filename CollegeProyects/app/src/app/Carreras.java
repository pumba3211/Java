/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;

/**
 *
 * @author UTN
 */
public class Carreras {

    private String nombre;

    private ArrayList<Cursos> arraycursos;
    private Cursos curso;

    public Carreras(String nombre, Cursos pcurso) {
        this.nombre = nombre;

        this.arraycursos = new ArrayList();
        this.curso = pcurso;

    }

    public void agregarcurso(Cursos curso) {
        arraycursos.add(curso);
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < arraycursos.size(); i++) {
            result = result + arraycursos.get(i).toStringc() + "\n";
        }
        return ("Carrera:" + this.nombre + " Cantidad de cursos: " + arraycursos.size() + "\n" + result);
    }

}
