/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

/**
 *
 * @author Personal
 */
public class Maquinas {

    private char nombreProducto;
    private int cantidadProducto;

    public Maquinas(char nombreProducto, int cantidadProducto) {
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
    }

    public char getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(char nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public void tiempoProducto() {
    }
    private int cantidadMeses;
    private int cantidadDias;
    private int cantidadHoras;
    private float produccion;
    int meses = 0;
    int días = 0;
    int horas = 0;

    {
        produccion = (meses * 30) * 24 + días * 24 + horas;
    }

    public void trabajoMaquina() {
    }
    int trabajoDiasSemana = 5;
    int trabajoHorasDia = 10;
    int horasReparacion = 2;
    double probabilidad = produccion * 0.1;
    double totalReparacion = produccion * 0.10;
}
