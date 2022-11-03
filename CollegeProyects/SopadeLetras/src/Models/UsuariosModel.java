/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Views.Conexion;
import Estructuras.Usuario;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ronald-Pc
 */
public class UsuariosModel {

    public ArrayList<Usuario> getUsers() {
        ArrayList<Usuario> users = new ArrayList<Usuario>();
        ResultSet rs = null;
        Statement s = null;
        String setencia = "";
        try {
            s = Views.Conexion.getInstance().Conection.createStatement();
            setencia = "select" + " * " + " from " + " usuario ";
            rs = s.executeQuery(setencia);
            while (rs.next()) {
                Usuario user = new Usuario(Integer.parseInt(rs.getString("id")),
                         rs.getString("nombre"), rs.getString("clave"));
                users.add(user);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return users;
    }

    public boolean Login(String Username, String Password) {
        boolean ok = false;
        ArrayList<Usuario> users = getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).name.equals(Username) && users.get(i).Password.equals(Password)) {
                ok = true;
            }
        }
        return ok;
    }
}
