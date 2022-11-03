/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fraccion;

/**
 *
 * @author UTN
 */
public class fraccio {

    private int n1;
    private int n2;

    public fraccio() {
        this.n1 = 0;
        this.n2 = 1;

    }

    public float getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public float getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;

    }

    public void imprimefraccion() {

        System.out.println("Su fraccion es" + this.n1 + "/" + this.n2);

    }

    public float valorfraccion() {
        float result2;
        result2 = (float) n1 / n2;
        return (result2);

    }

    public float suma(fraccio f1, fraccio f2) {
        float result;
        result = f1.valorfraccion() + f2.valorfraccion();
        return (result);
    }
}
