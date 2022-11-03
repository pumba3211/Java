/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applista;

import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class AppLista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lista miLista = new Lista();
//        miLista.agregar("Alexa");
//        miLista.agregar("Olger");
//        miLista.agregar("Tony");
//        miLista.agregar("Atencio");
//        int x=0;
        miLista.agregar7();

//        int confirmacion=0;
        JOptionPane.showMessageDialog(null, miLista.toString());
        miLista.ordenar();
        JOptionPane.showMessageDialog(null, miLista.toString());

//        while(confirmacion==0){
//            x=Integer.parseInt(JOptionPane.showInputDialog("Digite la posicion que desea eliminar"));
//            miLista.borrarposicion(x);
//            JOptionPane.showMessageDialog(null, miLista.toString());
//       
//            confirmacion= (JOptionPane.showConfirmDialog(null, "Desea borrar algo mas"));
//            
//        }
//        
//        
//        
//        JOptionPane.showMessageDialog(null, miLista.toString());
////        
//        miLista.borrarpenultimo();
////       
////        JOptionPane.showMessageDialog(null, miLista.toString());
////        miLista.borrarpenultimo();
////       
////        JOptionPane.showMessageDialog(null, miLista.toString());
////        miLista.borrar();
////        JOptionPane.showMessageDialog(null, miLista.toString());
////        miLista.borrar();
////        JOptionPane.showMessageDialog(null, miLista.toString());
////        miLista.borrar();
////        JOptionPane.showMessageDialog(null, miLista.toString());
////        miLista.borrar();
////        JOptionPane.showMessageDialog(null, miLista.toString());
    }

}
