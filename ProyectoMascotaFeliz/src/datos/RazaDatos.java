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
//SIRVE PARA GUARGAR EN UNA ARRAYLIST LOS DATOS DE LAS RAZA EN UN COMBOBOX RAZA
public class RazaDatos {

    private String cod_raza;
    private String cod_especie;
    private String Nombre;

    public RazaDatos(String cod_raza, String cod_especie, String Nombre) {
        this.cod_raza = cod_raza;
        this.cod_especie = cod_especie;
        this.Nombre = Nombre;
    }

    public String getCod_raza() {
        return cod_raza;
    }

    public String getCod_especie() {
        return cod_especie;
    }

    public String getNombre() {
        return Nombre;
    }

}
