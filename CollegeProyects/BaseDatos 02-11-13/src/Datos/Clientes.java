package Datos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ACER
 */
public class Clientes {

    private String Nombre;
    private String codigo;

    public Clientes(String nombre, String cod) {

        this.Nombre = nombre;
        this.codigo = cod;

    }

    public String getNombre() {

        return this.Nombre;

    }

    public String getCodigo() {

        return this.codigo;
    }

}
