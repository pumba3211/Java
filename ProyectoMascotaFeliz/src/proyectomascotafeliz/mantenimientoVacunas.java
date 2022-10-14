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
public class mantenimientoVacunas {

    private archivo archivo = new archivo();
    private Connection conn;

    //METODO CONSTRUCTOR
    public mantenimientoVacunas(String pBD, String pUser, String pPass) throws ClassNotFoundException, SQLException {
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

    //CARGAR TODAS LAS VACUNAS INSERTARAS
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

    //SE INSERTA UNA NUEVA VACUNA
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

    //SE ELIMINA UNA VACUNA
    public String eliminar(String pTabla, String pValorCodigo) {
        String retorno = "Datos eliminados";
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "delete from " + pTabla + " where cod_vacuna='" + pValorCodigo + "'";
            s.executeQuery(setencia);
        } catch (SQLException e) {
            retorno = e.toString();
        }
        return retorno;
    }

    //SE MODIFICA UNA VACUNA
    public String Modificar(String pTabla, String Cod_vacuna, String descripcion, String codigo) {
        String retorno = "Datos modificados";
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "update " + pTabla + " set cod_vacuna='" + Cod_vacuna + "' ,nombre_vacuna='" + descripcion
                    + "' where cod_vacuna='" + codigo + "'";
            s.executeQuery(setencia);
        } catch (SQLException e) {
            retorno = e.toString();
        }

        return retorno;

    }
}
