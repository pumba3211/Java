/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applista;

/**
 *
 * @author UTN
 */
public class Nodo {

    //atributos de la clase
    public Object dato;
    public Nodo sgte;

    //método constructor
    public Nodo(Object pDato) {
        this.dato = pDato;
        this.sgte = null;
    }

}
