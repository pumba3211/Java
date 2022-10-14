/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciapractica2;

import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class Herenciapractica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        circulo c1 = new circulo(10, 3, 5);
        JOptionPane.showMessageDialog(null, c1.toStringcCirculo());
        cilindro c2 = new cilindro(20, 10, 3, 5);
        JOptionPane.showMessageDialog(null, c2.toStringCilindro());
    }
}
