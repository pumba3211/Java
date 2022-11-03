/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textsonido;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Ronald
 */
public class TextSonido {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

    }
    int sonido = (Integer.parseInt(JOptionPane.showInputDialog("")));

    public class Sonido extends Thread {

        public void run(int sound) {
            try {
                FileInputStream fis;
                Player player;
                fis = new FileInputStream(obtenerdireccionProyecto() + "\\" + sonidomp3(sonido) + ".mp3" + "");
                BufferedInputStream bis = new BufferedInputStream(fis);
                player = new Player(bis);
                player.play();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public String sonidomp3(int i) {
        String direccion = "";
        switch (i) {
            case 1:
                direccion = "ZigguratMissileLaunch1"; //Nombre del Sonido
                break;
            case 2:
                direccion = "The Elder Scrolls V Skyrim Main Theme   Real Full Version  HQ";
                break;
            case 3:
                direccion = "";
        }
        return direccion;
    }

    public String obtenerdireccionProyecto() {
        File miDir = new File(".");
        String direccion = "";
        try {
            direccion = miDir.getCanonicalPath();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return direccion;

    }
}
