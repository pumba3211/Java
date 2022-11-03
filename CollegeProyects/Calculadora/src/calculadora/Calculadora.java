/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        int seleccion = 0;
        do {

            int operando1 = Integer.parseInt(JOptionPane.showInputDialog("Digite un primer numero"));
            int operando2 = Integer.parseInt(JOptionPane.showInputDialog("Digite un segundo  numero"));
            calculadorametodos c = new calculadorametodos();
            c.setOperando1(operando1);
            c.setOperando2(operando2);
            int metodo = Integer.parseInt(JOptionPane.showInputDialog("Selecione alguna de las opciones: \n 1 sumar \n 2 Restar \n 3 Multiplicar  \n 4 Dividir"));
            switch (metodo) {
                case 1:
                    c.sumar();
                    break;
                case 2:
                    c.restar();
                    break;
                case 3:
                    c.multipiclacion();
                    break;
                case 4:
                    c.division();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opcion es incorrecta ", "ERROR 404 OPTION NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
            seleccion = JOptionPane.showOptionDialog(null, "¿Desea Usar la calculadora de nuevo?",
                    "Seleccione una opción",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Si", "No"},
                    "Si");

        } while (seleccion == 0);
    }
}
