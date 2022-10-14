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
//SIRVE PARA GUARGAR EN UNA ARRAYLIST LOS DATOS DE LAS CITAS EN UN COMBOBOX CITAS
public class DatosCitas {

    private String Codigo_Cita;
    private String cod_mascota;
    private String mascota;
    private String fecha_cita;
    private String Estado;

    public DatosCitas(String Codigo_Cita, String cod_mascota, String mascota, String fecha_cita, String Estado) {
        this.Codigo_Cita = Codigo_Cita;
        this.cod_mascota = cod_mascota;
        this.mascota = mascota;
        this.fecha_cita = fecha_cita;
        this.Estado = Estado;
    }

    public String getCodigo_Cita() {
        return Codigo_Cita;
    }

    public String getCod_mascota() {
        return cod_mascota;
    }

    public String getMascota() {
        return mascota;
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public String getEstado() {
        return Estado;
    }

}
