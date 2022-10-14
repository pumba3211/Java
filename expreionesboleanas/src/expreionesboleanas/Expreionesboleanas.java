/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expreionesboleanas;

import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class Expreionesboleanas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*System.out.println(5==5);
        System.out.println(5==6);
        System.out.println(5!=6);
        System.out.println(5>6);
        System.out.println(5<=6);
        System.out.println(6<=6);
        
        
        boolean x=true;
        boolean y=false;
        System.out.println(x&&y);
        System.out.println(x||y);
        * 
         */
        int x = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("igite un segun numero"));
        if (x < y) {
            JOptionPane.showMessageDialog(null, x + "es menor que" + y, "mensaje", JOptionPane.INFORMATION_MESSAGE);
        } else if (x > y) {
            JOptionPane.showMessageDialog(null, x + "es mayor que" + y, "mensaje", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, x + "es igual que" + y, "mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
        if (x < 0) {
            JOptionPane.showMessageDialog(null, x + "es menor que 0 por lo tanto es negativo", "mensaje", JOptionPane.INFORMATION_MESSAGE);
        } else if (y < 0) {
            JOptionPane.showMessageDialog(null, y + "es menor que 0 por la tanto es negativo", "mensaje", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (x > 0) {
                JOptionPane.showMessageDialog(null, x + "es mayor que 0 por lo tanto es positivo", "mensaje", JOptionPane.INFORMATION_MESSAGE);

            } else if (y > 0) {
                JOptionPane.showMessageDialog(null, y + "es mayor  que 0 por lo tanto es positivo", "mensaje", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        if (x % 5 == 0 && y % 5 == 0) {
            JOptionPane.showMessageDialog(null, "Ambos son divisibles entre 5", "mensaje", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (x % 5 == 0) {
                JOptionPane.showMessageDialog(null, x + "es divisible entre 5 ", "mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else if (y % 5 == 0) {
                JOptionPane.showMessageDialog(null, y + "es divisible entre 5", "mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "tanto" + x + "como" + y + "no son divisibles entre 5", "mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (x % 2 == 0) {
            JOptionPane.showMessageDialog(null, "Par", "mensaje", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Impar", "mensaje", JOptionPane.INFORMATION_MESSAGE);
        }

        for (int i = 0; i < 10; i++) {
            JOptionPane.showMessageDialog(null, "OLA K ASE", "OLA K ASE", JOptionPane.INFORMATION_MESSAGE);
            i--;
        }

    }

}
