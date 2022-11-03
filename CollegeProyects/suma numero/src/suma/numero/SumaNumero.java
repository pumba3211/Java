/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package suma.numero;

import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class SumaNumero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int cont = 0;
        int numero;
        int suma = 0;
        String desgloce = "";
        while (cont <= 10) {

            numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero"));
            desgloce = desgloce + numero + "+";
            suma = suma + numero;
            cont++;
        }
        JOptionPane.showMessageDialog(null, "La suma de " + desgloce + "es " + suma, "Suma", JOptionPane.INFORMATION_MESSAGE);
    }
}
