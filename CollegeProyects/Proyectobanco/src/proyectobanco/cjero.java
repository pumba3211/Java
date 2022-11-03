/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobanco;

/**
 *
 * @author Ronald
 */
public class cjero {

    private String Nombre;//Nombre del Cajero.
    listacajero lista = new listacajero();//Guarda los datos y manipulacion de una lista de clientes.
    //Metodo Constructor.

    public cjero(String Nombre) {
        this.Nombre = Nombre;
    }

    //Metodos Set y Get
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public listacajero getLista() {
        return lista;
    }

    public void setLista(listacajero lista) {
        this.lista = lista;
    }

    //Realiza la obtencion de  la clase cajero.
    public String toStringCajero() {
        String resultado = "";
        resultado = Nombre + "   " + "Promedio de atencion al cliente " + lista.promedioDeTiempoAtendiendo();
        return (resultado);
    }

    //Realiza la obtencion de datos de listacajero y cajero.
    public String toStringResultados() {
        String resultado = toStringCajero();
        return (resultado + "\n" + lista.toStringLista());

    }

}
