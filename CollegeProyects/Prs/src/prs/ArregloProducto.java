/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prs;

import java.util.ArrayList;

/**
 *
 * @author UTN
 */
public class ArregloProducto {

    private ArrayList<Producto> productos;
    private int Numero;
    private String busqueda;

    public ArregloProducto() {
        productos = new ArrayList();
        this.Numero = 0;
        this.busqueda = "";
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;

    }

    public String Agregar(Producto p) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equals(p.getNombre())) {
                return ("Producto repetido");
            }
        }
        productos.add(p);
        return ("El producto ha sido agregado satisfactoriamente");
    }

    public String eliminar() {
        int cont = 0;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getStock() == 0) {
                productos.remove(i);
                cont++;
            }
        }
        return ("Se eliminaron " + cont + "productos");
    }

    public String obtener() {
        if (Numero > productos.size()) {
            return "EL numero que digito es mayor a la cantidad de productos que hay";

        }
        return "Se ha encontrado" + productos.get(Numero);

    }

    public String buscar() {
        String resultado = "";
        for (int i = 0; i <= productos.size(); i++) {
            if (busqueda == productos.get(i).getNombre()) {
                resultado = "Se encontro " + productos.get(i) + " en la posicion " + i;

            } else {
                resultado = "No se ha encontrado";
            }
        }
        return resultado;
    }

    public String tamaño() {
        return "Se tienen " + productos.size();
    }

    public String aumentarprecio() {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getTipo() == "Oficina") {
                productos.get(i).setPrecio((productos.get(i).getPrecio()) * 1.10F);
            }
        }
        return "Se han aumentando correctamene";
    }

}
