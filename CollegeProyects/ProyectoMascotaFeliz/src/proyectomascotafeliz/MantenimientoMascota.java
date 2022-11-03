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
import javax.swing.JOptionPane;

/**
 *
 * @author Ronald
 */
public class MantenimientoMascota {

    private archivo archivo = new archivo();
    private Connection conn;//Conexion
    //Metodo constructor

    public MantenimientoMascota(String pBD, String pUser, String pPass) throws ClassNotFoundException, SQLException {
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

    //Metodo que duevuelve todas las mascotas
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

    //Metoo que sirve para cargar informacion relacionada con la mascota
    public ResultSet select2() {
        String resultadoloco = "";
        ResultSet rs = null;
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "select a.nombre_mascota, a.fecha_nacimiento, a.cod_raza, b.nombre_raza, a.cedula, c.nombre, a.cod_mascota from"
                    + "\"schProyecto\".mascota a, \"schProyecto\".raza b, \"schProyecto\".dueno c"
                    + " where a.cod_raza = b.cod_raza AND  a.cedula = c.cedula";

            rs = s.executeQuery(setencia);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return rs;
    }

    //Metodo que inserta una nueva mascota
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

    //Metodo que elimina una mascota
    public String eliminar(String pTabla, String pValorCodigo) {
        String retorno = "Datos eliminados";
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "delete from " + pTabla + " where cod_mascota='" + pValorCodigo + "'";
            s.executeQuery(setencia);
        } catch (SQLException e) {
            retorno = e.toString();
        }
        return retorno;
    }

    //Metodo que modifica los atributos de la una mascota seleccionada
    public String Modificar(String pTabla, String pcodigoMascota, String Nombre, String FechaNacimiento, String CodigoRaza, String Cedula, String codigo) {

        String retorno = "Datos modificados";
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "update " + pTabla + " set cod_mascota='" + pcodigoMascota + "',nombre_mascota='" + Nombre + "' ,fecha_nacimiento='" + FechaNacimiento
                    + "' ,cod_raza='" + CodigoRaza + "' ,cedula='" + Cedula + "' where cod_mascota='" + codigo + "'";
            s.executeQuery(setencia);
        } catch (SQLException e) {
            retorno = e.toString();
        }

        return retorno;

    }
}
