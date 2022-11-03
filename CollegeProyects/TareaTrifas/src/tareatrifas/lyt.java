/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tareatrifas;

/**
 *
 * @author Ronald
 */
public class lyt {
    private String nombre;
    private Double Tarifa;

    public lyt() {
        this.nombre ="";
        this.Tarifa =0.0;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getTarifa() {
        return Tarifa;
    }

    public void setTarifa(Double Tarifa) {
        this.Tarifa = Tarifa;
    }
    
    
}
