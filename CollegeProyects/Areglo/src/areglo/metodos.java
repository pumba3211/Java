/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package areglo;

import sun.security.util.Length;

/**
 *
 * @author UTN
 */
public class metodos {

    private int arreglo[];

    public metodos(int n) {//n para que el usario sea el que defina la cantidad de espacios dentro del arreglo
        this.arreglo = new int[n];
    }

    public void llenar() {
        for (int i = 0; i < this.arreglo.length; i++) {
            this.arreglo[i] = (int) (Math.random() * 100) + 1;

        }
    }

    public String imprimir() {
        String texto = "";
        for (int i = 0; i < this.arreglo.length; i++) {
            texto = texto + "\n" + this.arreglo[i];
        }
        return texto;

    }

    public int espacios() {
        int esp = 0;
        for (int i = 0; i < this.arreglo.length; i++) {
            esp = i;
        }
        return esp;

    }

    public float promedio() {
        float suma = 0;

        for (int i = 0; i < this.arreglo.length; i++) {
            suma = suma + this.arreglo[i];

        }
        return (suma / this.arreglo.length);
    }

    public int mayor() {
        int mayor = 0;
        for (int i = 0; i < this.arreglo.length - 1; i++) {

            if (mayor < this.arreglo[i]) {
                mayor = this.arreglo[i];

            }

        }
        return (mayor);
    }

    public int sumarimpares() {
        int suma = 0;
        for (int i = 0; i < this.arreglo.length; i++) {
            if (this.arreglo[i] % 2 == 1) {
                suma = suma + this.arreglo[i];
            }
        }
        return (suma);
    }

    public String buscar(int num) {
        String esta = "";
        for (int i = 0; i < this.arreglo.length; i++) {
            if (this.arreglo[i] == num) {
                esta = "El numero si esta y esta en la fila " + (i + 1) + " del arreglo";

                break;

            } else {
                esta = "No se encontro";
            }

        }
        return (esta);
    }

    public void invertir() {
        int cont = 0;
        int invertido[] = new int[this.arreglo.length];
        for (int i = this.arreglo.length - 1; i >= 0; i--) {
            invertido[cont] = this.arreglo[i];
            cont++;
        }

        arreglo = invertido;

    }

    public void rotararreglo() {
        int almacenar[] = this.arreglo;
        int ultimo = this.arreglo[this.arreglo.length - 1];
        for (int i = 0; i < this.arreglo.length - 2; i++) {
            this.arreglo[i + 1] = almacenar[i];

        }

        this.arreglo[0] = ultimo;

    }

}
