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
//SIRVE PARA GUARGAR EN UNA ARRAYLIST LOS DATOS DE LAS ENFERMEDAD Y VACUNAS EN UN COMBOBOX DE ENFERMEDAD VACUNA
public class Datosvacunaenfermedad {

    String cod_vacuna;
    String Nombre_Vacuna;
    String Porcentage_Efectividad;

    public Datosvacunaenfermedad(String cod_vacuna, String Nombre_Vacuna, String Porcentage_Efectividad) {
        this.cod_vacuna = cod_vacuna;
        this.Nombre_Vacuna = Nombre_Vacuna;
        this.Porcentage_Efectividad = Porcentage_Efectividad;
    }

    public String getCod_vacuna() {
        return cod_vacuna;
    }

    public String getNombre_Vacuna() {
        return Nombre_Vacuna;
    }

    public String getPorcentage_Efectividad() {
        return Porcentage_Efectividad;
    }

}
