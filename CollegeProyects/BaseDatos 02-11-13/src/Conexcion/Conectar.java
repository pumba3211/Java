/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
    leerarchivo archivo = new leerarchivo();

    public Conectar(String pBD, String pUser, String pPass) throws ClassNotFoundException, SQLException {

        try {
            archivo.leer();
            String driver = "org.postgresql.Driver";
            Class.forName(driver);
//            String connecString = "jdbc:postgresql://192.168.2.105:5432/" + pBD;
            String connecString = "jdbc:postgresql://" + archivo.getIp() + ":" + archivo.getPort() + "/" + pBD;
            String user = pUser;
            String password = pPass;
            this.conn = DriverManager.getConnection(connecString, user, password);
            System.out.println("Conexcion realizada con exito");

        } catch (SQLException e) {

            System.out.println("Error al conectarse: " + e.toString());

        }
    }

    public ResultSet select(String pCampos, String pTabla, String pCondicion) {

        ResultSet rs = null;

        Statement s = null;

        String setencia = "";

        try {

            s = this.conn.createStatement();
            setencia = "select " + pCampos + " from " + pTabla + " " + pCondicion;
            rs = s.executeQuery(setencia);

        } catch (Exception e) {

            System.out.println("Error: " + e.toString());
        }

        return rs;

    }

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

    public String ModificarProductos(String pTabla, String pValorCodigo, String pValorDescripcion, String pValorExistencia, String pValorPrecio) {

        String retorno = "Datos modificados";
        Statement s = null;
        String setencia = "";

        try {

            s = this.conn.createStatement();
            setencia = "update " + pTabla + " set descripcion='" + pValorDescripcion + "'"
                    + ",existencia='" + pValorExistencia + "',precio='" + pValorPrecio + "' where codigo='" + pValorCodigo + "'";
            s.executeQuery(setencia);

        } catch (SQLException e) {

            retorno = e.toString();

        }

        return retorno;

    }

    public String ModificarClientes(String pTabla, String pValorCodigo, String pValorDescripcion, String pValorTope, String pValorDescuento, String pValorDireccion) {

        String retorno = "Datos modificados";
        Statement s = null;
        String setencia = "";

        try {

            s = this.conn.createStatement();
            setencia = "update " + pTabla + " set descripcion='" + pValorDescripcion + "'"
                    + ",tope='" + pValorTope + "',descuento='" + pValorDescuento
                    + "' ,direccion='" + pValorDireccion + "' where codigo='" + pValorCodigo + "'";
            s.executeQuery(setencia);

        } catch (SQLException e) {

            retorno = e.toString();

        }

        return retorno;

    }

    public String eliminar(String pTabla, String pValorCodigo) {

        String retorno = "Datos eliminados";
        Statement s = null;
        String setencia = "";

        try {

            s = this.conn.createStatement();
            setencia = "delete from " + pTabla + " where codigo='" + pValorCodigo + "'";
            s.executeQuery(setencia);

        } catch (SQLException e) {

            retorno = e.toString();

        }

        return retorno;

    }
}
