/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author UTN
 */
public class Libretaanotaciones {

    private ArrayList<String> notas;
    private ArrayList<Integer> arreglo;

    public Libretaanotaciones() {
        notas = new ArrayList<>();
    }

    public void guardarnota(String nota) {
        notas.add(nota);
    }

    public void guardarnota(int posicion, String nota) {
        notas.add(posicion, nota);

    }

    public void modificarnota(int posicion, String nuevovalor) {
        notas.set(posicion, nuevovalor);
    }

    public String leernota(int posicion) {
        return notas.get(posicion);
    }

    public void elminarnota(int posicion) {
        notas.remove(posicion);
    }

    public int numerodenotas() {
        return notas.size();
    }

    public String toString() {
        Iterator<String> iterador = notas.iterator();
        String resultado = "";
        String it;
        while (iterador.hasNext()) {
            it = iterador.next();
            resultado = resultado + it + "\n";

        }
        return resultado;
    }

}
