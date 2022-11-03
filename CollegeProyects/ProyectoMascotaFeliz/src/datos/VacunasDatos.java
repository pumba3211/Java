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
//SIRVE PARA GUARGAR EN UNA ARRAYLIST LOS DATOS DE LAS VACUNAS EN UN COMBOBOX VACUNA
public class VacunasDatos {

    String Codigo_Vacuna;
    String Nombre_Vacuna;

    public VacunasDatos(String Codigo_Vacuna, String Nombre_Enfermedad) {
        this.Codigo_Vacuna = Codigo_Vacuna;
        this.Nombre_Vacuna = Nombre_Enfermedad;
    }

    public String getCodigo_Vacuna() {
        return Codigo_Vacuna;
    }

    public String getVacuna_Nombre() {
        return Nombre_Vacuna;
    }

}
