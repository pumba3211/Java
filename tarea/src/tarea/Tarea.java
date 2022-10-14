/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea;

/**
 *
 * @author Personal
 */
public class Tarea {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        avion t1 = new avion();
        t1.setCapacidad(2345);
        t1.setTipo("Primera clase");
        aeropuertos aero = new aeropuertos();
        aero.setNombre("The best");
        aero.setPais("London");
        Vuelo v = new Vuelo();
        v.setIdentificador(234);
        v.setTllegada(12);
        v.setTsalida(5);
        v.setElavion(t1);
        System.out.println(aero.getNombre());
        System.out.println(v.getElavion().getTipo());
        System.out.println(v.getTsalida());
        System.out.println(v.getTllegada());
        System.out.println(aero.getPais());

    }
}
