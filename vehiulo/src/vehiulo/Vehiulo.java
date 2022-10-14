/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiulo;

import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class Vehiulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int costo = Integer.parseInt(JOptionPane.showInputDialog("Digite el costo del vehiculo"));
        int numPas = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de pasajeros"));
        int numejes = Integer.parseInt(JOptionPane.showInputDialog("Dijite el numero de ejes"));
        double costotal = (costo * 0.01);
        if (numPas < 20) {
            costotal = costotal * 1.01;
        } else if (numPas >= 20 && numPas <= 60) {
            costotal = costotal * 1.05;

        } else {
            costotal = costotal * 1.08;

        }
        double costovehiculo = costotal + costo;
        JOptionPane.showMessageDialog(null, "El costo total del vehiculo es de  " + costovehiculo + '\n' + "Costo Vehiculo " + costo + '\n' + "Costos adicionales de " + "" + costotal, "Costo", JOptionPane.INFORMATION_MESSAGE);
    }
}
