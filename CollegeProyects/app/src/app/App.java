/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Estudiante e1 = new Estudiante("127321", "Ronald", 5);
        Cursos Progra2 = new Cursos("Progra 2", "isw 211");
        Cursos BD = new Cursos("Base de datos", "Isw 212");

        Carreras ISW = new Carreras("ISW", Progra2);
        ISW.agregarcurso(BD);
        ISW.agregarcurso(Progra2);
        Universidad u = new Universidad("Utn", ISW);
        Estudiante e2 = new Estudiante("123213", "Pumba", 123);
        Profesor p1 = new Profesor("123123", "Pablo", "Progra 2");
        Profesor p2 = new Profesor("12312", "Marlen", "Base de datos");

        u.agregarestudiante(e1);
        u.agregarestudiante(e2);
        u.agregarprofesor(p1);
        u.agregarprofesor(p2);

        JOptionPane.showMessageDialog(null, u.toString());
    }
}
