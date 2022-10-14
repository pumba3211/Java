/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ronald-Pc
 */
public class Conectar {

    public Connection Conection;

    public Conectar(String pBD, String pUser, String pPass) throws ClassNotFoundException, SQLException {
        try {
            String driver = "org.postgresql.Driver";
            Class.forName(driver);
            String connecString = "jdbc:postgresql://" + "localhost" + ":" + 5432 + "/" + pBD;
            String user = pUser;
            String password = pPass;
            this.Conection = DriverManager.getConnection(connecString, user, password);
            System.out.println("Conexcion realizada con exito");

        } catch (SQLException e) {
            System.out.println("Error al conectarse: " + e.toString());
        }
    }
}
