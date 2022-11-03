/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appherencia;

/**
 *
 * @author UTN
 */
public class clsEstudiante extends clsPersona {
    //atributos de la clase
    private String carrera;
    private String carnet;
    
    //Método constructor
    public clsEstudiante(String pCedula, String pNombre, String pEstado, String pCarrera, String pCarnet)
    {
        super(pCedula,pNombre,pEstado);
        this.carrera = pCarrera;
        this.carnet = pCarnet;
    }
    
    //método toString
    public String toString()
    {
        return(super.toString() + " Carrera: " + this.carrera + " Carnét: " + this.carnet);
    }
    
    
}
