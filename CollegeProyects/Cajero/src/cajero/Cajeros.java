/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class Cajeros {

    private int cantidad;

    public Cajeros() {
        this.cantidad = 0;

    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void desglosar() {
        String desgloce = "";

        if (cantidad / 500 != 0) {
            int b500 = cantidad / 500;
            cantidad = cantidad - (b500 * 500);
            desgloce += b500 + "Billetes de 500 euros\n";

        }
        if (cantidad / 200 != 0) {
            int b200 = cantidad / 200;
            cantidad = cantidad - (b200 * 200);
            desgloce += b200 + "Billetes de 200 euros\n";

        }
        if (cantidad / 100 != 0) {
            int b100 = cantidad / 100;
            cantidad = cantidad - (b100 * 100);
            desgloce += b100 + "Billetes de 100 euros\n";
        }

        if (cantidad / 50 != 0) {
            int b50 = cantidad / 50;
            cantidad = cantidad - (b50 * 50);
            desgloce += b50 + "Billetes de 500 euros\n";
        }

        if (cantidad / 20 != 0) {
            int b20 = cantidad / 20;
            cantidad = cantidad - (b20 * 20);
            desgloce += b20 + "Billetes de 20 euros\n";
        }
        if (cantidad / 10 != 0) {
            int b10 = cantidad / 10;
            cantidad = cantidad - (b10 * 10);
            desgloce += b10 + "Billetes de 10 euros\n";
        }
        if (cantidad / 5 != 0) {
            int b5 = cantidad / 10;
            cantidad = cantidad - (b5 * 5);
            desgloce += b5 + "Billetes de 5 euros\n";
        }
        if (cantidad / 2 != 0) {
            int b2 = cantidad / 2;
            cantidad = cantidad - (b2 * 2);
            desgloce += b2 + "Monedas  de 2 euros\n";
        }
        if (cantidad / 1 != 0) {
            int b1 = cantidad / 1;
            cantidad = cantidad - (b1 * 1);
            desgloce += b1 + "Moneads de 1 euros\n";

        }
        JOptionPane.showMessageDialog(null, desgloce, "Cajero", JOptionPane.INFORMATION_MESSAGE);
    }
}
