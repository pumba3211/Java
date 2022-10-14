/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana;

/**
 *
 * @author Ronald
 */
public class lyt {

    private String Nombre;
    private double tarifa;

    public lyt() {
        this.Nombre = "";
        this.tarifa = 0;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

}
