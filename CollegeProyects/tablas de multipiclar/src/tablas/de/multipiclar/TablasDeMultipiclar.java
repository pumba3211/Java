/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas.de.multipiclar;

import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class TablasDeMultipiclar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numero = Integer.parseInt(JOptionPane.showInputDialog("digite su numero"));
        multi s = new multi();
        s.setNumero(numero);
        s.calcular();

    }

}
