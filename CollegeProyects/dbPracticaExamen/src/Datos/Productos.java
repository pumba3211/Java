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
    private String existencia;

    public Productos(String descripcion, String codigo, String existencia) {

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.existencia = existencia;

    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getExistencia() {

        return existencia;
    }

}
