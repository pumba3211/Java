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
//SIRVE PARA GUARGAR EN UNA ARRAYLIST LOS DATOS DE LAS MASCOTAS EN UN COMBOBOX MASCOTA
public class MascotaDatos {

    private String nombre;
    private String fecha_nacimiento;
    private String cod_raza;
    private String cedula;
    private String cod_mascota;

    public MascotaDatos(String nombre, String fecha_nacimiento, String cod_raza, String cedula, String cod_mascota) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.cod_raza = cod_raza;
        this.cedula = cedula;
        this.cod_mascota = cod_mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getCod_raza() {
        return cod_raza;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCod_mascota() {
        return cod_mascota;
    }

}
