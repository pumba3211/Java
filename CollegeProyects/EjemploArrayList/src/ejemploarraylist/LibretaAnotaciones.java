/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploarraylist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Administrador
 */
public class LibretaAnotaciones {

    private ArrayList<String> notas;

    public LibretaAnotaciones() {
        notas = new ArrayList<>();
    }

    public void guardarNota(String nota) {
        notas.add(nota);
    }

    public void guardarNota(int posicion, String nota) {
        notas.add(posicion, nota);
    }

    public String leerNota(int posicion) {
        return notas.get(posicion);
    }

    public void eliminarNota(int posicion) {
        notas.remove(posicion);
    }

    public void modificarNota(int posicion, String nuevoValor) {
        notas.set(posicion, nuevoValor);
    }

    public int numeroDeNotas() {
        return notas.size();
    }

    @Override
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
