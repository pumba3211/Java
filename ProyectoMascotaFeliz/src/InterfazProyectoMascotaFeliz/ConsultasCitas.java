/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazProyectoMascotaFeliz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import proyectomascotafeliz.ProcesosCitas;
import proyectomascotafeliz.archivo;

/**
 *
 * @author Ronald
 */
public class ConsultasCitas extends javax.swing.JFrame {

    private archivo archivo = new archivo();
    private DefaultTableModel datoscitas;
    ProcesosCitas conexioncitas;

    /**
     * Creates new form ConsultasCitas
     */
    public ConsultasCitas() {
        archivo.leer();
        datoscitas = new DefaultTableModel();
        try {
            this.conexioncitas = new ProcesosCitas(archivo.getBase(), archivo.getUser(), archivo.getPassword());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Especie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Especie.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        carrgarCitas();

    }

    public void carrgarCitas() {
        datoscitas.addColumn("Cod");
        datoscitas.addColumn("Fecha");
        datoscitas.addColumn("Estado");
        datoscitas.addColumn("Mascota");
        datoscitas.addColumn("Nacimiento");
        datoscitas.addColumn("Codigo");
        datoscitas.addColumn("Raza");
        datoscitas.addColumn("Cod Raza");
        datoscitas.addColumn("Cod Especie");
        datoscitas.addColumn("Especie");
        datoscitas.addColumn("Cedula");
        datoscitas.addColumn("Propietario");
        datoscitas.addColumn("Telefono");
        datoscitas.addColumn("Direccion");
        ResultSet datos = conexioncitas.select5();
        try {
            while (datos.next()) {
                String[] valores = {datos.getString("cod"), datos.getString("fecha_cita"), datos.getString("estado"),
                    datos.getString("nombre_mascota"), datos.getString("fecha_nacimiento"), datos.getString("cod_mascota"),
                    datos.getString("cod_raza"), datos.getString("nombre_raza"), datos.getString("cod_especie"), datos.getString("nombre_especie"), datos.getString("cedula"), (datos.getString("nombre") + " " + datos.getString("apellido1") + " " + datos.getString("apellido2")), datos.getString("telefono"), datos.getString("direccion")};
                datoscitas.addRow(valores);
            }

        } catch (Exception e) {

            System.out.println("Error: " + e.toString());
        }
        tablacitas.setModel(datoscitas);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablacitas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablacitas.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tablacitas.setSelectionForeground(new java.awt.Color(102, 102, 102));
        tablacitas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablacitas);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1230, 290));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/reortesCitas.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/reortesCitas2.png"))); // NOI18N
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 100));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Cerrar.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Cerrar2.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 410, 150, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/fondo-madera-negro.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, -6, 1240, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultasCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultasCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultasCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultasCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultasCitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablacitas;
    // End of variables declaration//GEN-END:variables
}
