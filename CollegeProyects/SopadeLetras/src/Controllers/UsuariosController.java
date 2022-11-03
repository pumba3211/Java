/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.UsuariosModel;

/**
 *
 * @author Ronald-Pc
 */
public class UsuariosController {

    public boolean Login(String Username, String Password) {
        boolean ok = false;
        UsuariosModel user = new UsuariosModel();
        ok = user.Login(Username, Password);
        return ok;
    }
}
