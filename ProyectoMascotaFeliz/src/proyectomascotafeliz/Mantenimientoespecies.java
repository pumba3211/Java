/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomascotafeliz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ronald
 */
public class Mantenimientoespecies {

    private archivo archivo = new archivo();
    private Connection conn;

    //Metodo constructor
    public Mantenimientoespecies(String pBD, String pUser, String pPass) throws ClassNotFoundException, SQLException {
        try {
            archivo.leer();
            String driver = "org.postgresql.Driver";
            Class.forName(driver);
            String connecString = "jdbc:postgresql://" + archivo.getIp() + ":" + archivo.getPort() + "/" + pBD;
            String user = pUser;
            String password = pPass;
            this.conn = DriverManager.getConnection(connecString, user, password);
            System.out.println("Conexcion realizada con exito");

        } catch (SQLException e) {

            System.out.println("Error al conectarse: " + e.toString());

        }
    }

    //Carga desde la base de datos las especies insertadas
    public ResultSet select(String pCampos, String pTabla, String pCondicion) {
        ResultSet rs = null;
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "select" + pCampos + "from" + pTabla;
            rs = s.executeQuery(setencia);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return rs;
    }

    public ResultSet selectNombreEspecie(String pTabla, String pCondicion) {
        ResultSet rs = null;
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "select" + " descripcion " + " from " + pTabla + " where cod_especie='" + pCondicion + "'";
            rs = s.executeQuery(setencia);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return rs;
    }

    //Inserta una nueva especie
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

    //Se elimina una especie seleccionada
    public String eliminar(String pTabla, String pValorCodigo) {
        String retorno = "Datos eliminados";
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "delete from " + pTabla + " where cod_especie='" + pValorCodigo + "'";
            s.executeQuery(setencia);
        } catch (SQLException e) {
            retorno = e.toString();
        }
        return retorno;
    }

    //Se modifica una especie seleccionada 
    public String Modificar(String pTabla, String Cod_especie, String descripcion, String codigo) {
        String retorno = "Datos modificados";
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "update " + pTabla + " set cod_especie='" + Cod_especie + "' ,nombre_especie='" + descripcion
                    + "' where cod_especie='" + codigo + "'";
            s.executeQuery(setencia);
        } catch (SQLException e) {
            retorno = e.toString();
        }

        return retorno;

    }
}
