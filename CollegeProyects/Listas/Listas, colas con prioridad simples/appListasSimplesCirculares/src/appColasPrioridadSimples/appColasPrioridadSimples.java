/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appColasPrioridadSimples;

import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class appColasPrioridadSimples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numeros;

        Lista l = new Lista();

        for (int i = 1; i <= 10; i++) {
            numeros = (int) (Math.random() * 5) + 1;
            l.BuscarAgregar(numeros);
        }
        
        JOptionPane.showMessageDialog(null, l.toString());
        
        l.borrar();
        
        //JOptionPane.showMessageDialog(null, l.toString());
         String loco="2A";
        JOptionPane.showMessageDialog(null, loco.substring(0,1));
    }
   
}
