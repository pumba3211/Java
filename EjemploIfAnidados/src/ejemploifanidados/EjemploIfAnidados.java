/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploifanidados;

import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class EjemploIfAnidados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite el primer número"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite el segundo número"));

        if (num1 == num2) {
            System.out.println("Los números son iguales");
        } else {
            if (num1 > num2) {
                System.out.println("El número " + num1 + " es mayor a " + num2);
            } else {
                System.out.println("El número " + num2 + " es mayor a " + num1);
            }
        }
    }
}
