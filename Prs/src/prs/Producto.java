/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prs;

/**
 *
 * @author UTN
 */
public class Producto {

    private int codigo;
    private String Nombre;
    private String Tipo;
    private double precio;
    private int stock;

    public Producto() {
        this.codigo = 0;
        this.Nombre = "";
        this.Tipo = "";
        this.precio = 0.0;
        this.stock = 0;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
