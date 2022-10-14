/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appColasPrioridadSimples;

/**
 *
 * @author UTN
 */
public class Lista {

    private Nodo primero;
    private Nodo ultimo;
    private int tamanno;
    private String error;

    public Lista() {
        this.primero = null;
        this.ultimo = null;
        this.tamanno = 0;
    }

    public boolean vacio() {
        return (this.primero == null);
    }

    //agregar al Inicio 
    public boolean agregarInicio(Object pDato) {
        boolean retorno = true;
        this.error = "";
        try {
            if (this.vacio()) {
                Nodo nuevo = new Nodo(pDato);
                this.primero = nuevo;
                this.ultimo = nuevo;

            } else {
                Nodo nuevo = new Nodo(pDato);
                nuevo.siguiente = this.primero;
                this.primero = nuevo;
            }
            this.tamanno++;
        } catch (Exception e) {
            this.error = "Error agregando a la lista, detalle:" + e.getMessage();
            retorno = false;
        }
        return retorno;
    }

    //agregar al Final de la cola
    public boolean agregarFinal(Object pDato) {
        boolean retorno = true;
        this.error = "";
        try {
            if (this.vacio()) {
                Nodo nuevo = new Nodo(pDato);
                this.primero = nuevo;
                this.ultimo = nuevo;

            } else {
                Nodo nuevo = new Nodo(pDato);
                this.ultimo.siguiente = nuevo;
                this.ultimo = nuevo;
            }
            this.tamanno++;
        } catch (Exception e) {
            this.error = "Error agregando a la lista, detalle:" + e.getMessage();
            retorno = false;
        }
        return retorno;
    }

    //agregar al cualquier lugar que no sea inicio ni el ultimo xDDD
    public boolean agregarMedio(Object pDato) {
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
                while (((Integer) aux.siguiente.dato) < ((Integer) (pDato))) {
                    aux = aux.siguiente;
                }
                Nodo aux2 = aux.siguiente;
                aux.siguiente = nuevo;
                nuevo.siguiente = aux2;
            }
            this.tamanno++;
        } catch (Exception e) {
            this.error = "Error agregando a la lista, detalle:" + e.getMessage();
            retorno = false;
        }
        return retorno;
    }

    //agregar al Busca donde agregar
    public void BuscarAgregar(Object pDato) {
        if (this.vacio()) {
            agregarInicio(pDato);
        } else if (((Integer) (pDato)) < ((Integer) this.primero.dato)) {
            this.agregarInicio(pDato);
        } else if (((Integer) pDato) > ((Integer) this.ultimo.dato)) {
            this.agregarFinal(pDato);
        } else {
            agregarMedio(pDato);
        }

    }

    public boolean borrar() {
        boolean retorno = true;
        this.error = "";
        if (this.vacio()) {
            this.error = "La lista se encuentra vacia";
            retorno = false;
            return retorno;
        }
        try {
            if (this.primero == this.ultimo) {
                this.primero = null;
                this.ultimo = null;
            } else {
//                Nodo aux = this.ultimo.anterior;
//                ultimo.anterior = null;
                ultimo.siguiente = null;
//                ultimo = aux;
                ultimo.siguiente = primero;
//                primero.anterior = ultimo;
            }

            this.tamanno--;
        } catch (Exception e) {
            this.error = "Error borrando de la lista, detalle:" + e.getMessage();
            retorno = false;
        }
        return retorno;
    }

    public int getTamanno() {
        return this.tamanno;
    }

    public String getError() {
        return this.error;
    }

    public String toString() {
        String retorno = "";
        if (!this.vacio()) {
            Nodo temp = this.primero;
            for (int i = 0; i < this.tamanno; i++) {
                retorno = retorno + String.valueOf(temp.dato) + "\n";
                temp = temp.siguiente;
            }
        }
        return retorno;
    }
}
