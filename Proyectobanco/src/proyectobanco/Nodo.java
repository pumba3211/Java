/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobanco;

/**
 *
 * @author Ronald
 */
public class Nodo {

    public cliente dato;//Almacena un dato tipo cliente
    public Nodo siguiente;
    public Nodo anterior;
    //Metodo constructor

    public Nodo(cliente pDato) {
        this.dato = pDato;
        this.siguiente = null;
        this.anterior = null;
    }
}
