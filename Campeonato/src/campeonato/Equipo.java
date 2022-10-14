/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package campeonato;

import java.util.ArrayList;

/**
 *
 * @author UTN
 */
public class Equipo {

    private String nombre;
    private int ID;
    private String color;
    private ArrayList<JUGADOR> jugadores;
    private JUGADOR jugador;

    public Equipo(String nombre, int ID, String color, JUGADOR j) {
        this.nombre = nombre;
        this.ID = ID;
        this.color = color;
        this.jugador = j;
        this.jugadores = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<JUGADOR> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<JUGADOR> jugadores) {
        this.jugadores = jugadores;
    }

    public JUGADOR getJugador() {
        return jugador;
    }

    public void setJugador(JUGADOR jugador) {
        this.jugador = jugador;
    }

    public double costoequipo() {
        double resultado = 0;
        for (int i = 0; i < jugadores.size(); i++) {
            resultado = resultado + jugadores.get(i).getCosto();
        }
        return (resultado);

    }

    public void agregarjugador(JUGADOR j) {
        jugadores.add(j);

    }

    public String tostringequipos() {
        String retorno = "";
        retorno = "Equipo: " + this.nombre + " ID: " + this.ID + " Colores: " + this.color + "Costo total juadores " + costoequipo() + "\n";
        for (int i = 0; i < jugadores.size(); i++) {
            retorno = retorno + jugadores.get(i).toStringjugador() + "\n";
        }
        return (retorno);
    }

}
