/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaherencia;

import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class Empresa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        vendedor v1=new vendedor(10, 10000,"129", "Joaquin Perez", 8, 2006, 100000, 3);
        //JOptionPane.showMessageDialog(null, v1.toStringVendedor());
        administrativo a1=new administrativo(10, "12312", "Pablo",6, 2011, 480000, 3);
        JOptionPane.showMessageDialog(null, a1.toStringAdministrativo());
        operario op1=new operario(1000, 100, "130", "Marta Sanchez", 10, 2012, 200000, 3);
        //JOptionPane.showMessageDialog(null, op1.toStrignOperario());
    }
}
