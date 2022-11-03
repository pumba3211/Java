/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Estructuras.Lista;
import javax.swing.JOptionPane;

/**
 *
 * @author jpabloq
 */
public class AppListas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            Lista oLista = new Lista();
            oLista.agregar("Mainor");
            oLista.agregar("Pablo");
            oLista.agregar("Denis");
            oLista.agregar("Jose");
            JOptionPane.showMessageDialog(null,oLista.toString());
            oLista.borrar();
		JOptionPane.showMessageDialog(null,oLista.toString());
		oLista.borrar();
		JOptionPane.showMessageDialog(null,oLista.toString());
		oLista.borrar();
		JOptionPane.showMessageDialog(null,oLista.toString());
		oLista.borrar();
		JOptionPane.showMessageDialog(null,oLista.toString());
    }
}
