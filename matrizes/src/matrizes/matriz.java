/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizes;

/**
 *
 * @author UTN
 */
public class matriz {

    private int[][] m;

    public matriz(int f, int c) {
        m = new int[f][c];
    }

    public void llenarmatriz() {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int) (Math.random() * 100) + 1;
            }
        }
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                resultado = resultado + " " + m[i][j];
            }
            resultado = resultado + "\n";

        }
        return resultado;
    }

    public int maximi() {
        int max = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (max < m[i][j]) {
                    max = m[i][j];
                }
            }

        }
        return max;
    }

    public int minimo() {
        int minimo = m[1][1];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (minimo > m[i][j]) {
                    minimo = m[i][j];
                }
            }

        }
        return minimo;
    }

}
