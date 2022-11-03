/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea;

/**
 *
 * @author Personal
 */
public class Vuelo {

    private int identificador;
    private int tsalida;
    private int tllegada;
    private avion elavion;

    public Vuelo() {
        this.identificador = 0;
        this.tsalida = 0;
        this.tllegada = 0;
        this.elavion = null;

    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getTsalida() {
        return tsalida;
    }

    public void setTsalida(int tsalida) {
        this.tsalida = tsalida;
    }

    public int getTllegada() {
        return tllegada;
    }

    public void setTllegada(int tllegada) {
        this.tllegada = tllegada;

    }

    public avion getElavion() {
        return elavion;
    }

    public void setElavion(avion elavion) {
        this.elavion = elavion;
    }

}
