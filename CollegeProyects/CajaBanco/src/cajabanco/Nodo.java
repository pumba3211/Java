/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cajabanco;

/**
 *
 * @author John
 */
public class Nodo {
    //atributos de la clase

    public Ficha dato;
    public Nodo Sgte;
    public Nodo Ant;

    //método constructor
    public Nodo(Ficha dato) {
        this.dato = dato;
        this.Sgte = null;
        this.Ant = null;
    }
}
