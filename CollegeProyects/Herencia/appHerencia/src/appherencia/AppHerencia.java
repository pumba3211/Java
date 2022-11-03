/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appherencia;

import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class AppHerencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        clsEstudiante ana = new clsEstudiante("222", "Ana", "Soltera", "ISW", "1");
        JOptionPane.showMessageDialog(null, ana.toString());
        Profesor Pablo=new Profesor("ISW", "Informatica", "22331", "Pablo", "Casado");
        JOptionPane.showMessageDialog(null, Pablo.toString());
        
    }
}
