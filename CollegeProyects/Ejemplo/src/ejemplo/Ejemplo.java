/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

/**
 *
 * @author UTN
 */
public class Ejemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Punto miPrimerPunto = new Punto(0, 0);
        System.out.println(miPrimerPunto.toString());
        miPrimerPunto.setX(2);
        miPrimerPunto.setY(5);
        System.out.println(miPrimerPunto.toString());
        System.out.println("Suma = " + (miPrimerPunto.suma()));
        System.out.println("Multiplicación = " + (miPrimerPunto.getX() * miPrimerPunto.getY()));
        System.out.println("División = " + (miPrimerPunto.getX() / miPrimerPunto.getY()));
        System.out.println("Resta = " + (miPrimerPunto.resta()));
    }
}
