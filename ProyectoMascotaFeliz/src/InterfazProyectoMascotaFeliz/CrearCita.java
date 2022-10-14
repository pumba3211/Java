/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazProyectoMascotaFeliz;

import datos.RazaDatos;
import java.sql.SQLException;
import java.util.ArrayList;
import datos.horas;
import datos.minutos;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectomascotafeliz.MantenimientoMascota;
import datos.MascotaDatos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectomascotafeliz.ProcesosCitas;
import proyectomascotafeliz.archivo;
import proyectomascotafeliz.mantenimientoVacunas;

/**
 *
 * @author Ronald
 */
public class CrearCita extends javax.swing.JFrame {

    private archivo archivo = new archivo();
    MantenimientoMascota conexionMascota;
    ProcesosCitas conexionCitas;
    private DefaultTableModel citas;
    private String codigoguardar;

    /**
     * Creates new form CrearCita
     */
    public CrearCita() {
        archivo.leer();
        try {
            this.conexionMascota = new MantenimientoMascota(archivo.getBase(), archivo.getUser(), archivo.getPassword());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Especie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Especie.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.conexionCitas = new ProcesosCitas(archivo.getBase(), archivo.getUser(), archivo.getPassword());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Especie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Especie.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        try {
            llenarComboBoxMascotas();
        } catch (SQLException ex) {
            Logger.getLogger(Razas.class.getName()).log(Level.SEVERE, null, ex);
        }
        cargarCitas();
        llenarComboBoxes();

    }

    public void cargarCitas() {
        citas = new DefaultTableModel();
        citas.addColumn("Codigo Cita");
        citas.addColumn("Mascota");
        citas.addColumn("Nombre Mascota");
        citas.addColumn("Fecha de cita");
        citas.addColumn("Estado");
        ResultSet datos = conexionCitas.select2();
        try {

            while (datos.next()) {
                String[] valores = {datos.getString("cod"), datos.getString("cod_mascota"), datos.getString("nombre_mascota"), datos.getString("fecha_cita"), datos.getString("estado")};
                citas.addRow(valores);

            }
            tablaCitas.setModel(citas);

        } catch (Exception e) {

            System.out.println("Error: " + e.toString());
        }
    }

    public ArrayList<MascotaDatos> mascotaDatos() throws SQLException {
        ResultSet datos = conexionMascota.select("*", "\"schProyecto\".\"mascota\"", "");
        ArrayList<MascotaDatos> mascotas = new ArrayList();
        while (datos.next()) {
            MascotaDatos mascota = new MascotaDatos(datos.getString("nombre_mascota"), datos.getString("fecha_nacimiento"), datos.getString("cod_raza"),
                    datos.getString("cedula"), datos.getString("cod_mascota"));
            mascotas.add(mascota);
        }
        return mascotas;
    }

    public void llenarComboBoxMascotas() throws SQLException {
        try {
            for (int x = 0; x < mascotaDatos().size(); x++) {
                comBOXMascotas.addItem(mascotaDatos().get(x).getCod_mascota() + " " + mascotaDatos().get(x).getNombre());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Razas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<horas> horas() {
        ArrayList<horas> horas = new ArrayList();
        for (int i = 8; i <= 17; i++) {
            if (i < 10) {
                horas hora = new horas("0" + i);
                horas.add(hora);
            } else {
                horas hora = new horas("" + i);
                horas.add(hora);
            }

        }
        return horas;
    }

    public ArrayList<minutos> minutos() {
        ArrayList<minutos> minutos = new ArrayList();
        for (int i = 0; i < 60; i++) {
            if (i < 10) {
                minutos minuto = new minutos("0" + i);
                minutos.add(minuto);
            } else {
                minutos minuto = new minutos("" + i);
                minutos.add(minuto);
            }

        }
        return minutos;
    }

    public void llenarComboBoxes() {
        for (int i = 0; i < horas().size(); i++) {
            comboBoxHORAS.addItem(horas().get(i).getHora());
        }
        for (int i = 0; i < minutos().size(); i++) {
            comboBoxminutos.addItem(minutos().get(i).getMinuto());
        }
    }

    public boolean compararFechas(String fechacomparar) throws SQLException {
        boolean esta = false;
        ResultSet datos = conexionMascota.select("*", "\"schProyecto\".\"cita\"", "");
        while (datos.next()) {
            if (datos.getString("fecha_cita").equals(fechacomparar)) {
                esta = true;
                break;
            }
        }
        return (esta);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comBOXMascotas = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        codigocita = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCitas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        calendario = new datechooser.beans.DateChooserCombo();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxHORAS = new javax.swing.JComboBox();
        comboBoxminutos = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ESTADO = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comBOXMascotas.setBackground(new java.awt.Color(240, 240, 240));
        comBOXMascotas.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(comBOXMascotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 119, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Codigo Cita");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        codigocita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigocitaActionPerformed(evt);
            }
        });
        getContentPane().add(codigocita, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 120, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Codigo Mascota");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        tablaCitas.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tablaCitas.setSelectionForeground(new java.awt.Color(102, 102, 102));
        tablaCitas.getTableHeader().setReorderingAllowed(false);
        tablaCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCitasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCitas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 233, 713, 250));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/CrearCitaboton.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/CrearCitaboton2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, 140, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Eliminar.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Eliminar2.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 299, 140, 50));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/ModificarCita.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/ModificarCita2.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 360, 140, -1));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 206, -1, -1));

        calendario.setCalendarPreferredSize(new java.awt.Dimension(323, 215));
        getContentPane().add(calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 306, 35));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Hora:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Minuto:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, -1, -1));

        comboBoxHORAS.setBackground(new java.awt.Color(240, 240, 240));
        comboBoxHORAS.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(comboBoxHORAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 50, -1));

        comboBoxminutos.setBackground(new java.awt.Color(240, 240, 240));
        comboBoxminutos.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(comboBoxminutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 50, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/CrearCita.png"))); // NOI18N
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/CrearCita2.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 100));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Fecha");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Modificar estado:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));
        getContentPane().add(ESTADO, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, 100, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Cerrar.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Cerrar2.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, 140, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/fondo-madera-negro.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 870, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String fecha = DividirFecha(calendario.getText());
        String hora = horas().get(comboBoxHORAS.getSelectedIndex()).getHora() + ":"
                + minutos().get(comboBoxminutos.getSelectedIndex()).getMinuto() + ":00";
        String fechatotal = fecha + " " + hora;
        boolean comparacion = false;
        try {
            comparacion = compararFechas(fechatotal);
        } catch (SQLException ex) {
            Logger.getLogger(CrearCita.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (comparacion == true) {
            JOptionPane.showMessageDialog(this, "Esa fecha y hora ya han sido asignadas a una cita");
        } else {
            String datos;
            String estado;
            try {
                datos = "('" + codigocita.getText() + "','" + mascotaDatos().get(comBOXMascotas.getSelectedIndex()).getCod_mascota() + "','" + fechatotal + "','" + "Pendiente" + "')";
                estado = conexionCitas.Insertar("\"schProyecto\".\"cita\"", datos);
            } catch (SQLException ex) {
                Logger.getLogger(CrearCita.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Datos insertado con exito");
        }

        cargarCitas();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String estado;

        estado = this.conexionCitas.eliminar("\"schProyecto\".\"cita\"", String.valueOf(tablaCitas.getValueAt(tablaCitas.getSelectedRow(), 0)));
        cargarCitas();
        JOptionPane.showMessageDialog(null, "Datos eliminados");
        codigocita.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        String datos;
        String fecha = DividirFecha(calendario.getText());
        String hora = horas().get(comboBoxHORAS.getSelectedIndex()).getHora() + ":"
                + minutos().get(comboBoxminutos.getSelectedIndex()).getMinuto() + ":00";
        String fechatotal = fecha + " " + hora;
        String estado;
        try {
            estado = conexionCitas.Modificar("\"schProyecto\".\"cita\"", codigocita.getText(), mascotaDatos().get(comBOXMascotas.getSelectedIndex()).getCod_mascota(), fechatotal, ESTADO.getText(), codigoguardar);
            JOptionPane.showMessageDialog(null, "Datos insertado con exito");
            cargarCitas();
        } catch (SQLException ex) {
            Logger.getLogger(Razas.class.getName()).log(Level.SEVERE, null, ex);
        }
        codigocita.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tablaCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCitasMouseClicked
        // TODO add your handling code here:
        codigoguardar = (String) tablaCitas.getValueAt(tablaCitas.getSelectedRow(), 0);
        codigocita.setText((String) tablaCitas.getValueAt(tablaCitas.getSelectedRow(), 0));
        ESTADO.setText((String) tablaCitas.getValueAt(tablaCitas.getSelectedRow(), 4));
    }//GEN-LAST:event_tablaCitasMouseClicked

    private void codigocitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigocitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigocitaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed
    public String DividirFecha(String pdato) {
        int cont = 0;
        String resultado1 = "";
        String resultado2 = "";
        String resultado3 = "";
        String resultado = "";
        while (pdato.charAt(cont) != '/') {
            resultado1 = resultado1 + pdato.charAt(cont);
            cont++;
        }
        if (Integer.parseInt(resultado1) < 10) {
            resultado1 = "0" + resultado1;
        }
        cont++;
        while (pdato.charAt(cont) != '/') {
            resultado2 = resultado2 + pdato.charAt(cont);
            cont++;
        }

        cont++;
        while (cont < pdato.length()) {
            resultado3 = resultado3 + pdato.charAt(cont);
            cont++;
        }
        if (Integer.parseInt(resultado2) < 100) {
            resultado3 = "20" + resultado3;
        }
        resultado = resultado3 + "-" + resultado2 + "-" + resultado1;
        return resultado;
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
            java.util.logging.Logger.getLogger(CrearCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearCita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ESTADO;
    private datechooser.beans.DateChooserCombo calendario;
    private javax.swing.JTextField codigocita;
    private javax.swing.JComboBox comBOXMascotas;
    private javax.swing.JComboBox comboBoxHORAS;
    private javax.swing.JComboBox comboBoxminutos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCitas;
    // End of variables declaration//GEN-END:variables
}
