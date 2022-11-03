/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodado;

import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class Juegodado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int aleatorio = (int) (Math.random() * 6) + 1;//random
        if (aleatorio == 1) {
            JOptionPane.showMessageDialog(null, "Avance una Casilla " + aleatorio, "Juego", JOptionPane.INFORMATION_MESSAGE);
        } else if (aleatorio == 2) {
            JOptionPane.showMessageDialog(null, "Avance dos casillas " + aleatorio, "Juego", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Quedese donde esta por que su numero es " + aleatorio, "Juego", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
