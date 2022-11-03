/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author UTN
 */
public class conectar {

    private Connection conn;

    public conectar(String pBD, String pUser, String pPass) throws ClassNotFoundException, SQLException {
        try {

            String driver = "org.postgresql.Driver";
            Class.forName(driver);
            String connecString = "jdbc:postgresql://localhost:5432/" + pBD;
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
            setencia = "select" + pCampos + "from" + pTabla;
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

    public String eliminar(String pTabla, String pValorCodigo) {

        String retorno = "Datos eliminados";
        Statement s = null;
        String setencia = "";

        try {

            s = this.conn.createStatement();
            setencia = "delete from " + pTabla + " where canton='" + pValorCodigo + "'";
            s.executeQuery(setencia);

        } catch (SQLException e) {

            retorno = e.toString();

        }

        return retorno;

    }

    public String Modificar(String pTabla, String pCanton, String pDescripcion, String pProvincia, String pcodigocanton) {

        String retorno = "Datos modificados";
        Statement s = null;
        String setencia = "";

        try {
            s = this.conn.createStatement();
            setencia = "update " + pTabla + " set descripcion='" + pDescripcion + "' ,provincia='" + pProvincia
                    + "' ,canton='" + pCanton + "' where canton='" + pcodigocanton + "'";

            s.executeQuery(setencia);

        } catch (SQLException e) {

            retorno = e.toString();

        }

        return retorno;

    }

    public String eliminarProvincia(String pTabla, String pValorCodigo) {

        String retorno = "Datos eliminados";
        Statement s = null;
        String setencia = "";

        try {

            s = this.conn.createStatement();
            setencia = "delete from " + pTabla + " where provincia='" + pValorCodigo + "'";
            s.executeQuery(setencia);

        } catch (SQLException e) {

            retorno = e.toString();

        }

        return retorno;

    }

    public String ModificarProvincia(String pTabla, String pProvincia, String pDescripcion, String pcodigoProvincia) {

        String retorno = "Datos modificados";
        Statement s = null;
        String setencia = "";

        try {
            s = this.conn.createStatement();
            setencia = "update " + pTabla + " set provincia='" + pProvincia + "' ,descripcion='" + pDescripcion
                    + "' where provincia='" + pcodigoProvincia + "'";

            s.executeQuery(setencia);

        } catch (SQLException e) {

            retorno = e.toString();

        }

        return retorno;
    }
}
