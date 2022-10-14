/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fraccion;

/**
 *
 * @author UTN
 */
public class Fraccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        fraccio fraccion1 = new fraccio();
        fraccion1.setN1(3);
        fraccion1.setN2(45);
        fraccion1.imprimefraccion();
        fraccio fraccion2 = new fraccio();
        fraccion2.setN1(34);
        fraccion2.setN2(35);
        fraccion2.imprimefraccion();
        fraccio suma1 = new fraccio();
        System.out.println(suma1.suma(fraccion1, fraccion2));

    }
}
