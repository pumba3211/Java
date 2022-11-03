/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobanco;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import proyectobanco.*;
import java.applet.AudioClip;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author D
 */
public class Principal extends javax.swing.JFrame {
    //Cada una de los variables guardan la informacion de la simulacion, para cada cajero hay una.

    private lista listadatos;
    private cjero cajero1;
    private cjero cajero2;
    private cjero cajero3;
    private cjero cajero4;

    /**
     * Creates new form principal
     */
    //Metodo constructor
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        anteriordatows = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Comenzar Simulacion nueva");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        anteriordatows.setText("Ver Datos Anterior Simulacion");
        anteriordatows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriordatowsActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(anteriordatows, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(anteriordatows)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Al momento de precionar el boton comenzar a la simulacion se crea una ventana donde se ejecutan los datos
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        try {
//            FileInputStream fis;
//            Player player;
//            fis = new FileInputStream("C:\\Users\\Ronald\\Documents\\NetBeansProjects\\Proyectobanco\\World of Warcraft The Burning Crusade - Complete Soundtrack.mp3");
//            BufferedInputStream bis = new BufferedInputStream(fis);
//
//            player = new Player(bis);
//            player.play();
//        } catch (JavaLayerException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        Segunda ventanaSecundaria = new Segunda();
        ventanaSecundaria.pack();
        ventanaSecundaria.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed
    //Al momento de presionar el boton salir la ventana se cierrra
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            FileInputStream fis;
            Player player;
            fis = new FileInputStream("C:\\Users\\Ronald\\Documents\\NetBeansProjects\\Proyectobanco\\Close Windows Xp_22.mp3");
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed
    //Se crea una ventan tipo Tercera la cual mostrara los datos , y  a su vez le envia dichos datos
    private void anteriordatowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriordatowsActionPerformed
        Tercera ventanaSecundaria = new Tercera();
        ventanaSecundaria.pack();
        ventanaSecundaria.setCajero1(cajero1);
        ventanaSecundaria.setCajero2(cajero2);
        ventanaSecundaria.setCajero3(cajero3);
        ventanaSecundaria.setCajero4(cajero4);
        ventanaSecundaria.setListaclientes(listadatos);
        ventanaSecundaria.setVisible(true);

    }//GEN-LAST:event_anteriordatowsActionPerformed

    public JButton getAnteriordatows() {
        return anteriordatows;
    }

    public void setAnteriordatows(JButton anteriordatows) {
        this.anteriordatows = anteriordatows;
    }

    public lista getListadatos() {
        return listadatos;
    }

    public void setListadatos(lista listadatos) {
        this.listadatos = listadatos;
    }

    public cjero getCajero1() {
        return cajero1;
    }

    public void setCajero1(cjero cajero1) {
        this.cajero1 = cajero1;
    }

    public cjero getCajero2() {
        return cajero2;
    }

    public void setCajero2(cjero cajero2) {
        this.cajero2 = cajero2;
    }

    public cjero getCajero3() {
        return cajero3;
    }

    public void setCajero3(cjero cajero3) {
        this.cajero3 = cajero3;
    }

    public cjero getCajero4() {
        return cajero4;
    }

    public void setCajero4(cjero cajero4) {
        this.cajero4 = cajero4;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anteriordatows;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}