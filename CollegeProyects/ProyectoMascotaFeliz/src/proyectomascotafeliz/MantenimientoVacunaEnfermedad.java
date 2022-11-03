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
public class MantenimientoVacunaEnfermedad {

    private archivo archivo = new archivo();
    private Connection conn;//Conexion
    //Metodo constructor

    public MantenimientoVacunaEnfermedad(String pBD, String pUser, String pPass) throws ClassNotFoundException, SQLException {
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

    //Metodo que retorna todas las vacunas e enfermedades
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

    //Metodo que retorna las vacunas mas sus datos e enfermedades mas sus datos
    public ResultSet select2() {
        ResultSet rs = null;
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "select a.cod_enfermedad,b.nombre_enfermedad,a.cod_vacuna,c.nombre_vacuna,a.porc_efectividad,a.notas from"
                    + "\"schProyecto\".enfermedad_vacuna a,\"schProyecto\".enfermedad b,\"schProyecto\".vacuna c"
                    + " where a.cod_enfermedad=b.cod_enfermedad AND a.cod_vacuna=c.cod_vacuna;";
            rs = s.executeQuery(setencia);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return rs;
    }

    //Metodo que inserta
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

    //Metodo que elimina una asociacion de vacuna enfermedad
    public String eliminar(String pTabla, String pValorCodigo, String pValorCodigo2) {
        String retorno = "Datos eliminados";
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "delete from " + pTabla + " where cod_enfermedad='" + pValorCodigo + "'" + "and cod_vacuna='" + pValorCodigo2 + "'";
            s.executeQuery(setencia);
        } catch (SQLException e) {
            retorno = e.toString();
        }
        return retorno;
    }
//Metodo que modifica una asociacion de vacuna enfermedad

    public String Modificar(String pTabla, String Cod_enfermedad, String Cod_vacuna, String porcentajeEfectividad, String notas, String codigo1, String codigo2) {
        String retorno = "Datos modificados";
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "update " + pTabla + " set cod_enfermedad='" + Cod_enfermedad + "' ,cod_vacuna='" + Cod_vacuna
                    + "' ,porc_efectividad='" + porcentajeEfectividad + "' ,notas='" + notas
                    + "' where cod_enfermedad='" + codigo1 + "' and cod_vacuna='" + codigo2 + "'";
            s.executeQuery(setencia);
        } catch (SQLException e) {
            retorno = e.toString();
        }

        return retorno;

    }

}
