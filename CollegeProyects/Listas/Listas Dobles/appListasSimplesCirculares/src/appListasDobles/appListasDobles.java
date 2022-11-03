/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appListasDobles;

import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class appListasDobles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Lista l = new Lista();
        
        for(int i =1;i<=10;i++){
            l.agregar(i);
            
            
            
        }
        
       JOptionPane.showMessageDialog(null, l.toString());
       l.borrar();
       JOptionPane.showMessageDialog(null, l.toString());
}
}
