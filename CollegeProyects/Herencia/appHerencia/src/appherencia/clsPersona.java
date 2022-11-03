/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appherencia;

/**
 *
 * @author UTN
 */
public class clsPersona {
    
    //atributos de la clase
    protected String cedula;
    protected String nombre;
    protected String estado;
    
    //método constructor
    public clsPersona(String pCedula, String pNombre, String pEstado)
    {
        this.cedula = pCedula;
        this.estado = pEstado;
        this.nombre = pNombre;
    }
    
    //método toString, devuelve los atributos concatenados en un String
    public String toString()
    {
        return("Cédula: " + this.cedula + " Nombre: " + this.nombre + " Estado: " + this.estado);
    }
    
}
