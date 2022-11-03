/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class Cajero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here}
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que desea retirar"));
        Cajeros ronald = new Cajeros();
        ronald.setCantidad(cantidad);
        ronald.desglosar();

    }
}
