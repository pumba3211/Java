/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion_PostgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nestor
 */
public class Conexion_PG {

    //Se crea la variable conexion con la base de datos
    private Connection conn;

    //se crea la conexión con la base de datos
    public Conexion_PG(String pNombreDB, String pUser, String pPassword) throws ClassNotFoundException {
        try {
            String driver = "org.postgresql.Driver"; // se asigna el driver de conexion con base de datos
            Class.forName(driver);
            String connString = "jdbc:postgresql://localhost:5432/" + pNombreDB; //String de conexión
            String user = pUser; //Usuario de postgress
            String password = pPassword; //contraseña de usuario de postgress

            this.conn = DriverManager.getConnection(connString, user, password); //Se realiza la conexión
            System.out.print("Conexión realizada con éxito");


        } catch (SQLException e) {
            System.out.print(e.toString());
        }
    }

    //Se crea el método select
    public ResultSet select(String pCampos, String pTabla, String pCondicion) {

        ResultSet rs = null;//obtener los datos del select
        Statement s = null;//se utiliza para inicializar la conexión
        String sentencia = "";

        try {
            s = this.conn.createStatement(); // se inicializa la conexión
            sentencia = "select " + pCampos + " from " + pTabla;// se crea el select
            rs = s.executeQuery(sentencia);//se ejecuta y se obtienen los datos
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return (rs);
    }

    //Se crea el método insertar
    public String insertar(String pTabla, String pValores) {
        Statement s = null;
        String sentencia = "";
        String retorno = "Datos Insertados";

        try {
            s = this.conn.createStatement();
            sentencia = "insert into " + pTabla + " values " + pValores;
            s.executeQuery(sentencia);
        } catch (SQLException e) {
            System.err.println(e.toString());
            retorno = e.toString();
        }
        return (retorno);
    }

    //Se crea el método modificar
    public String modificar(String pTabla, String pValores) {
        String retorno = "Datos modificados";
        Statement s = null;
        String setencia = "";

        try {
            s = this.conn.createStatement();
            setencia = "update " + pTabla + " " + pValores;
            s.executeQuery(setencia);
        } catch (SQLException e) {
            retorno = e.toString();
        }
        return retorno;
    }
    
     //Se crea el método eliminar
    public String Eliminar(String pTabla, String pValores)
    {
        String sentencia = "";
        String retorno = "Datos modificados";
        Statement s = null;
        
        try
        {
            s = this.conn.createStatement();
            sentencia = " delete from " + pTabla + " " + pValores; //Se crea el sql
            s.executeQuery(sentencia);//Se ejecuta el sql
        }
        catch (Exception e)
        {
            retorno = e.toString();
        }
        return retorno;
    }
}
