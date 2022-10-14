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
//SIRVE PARA GUARGAR EN UNA ARRAYLIST LOS DATOS DE LOS DUEÑOS EN UN COMBOBOX DUEÑOS
public class DueñoDatos {

    private String Cedula;
    private String nombre;
    private String Apellido1;
    private String Apellido2;
    private String Telefono;
    private String Direccion;

    public DueñoDatos(String Cedula, String nombre, String Apellido1, String Apellido2, String Telefono, String Direccion) {
        this.Cedula = Cedula;
        this.nombre = nombre;
        this.Apellido1 = Apellido1;
        this.Apellido2 = Apellido2;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
    }

    public String getCedula() {
        return Cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String NombreCompleto() {
        return nombre + " " + Apellido1 + " " + Apellido2;
    }

}
