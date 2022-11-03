/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Ronald-Pc
 */
public class Usuario {

    public int id;

    public String name;

    public String Password;

    public Usuario(int id, String name, String Password) {
        this.id = id;
        this.name = name;
        this.Password = Password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return Password;
    }

}
