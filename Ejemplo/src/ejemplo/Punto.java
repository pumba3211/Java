/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

/**
 *
 * @author UTN
 */
public class Punto {

    //Variable para guardar el punto X
    private float x;
    //Variable para guardar el punto y
    private float y;

    //Método constructor
    /**
     * Sirve para inicializar la clase punto, con los valores enviados por el
     * usuario
     *
     * @param pX float parametro para asignar en el atributo x
     * @param pY float parametro para asignar en el atributo y
     */
    public Punto(float pX, float pY) {
        this.x = pX;
        this.y = pY;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String toString() {
        return "Punto: ( X = " + this.x + ",Y = " + this.y + ")";
    }

    public float suma() {
        return this.x + this.y;
    }

    public float resta() {
        return this.x - this.y;
    }
}
