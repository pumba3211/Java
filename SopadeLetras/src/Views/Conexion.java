/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.sql.Connection;

/**
 *
 * @author Ronald-Pc
 */
public class Conexion {

    public Connection Conection;

    public boolean isError;

    public String errorDescription;

    private static Conexion INSTANCE = new Conexion();

    // El constructor privado no permite que se genere un constructor por defecto.
    // (con mismo modificador de acceso que la definición de la clase) 
    private Conexion() {
    }

    public static Conexion getInstance() {
        return INSTANCE;
    }
}
