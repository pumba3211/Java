/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas.de.multipiclar;

/**
 *
 * @author UTN
 */
public class multi {

    private int numero;

    public multi() {
        this.numero = 0;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void calcular() {
        for (int cont = 0; cont <= 10; cont++) {
            System.out.println(numero + "x" + cont + "=" + (cont * numero));
        }

    }

}
