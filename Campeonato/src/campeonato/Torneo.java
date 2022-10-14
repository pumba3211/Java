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
public class Torneo {

    private String Nombre;
    private String ID;

    private ArrayList<Equipo> equipos;
    private Equipo equipo;

    public Torneo(String Nombre, String ID, Equipo e) {
        this.Nombre = Nombre;
        this.ID = ID;

        this.equipos = new ArrayList();
        this.equipo = e;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public double costototal() {
        double resultado = 0;
        for (int i = 0; i < equipos.size(); i++) {
            resultado = resultado + equipos.get(i).costoequipo();

        }
        return (resultado);

    }

    public void agregarequipo(Equipo equipment) {
        equipos.add(equipment);

    }

    public String tostringequipos() {
        String retorno = "";

        retorno = "Torneo: " + this.Nombre + " ID: " + this.ID + " Colores: " + "Costo del torneo" + costototal() + "\n";
        for (int i = 0; i < equipos.size(); i++) {
            retorno = retorno + equipos.get(i).tostringequipos() + "\n";
        }
        return (retorno);
    }
}
