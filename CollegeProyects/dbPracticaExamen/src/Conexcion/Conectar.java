/*
 * To change this template, choose Tools | Templates * and open the template in the editor.
 */
package Conexcion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ACER
 */
public class Conectar {

    private Connection conn;

    //CONSTRUCTOR
    public Conectar(String pBD, String pUser, String pPass) throws ClassNotFoundException, SQLException {

        try {

            //DRIVER DE CONEXCION , USUARIO, PASS
            String driver = "org.postgresql.Driver";
            Class.forName(driver);
            String connecString = "jdbc:postgresql://192.168.2.99:5432/" + pBD;
            String user = pUser;
            String password = pPass;
            this.conn = DriverManager.getConnection(connecString, user, password);
            System.out.println("Conexcion realizada con exito");

        } catch (SQLException e) {

            System.out.println("Error al conectarse: " + e.toString());

        }
    }

    //SELECT DE LA BD PARA CONSULTAS
    public ResultSet select(String pCampos, String pTabla, String pCondicion) {

        ResultSet rs = null;

        Statement s = null;

        String setencia = "";

        try {

            s = this.conn.createStatement();
            setencia = "select " + pCampos + " from " + pTabla + pCondicion;
            rs = s.executeQuery(setencia);

        } catch (Exception e) {

            System.out.println("Error: " + e.toString());
        }

        return rs;

    }

    //INSERTA DATOS EN LA BD
    public String Insertar(String pTabla, String pValores) {

        String retorno = "Datos insertardos";
        Statement s = null;
        String setencia = "";

        try {

            s = this.conn.createStatement();
            setencia = "insert into " + pTabla + " values " + pValores;

            s.executeQuery(setencia);

        } catch (SQLException e) {

            retorno = e.toString();

        }

        return retorno;
    }

    //MODIFICAR LAS PROVINCIAS
    public String ModificarProvincias(String pTabla, String pValorCodigo, String pValorDescripcion) {

        String retorno = "Datos modificados";
        Statement s = null;
        String setencia = "";

        try {

            s = this.conn.createStatement();
            setencia = "update " + pTabla + " set descripcion='" + pValorDescripcion + "'"
                    + " where provincia='" + pValorCodigo + "'";
            s.executeQuery(setencia);

        } catch (SQLException e) {

            retorno = e.toString();

        }

        return retorno;

    }

    //MODIFICA LOS CANTONES
    public String Modificar(String pTabla, String pValorModificar, String pCondicion) {

        String retorno = "Datos modificados";
        Statement s = null;
        String setencia = "";

        try {

            s = this.conn.createStatement();
            setencia = "update " + pTabla + " " + pValorModificar + " " + pCondicion;
            s.executeQuery(setencia);

        } catch (SQLException e) {

            retorno = e.toString();

        }

        return retorno;

    }

    //ELIMINAR
    public String eliminar(String pTabla, String pCondicion) {

        String retorno = "Datos eliminados";
        Statement s = null;
        String setencia = "";

        try {

            s = this.conn.createStatement();
            setencia = "delete from " + pTabla + pCondicion;
            s.executeQuery(setencia);

        } catch (SQLException e) {

            retorno = e.toString();

        }

        return retorno;

    }
}
