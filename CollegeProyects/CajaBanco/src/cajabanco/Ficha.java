/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cajabanco;

/**
 *
 * @author dimelo matatan
 */
// clase Ficha con sus Atributos
public class Ficha {

    public String categoria;
    public int numFicha;

    // Constructor de la clase Ficha
    public Ficha(String categoria, int numFicha) {
        this.categoria = categoria;
        this.numFicha = numFicha;
    }

    // Metodos get y set
    public int getNumFicha() {
        return numFicha;
    }

    public void setNumFicha(int numFicha) {
        this.numFicha = numFicha;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
