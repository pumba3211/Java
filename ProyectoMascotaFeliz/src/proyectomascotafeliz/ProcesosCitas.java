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
public class ProcesosCitas {

    private archivo archivo = new archivo();
    private Connection conn;

    //Metodo constructor
    public ProcesosCitas(String pBD, String pUser, String pPass) throws ClassNotFoundException, SQLException {
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

    //Cargar las citas 
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

    //CARGA INFORMACION DE CITAS MAS MASCOTAS
    public ResultSet select2() {
        ResultSet rs = null;
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "select a.cod,a.cod_mascota,b.nombre_mascota,a.fecha_cita,a.estado from "
                    + "\"schProyecto\".cita a,\"schProyecto\".mascota b "
                    + " where a.cod_mascota=b.cod_mascota";
            rs = s.executeQuery(setencia);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return rs;
    }

    //CARGA INFORMACION DE VACUNAS MAS ENFERMEDADES
    public ResultSet select3(String CodigoEnfermedad) {
        ResultSet rs = null;
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "select a.cod_vacuna,b.nombre_vacuna,a.porc_efectividad,a.notas "
                    + "from \"schProyecto\".enfermedad_vacuna a,\"schProyecto\".vacuna b "
                    + " where a.cod_enfermedad='" + CodigoEnfermedad + "'and a.cod_vacuna=b.cod_vacuna";
            String resultado = "";
            rs = s.executeQuery(setencia);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return rs;
    }

    //CARGA LAS CONSULTAS MAS TODA LA INFORAMCION DE LA CONSULTA
    public ResultSet select4(String CodigoConsulta) {
        ResultSet rs = null;
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "select distinct  a.cod_mascota,d.nombre_mascota,a.cod_enfermedad,f.nombre_enfermedad,a.fecha_diagnostico,a.notas,b.cod_vacuna,e.nombre_vacuna,b.fecha_aplicacion,b.fecha_proxima_aplicacion "
                    + " from \"schProyecto\".enfermedad_mascota a,\"schProyecto\".mascota_vacuna b,\"schProyecto\".consulta c,\"schProyecto\".mascota d,\"schProyecto\".vacuna e,\"schProyecto\".enfermedad f "
                    + " where '" + CodigoConsulta + "'=a.cod_consulta and '" + CodigoConsulta + "'=b.cod_consulta and a.cod_mascota=d.cod_mascota and a.cod_enfermedad=f.cod_enfermedad and b.cod_vacuna=e.cod_vacuna";
            String resultado = "";
            rs = s.executeQuery(setencia);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return rs;
    }

    //CARGA LAS CITAS MAS TODO SU INFORMACION ASOSCIADA
    public ResultSet select5() {
        ResultSet rs = null;
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "select a.cod,a.fecha_cita,a.estado,b.nombre_mascota,b.fecha_nacimiento,b.cod_mascota,b.cod_raza,c.nombre_raza,c.cod_especie,d.nombre_especie,e.cedula,e.nombre,e.apellido1,e.apellido2,e.telefono,e.direccion "
                    + "from \"schProyecto\".cita a,\"schProyecto\".mascota b,\"schProyecto\".raza c,\"schProyecto\".especie d,\"schProyecto\".dueno e "
                    + "where a.cod_mascota=b.cod_mascota and b.cod_raza=c.cod_raza and c.cod_especie=d.cod_especie and b.cedula=e.cedula";
            String resultado = "";
            rs = s.executeQuery(setencia);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return rs;
    }

    //INSERTA UNA NUEVA CITA
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

    //ELIMINA UNA CITA
    public String eliminar(String pTabla, String pValorCodigo) {
        String retorno = "Datos eliminados";
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "delete from " + pTabla + " where cod='" + pValorCodigo + "'";
            s.executeQuery(setencia);
        } catch (SQLException e) {
            retorno = e.toString();
        }
        return retorno;
    }

    //MODIFICA UNA CITA
    public String Modificar(String pTabla, String Cod, String cod_mascota, String fecha, String estado, String codigo) {
        String retorno = "Datos modificados";
        Statement s = null;
        String setencia = "";
        try {
            s = this.conn.createStatement();
            setencia = "update " + pTabla + " set cod='" + Cod + "',cod_mascota='" + cod_mascota + "' ,fecha_cita='" + fecha + "', estado='" + estado
                    + "' where cod='" + codigo + "'";
            s.executeQuery(setencia);
        } catch (SQLException e) {
            retorno = e.toString();
        }

        return retorno;

    }
}
