/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Ronald
 */
//SIRVE PARA GUARGAR EN UNA ARRAYLIST LOS DATOS DE LAS ENFERMEDAD EN UN COMBOBOX ENFERMEDAD
public class EnfermedadDatos {

    String codigo_Enfermedad;
    String nombre_Enfermedad;

    public EnfermedadDatos(String codigo_Enfermedad, String nombre_Enfermedad) {
        this.codigo_Enfermedad = codigo_Enfermedad;
        this.nombre_Enfermedad = nombre_Enfermedad;
    }

    public String getCodigo_Enfermedad() {
        return codigo_Enfermedad;
    }

    public String getNombre_Enfermedad() {
        return nombre_Enfermedad;
    }

}
