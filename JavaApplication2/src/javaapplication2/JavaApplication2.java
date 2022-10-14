/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import Conexion.Conectar;
import java.sql.SQLException;

/**
 *
 * @author Ronald-Pc
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        Conectar conectar = new Conectar("etzjaim", "etzjaim", "12345");

    }

}
