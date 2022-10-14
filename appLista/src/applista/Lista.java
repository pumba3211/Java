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
public class Lista {
    //atributos de la clase

    private Nodo primero;
    private Nodo ultimo;
    private int tamaño;

    //método constructor
    public Lista() {
        this.primero = ultimo = null;
        this.tamaño = 0;
    }

    //método que me vuelve true si la lista está vacía
    public boolean vacia() {
        return (this.primero == null);
    }

    //método que agrega al inicio de la lista
    public boolean agregar(Object pDato) {
        boolean retorno = true;
        try {
            if (this.vacia()) {
                Nodo nuevo = new Nodo(pDato);
                this.primero = this.ultimo = nuevo;
            } else {
                Nodo nuevo = new Nodo(pDato);
                nuevo.sgte = this.primero;
                this.primero = nuevo;
            }
            this.tamaño++;
        } catch (Exception e) {
            retorno = false;
        }

        return (retorno);
    }

    //método que borra el último elemento de la lista
    public boolean borrar() {
        boolean retorno = true;
        if (this.vacia()) {
            retorno = false;
        }
        try {
            if (this.primero == this.ultimo) {
                this.primero = this.ultimo = null;
            } else {
                Nodo aux = this.primero;
                //me posiciono en el penúltimo elemento de la lista
                while (aux.sgte != this.ultimo) {
                    aux = aux.sgte;
                }
                aux.sgte = null;
                this.ultimo = aux;
            }
            this.tamaño--;
        } catch (Exception e) {
            retorno = false;
        }
        return (retorno);
    }

    //método toString
    public String toString() {
        String retorno = "";
        if (!this.vacia()) {
            Nodo aux = this.primero;
            for (int i = 0; i < this.tamaño; i++) {
                retorno = retorno + String.valueOf(aux.dato) + "\n";
                aux = aux.sgte;
            }
        }
        return (retorno);
    }

    public boolean agregarfinal(Object pDato) {
        boolean retorno = true;
        try {
            if (this.vacia()) {
                Nodo nuevo = new Nodo(pDato);
                this.primero = this.ultimo = nuevo;
            } else {
                Nodo nuevo = new Nodo(pDato);
                ultimo.sgte = nuevo;
                this.ultimo = nuevo;
            }
            this.tamaño++;
        } catch (Exception e) {
            retorno = false;
        }

        return (retorno);
    }

    public boolean borrarinicio() {
        boolean retorno = true;
        if (this.vacia()) {
            retorno = false;
        }
        try {
            if (this.primero == this.ultimo) {
                this.primero = this.ultimo = null;
            } else {
                Nodo aux = this.primero;
                this.primero = primero.sgte;
                aux.sgte = null;
            }
            this.tamaño--;
        } catch (Exception e) {
            retorno = false;
        }
        return (retorno);
    }

    public boolean borrarpenultimo() {
        boolean retorno = true;
        if (this.vacia()) {
            retorno = false;
        }
        try {
            if (this.primero == this.ultimo) {
                this.primero = this.ultimo = null;
            } else {
                Nodo aux = this.primero;
                //me posiciono en el penúltimo elemento de la lista

                if (tamaño == 2) {
                    this.primero = null;
                    primero = ultimo;
                } else {
                    for (int i = 1; i < tamaño - 2; i++) {
                        aux = aux.sgte;

                    }

                    aux.sgte = null;
                    aux.sgte = ultimo;
                }
            }
            this.tamaño--;
        } catch (Exception e) {
            retorno = false;
        }
        return (retorno);
    }

    public void borrarposicion(int pos) {
        if (pos < 0 || pos > tamaño) {
            JOptionPane.showMessageDialog(null, "EL rango no puede pasarse ni ser menor que 0");
        } else if (this.vacia()) {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } else {

            if (this.primero == this.ultimo) {
                this.primero = this.ultimo = null;
            } else {
                Nodo aux = this.primero;
                //me posiciono en el penúltimo elemento de la lista
                if (pos == 1) {
                    borrarinicio();
                } else if (pos == tamaño) {
                    borrar();
                } else {
                    for (int i = 1; i < pos - 1; i++) {
                        aux = aux.sgte;
                    }

                    Nodo aux2 = aux.sgte;
                    aux.sgte = aux2.sgte;
                    aux2.sgte = null;
                    tamaño--;

                }
            }

        }
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
//        this.tamaño = tamaño;
    }

    public void agregar7() {
        for (int i = 1; i <= 7; i++) {
            int numero = (int) ((Math.random() * 7) + 1);
            agregar(numero);
        }
//         agregar(4);
//         agregar(1);
//         agregar(7);
    }

    public void ordenar() {
        Nodo aux = this.primero;
        Nodo aux3 = this.primero;
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if ((Integer) aux.dato > (Integer) aux3.dato) {
                    int aux2 = (Integer) aux3.dato;
                    aux.dato = aux2;
                    aux3.dato = aux.dato;
                    aux3 = aux3.sgte;

                }
                aux3.dato = aux3.sgte.dato;

            }
            aux3 = this.primero;
            aux = aux.sgte;

        }
    }
}
