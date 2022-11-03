/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appherencia;

/**
 *
 * @author UTN
 */
public class Profesor extends clsPersona {
    //atributos de la clase
    private String Carrera;
    private String departamento;
   //Metodo constructor
    public Profesor(String Carrera, String departamento, String pCedula, String pNombre, String pEstado) {
        super(pCedula, pNombre, pEstado);
        this.Carrera = Carrera;
        this.departamento = departamento;
    }
    //metodo tostring
    public String toString(){
        return(super.toString()+" Carrera "+this.Carrera+" Departamento "+this.departamento);
    }
    
   
}
