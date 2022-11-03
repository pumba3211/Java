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
public class MantemimientoRazas {

    private archivo archivo = new archivo();
    private Connection conn;//Variable conexion sirve para conectarse a postgress
    //Metodo constructor de la clase 

    public MantemimientoRazas(String pBD, String pUser, String pPass) throws ClassNotFoundException, SQLException {
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

    //Metodo select de la clase 
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

    //Metodo que recoje los datos de la tabla raza e especie 
    public ResultSet select2() {
        ResultSet rs = null;
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();

            setencia = "select b.cod_raza,b.nombre_raza,b.cod_especie,a.nombre_especie from "
                    + "\"schProyecto\".especie a,\"schProyecto\".raza b"
                    + " where a.cod_especie=b.cod_especie";
            rs = s.executeQuery(setencia);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return rs;
    }

    //Metodo que inserta en la tabla raza
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

    //Metodo que elimina de la tabla raza
    public String eliminar(String pTabla, String pValorCodigo) {
        String retorno = "Datos eliminados";
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "delete from " + pTabla + " where cod_raza='" + pValorCodigo + "'";
            s.executeQuery(setencia);
        } catch (SQLException e) {
            retorno = e.toString();
        }
        return retorno;
    }

    //Metodo que modifica de la tabla raza
    public String Modificar(String pTabla, String Cod_raza, String cod_especie, String descripcion, String codigo) {
        String retorno = "Datos modificados";
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "update " + pTabla + " set cod_raza='" + Cod_raza + "',cod_especie='" + cod_especie + "' ,nombre_raza='" + descripcion
                    + "' where cod_raza='" + codigo + "'";
            s.executeQuery(setencia);
        } catch (SQLException e) {
            retorno = e.toString();
        }

        return retorno;

    }
}
