/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author ACER
 */
public class Productos {

    private String codigo;
    private String descripcion;
    private String precio;

    public Productos(String descripcion, String codigo, String Precio) {

        this.codigo = codigo;
        this.precio = Precio;
        this.descripcion = descripcion;

    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
