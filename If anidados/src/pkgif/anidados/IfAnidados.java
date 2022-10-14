/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgif.anidados;

import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class IfAnidados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Digete el primer numero"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Digete el seundo numero"));
        if (num1 == num2) {
            JOptionPane.showMessageDialog(null, "Los numeros " + num1 + "y " + num2 + "son iguales");

        } else {
            if (num1 > num2) {
                JOptionPane.showMessageDialog(null, "El numero " + num1 + "es mayor que " + num2);

            } else {
                JOptionPane.showMessageDialog(null, "El numero " + num1 + "es menor  que " + num2);
            }
        }
    }
}
