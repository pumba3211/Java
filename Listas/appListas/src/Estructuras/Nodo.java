/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author jpabloq
 */
public class Nodo {
    public Object dato;
    public Nodo siguiente;
    public Nodo anterior;
    
    public Nodo(Object pDato)
    {
        this.dato = pDato;
	this.siguiente = null;
        this.anterior = null;
    }
}
