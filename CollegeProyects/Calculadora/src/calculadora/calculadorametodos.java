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
public class calculadorametodos {

    int operando1;
    int operando2;

    public calculadorametodos() {

        this.operando1 = 0;
        this.operando2 = 0;
    }

    public int getOperando1() {
        return operando1;
    }

    public void setOperando1(int operando1) {
        this.operando1 = operando1;
    }

    public int getOperando2() {
        return operando2;
    }

    public void setOperando2(int operando2) {
        this.operando2 = operando2;
    }

    public void sumar() {

        JOptionPane.showMessageDialog(null, "La suma de " + operando1 + " + " + operando2 + " es " + (operando1 + operando2), "Calculadora", JOptionPane.INFORMATION_MESSAGE);
    }

    public void restar() {

        JOptionPane.showMessageDialog(null, "La resta de " + operando1 + " - " + operando2 + " es " + (operando1 - operando2), "Calculadora", JOptionPane.INFORMATION_MESSAGE);
    }

    public void multipiclacion() {

        JOptionPane.showMessageDialog(null, "La multiplicacion de " + operando1 + " x " + operando2 + " es " + (operando1 * operando2), "Calculadora", JOptionPane.INFORMATION_MESSAGE);
    }

    public void division() {

        JOptionPane.showMessageDialog(null, "La division de " + operando1 + " / " + operando2 + " es " + (operando1 / operando2), "Calculadora", JOptionPane.INFORMATION_MESSAGE);
    }
}
