/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package campeonato;

import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JUGADOR j1 = new JUGADOR(10, "Jerson", 20, 100);
        JUGADOR j2 = new JUGADOR(1, "Ronald(Pumba)", 20, 200);
        JUGADOR j3 = new JUGADOR(11, "Esteban", 19, 300);
        JUGADOR j4 = new JUGADOR(3, "Kevin", 45, 150);
        JUGADOR j5 = new JUGADOR(5, "Pablo", 35, 400);
        JUGADOR j6 = new JUGADOR(12, "Atencion", 28, 250);
        JUGADOR j7 = new JUGADOR(0, "Raul", 50, -400);
        JUGADOR j8 = new JUGADOR(8, "Bryan(DE TREVIÑO)", 31, 350);
        JUGADOR J9 = new JUGADOR(9, "TAPA", 25, 140);
        JUGADOR j10 = new JUGADOR(7, " Alexa", 35, 100);
        JUGADOR j11 = new JUGADOR(6, "Olger", 21, 202);
        JUGADOR j12 = new JUGADOR(2, "John", 31, 300);
        Equipo costarica = new Equipo("Costa Rica", 12, "ROJO,AZUL Y BLANCO", j1);
        costarica.agregarjugador(j1);
        costarica.agregarjugador(j2);
        costarica.agregarjugador(j3);
        Equipo Mexico = new Equipo("Mexico", 13, "VERDE, ROJO Y BLANCO", j4);
        Mexico.agregarjugador(j4);
        Mexico.agregarjugador(j5);
        Mexico.agregarjugador(j8);
        Equipo Panama = new Equipo("Panama", 14, "Rojo, Azul y Blanco", j6);
        Panama.agregarjugador(j6);
        Panama.agregarjugador(j7);
        Panama.agregarjugador(j10);
        Equipo Estados = new Equipo("Estados Unidos", 15, "Rojo, Azul y blanc0", J9);
        Estados.agregarjugador(J9);
        Estados.agregarjugador(j11);
        Estados.agregarjugador(j12);
        Torneo Mundial = new Torneo("Mundial 2014", "m11", Mexico);
        Mundial.agregarequipo(Panama);
        Mundial.agregarequipo(Estados);
        Mundial.agregarequipo(Mexico);
        Mundial.agregarequipo(costarica);
        JOptionPane.showMessageDialog(null, Mundial.tostringequipos());

    }
}
