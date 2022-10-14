/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package array;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author UTN
 */
public class Array {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int v1[] = {1, 2, 3};
        int v2[] = {1, 2, 3};
        System.out.println(Arrays.equals(v1, v2));
        int v3[] = new int[5];
        Arrays.fill(v3, 10);
        for (int i = 0; i < v3.length; i++) {
            System.out.println(v3[i]);
        }
        int v4[] = {1, 2, 3, 10, 5};
        Arrays.fill(v4, 3, 4, 4);
        for (int i = 0; i < v4.length; i++) {
            System.out.println(v4[i]);
        }
        int v5[] = {4, 2, 3, 1};
        Arrays.sort(v5);
        for (int i = 0; i < v5.length; i++) {
            System.out.println(v5[i]);
        }
        JOptionPane.showMessageDialog(null, Arrays.binarySearch(v5, 6));

    }
}
