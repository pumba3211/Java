/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cajabanco;

import javax.swing.JOptionPane;

/**
 *
 * @author John
 */
public class Lista {
    //atributos de la clase

    public Ficha ficha;
    private Nodo primero;
    private Nodo ultimo;
    private int tamaño;
    private String error;
    //método constructor

    public Lista() {
        this.primero = this.ultimo = null;
        this.tamaño = 0;
    }
    //método que me indica si la lista está vacía

    public boolean vacio() {
        return (this.primero == null);
    }

    //agregar al Inicio 
    public boolean agregarInicio(Ficha pDato) {
        boolean retorno = true;
        this.error = "";
        try {
            if (this.vacio()) {
                Nodo nuevo = new Nodo(pDato);
                this.primero = nuevo;
                this.ultimo = nuevo;

            } else {
                Nodo nuevo = new Nodo(pDato);
                nuevo.Sgte = this.primero;
                this.primero = nuevo;
            }
            this.tamaño++;
        } catch (Exception e) {
            this.error = "Error agregando a la lista, detalle:" + e.getMessage();
            retorno = false;
        }
        return retorno;
    }

    //método que inserta al final de la lista
    public void agregaFinal(Ficha pDato) {

        Nodo nuevo = new Nodo(pDato);

        try {
            //en caso que la lista esté vacía
            if (this.vacio()) {

                this.primero = nuevo;
                this.ultimo = nuevo;
            } //inserta al inicio de la lista cuando ya hay al menos un elemento
            else {

                this.ultimo.Sgte = nuevo;
                nuevo.Ant = this.ultimo;
                this.ultimo = nuevo;
            }
            //incrementa el tamaño de la lista
            tamaño++;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }
    //metodo para extraer el 1° número de la cola

    //Metodo para ordenar Lista
    public void ordenaPrioridad() {
        int cont = 0;

        do {

            Nodo temp = this.primero;
            Nodo aux = temp;
            Nodo aux2 = temp.Sgte;
            int temp1 = 0, temp2 = 0;
            String temp3 = "";
            String temp4 = "";

            for (int i = 0; i < tamaño - 1; i++) {
                if (temp.dato.categoria.compareTo(temp.Sgte.dato.categoria) == 0) {

                    temp = temp.Sgte;

                } else if (temp.dato.categoria.compareTo(temp.Sgte.dato.categoria) < 0) {

                    temp = temp.Sgte;

                } else if (temp.dato.categoria.compareTo(temp.Sgte.dato.categoria) > 0) {

                    temp3 = temp.dato.categoria;
                    temp4 = temp.Sgte.dato.categoria;
                    temp.Sgte.dato.categoria = temp3;
                    temp.dato.categoria = temp4;
                    temp1 = (Integer) temp.dato.numFicha;
                    temp2 = (Integer) temp.Sgte.dato.numFicha;
                    temp.Sgte.dato.numFicha = temp1;
                    temp.dato.numFicha = temp2;

                    temp = temp.Sgte;
                }
            }

            cont++;
        } while (cont < tamaño);
    }

    //agregar a cualquier lugar que no sea inicio ni el ultimo 
    public boolean agregarMedio(Ficha pDato) {
        boolean retorno = true;
        this.error = "";
        try {

            if (this.vacio()) {
                Nodo nuevo = new Nodo(pDato);
                this.primero = nuevo;
                this.ultimo = nuevo;
            } else {

                Nodo nuevo = new Nodo(pDato);
                Nodo aux = this.primero;

                if (aux.Sgte.dato.categoria.compareTo(pDato.categoria) > 0) {

                    Nodo aux2 = aux.Sgte;
                    aux.Sgte = nuevo;
                    nuevo.Sgte = aux2;

                } else {

                    while (pDato.categoria.compareTo(aux.dato.categoria) > 0) {

                        aux = aux.Sgte;

                    }

                    while (aux.Sgte.dato.categoria.compareTo(pDato.categoria) == 0) {

                        aux = aux.Sgte;

                    }

                    Nodo aux2 = aux.Sgte;
                    aux.Sgte = nuevo;
                    nuevo.Sgte = aux2;
                }
            }

            this.tamaño++;
        } catch (Exception e) {
            this.error = "Error agregando a la lista, detalle:" + e.getMessage();
            retorno = false;
        }
        return retorno;
    }

    // Metodo que extrae el primer elemento de la fila
    public void BuscarAgregar(Ficha pDato) {
        if (this.vacio()) {
            agregarInicio(pDato);

        } else if (pDato.categoria.compareTo(this.primero.dato.categoria) < 0) {
            this.agregarInicio(pDato);

        } else if (pDato.categoria.compareTo(this.primero.dato.categoria) == 0 && this.tamaño == 1) {
            this.agregaFinal(pDato);

        } else if (pDato.categoria.compareTo(this.primero.dato.categoria) > 0 && this.tamaño == 1) {
            this.agregaFinal(pDato);

        } else if (pDato.categoria.compareTo(this.primero.dato.categoria) >= 0 && pDato.categoria.compareTo(this.ultimo.dato.categoria) < 0) {
            this.agregarMedio(pDato);

        } else if (pDato.categoria.compareTo(this.primero.dato.categoria) > 0 && pDato.categoria.compareTo(this.ultimo.dato.categoria) > 0) {
            this.agregaFinal(pDato);

        } else if (pDato.categoria.compareTo(this.ultimo.dato.categoria) == 0) {
            this.agregaFinal(pDato);

        }
    }

    public String extraer() {

        if (!vacio()) {
            String informacion = primero.dato.categoria + String.valueOf(primero.dato.numFicha);
            if (primero == ultimo) {
                primero = null;
                ultimo = null;
            } else {
                primero = primero.Sgte;
            }
            tamaño--;
            return informacion;
        } else {
            return String.format("");
        }
    }

    //Metodo para imprimir String
    public String toString() {

        String retorno = "";
        Nodo temp = this.primero;
        for (int i = 0; i < this.tamaño; i++) {
            retorno = retorno + temp.dato.categoria + " " + String.valueOf(temp.dato.numFicha) + "\n";
            temp = temp.Sgte;

        }
        return retorno;
    }

}
