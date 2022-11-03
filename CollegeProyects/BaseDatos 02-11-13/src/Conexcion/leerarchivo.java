/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexcion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author estudiante2
 */
public class leerarchivo {

    private String password = "";
    private String user = "";
    private String ip = "";
    private String base = "";
    private String port = "";

    public leerarchivo() {

    }

    public String antesigual(String dato) {
        int cont = 0;
        String resultado = "";
        while (dato.charAt(cont) != '=') {
            cont++;
        }
        for (int i = cont + 1; i < dato.length(); i++) {
            resultado = resultado + dato.charAt(i);
        }
        return resultado;
    }

    public void leer() {
        FileReader fr = null;
        try {
            fr = new FileReader(obtenerdireccionProyecto() + "\\" + "ini.ini");
            BufferedReader entrada = new BufferedReader(fr);
            password = entrada.readLine();
            password = antesigual(password);
            user = entrada.readLine();
            user = antesigual(user);
            ip = entrada.readLine();
            ip = antesigual(ip);
            base = entrada.readLine();
            base = antesigual(base);
            port = entrada.readLine();
            port = antesigual(port);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String obtenerdireccionProyecto() {
        File miDir = new File(".");
        String direccion = "";
        try {
            direccion = miDir.getCanonicalPath();
            System.out.println(direccion);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return direccion;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

}
