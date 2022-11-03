/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazProyectoMascotaFeliz;

import datos.DatosCitas;
import datos.Datosvacunaenfermedad;
import datos.EnfermedadDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectomascotafeliz.ProcesosCitas;
import proyectomascotafeliz.archivo;

/**
 *
 * @author Ronald
 */
public class CrearConsulta extends javax.swing.JFrame {

    private archivo archivo = new archivo();
    ProcesosCitas conexioncitas;
    private DefaultComboBoxModel combo;
    private DefaultTableModel vacunasaplicadas;
    private int cont = 0;

    /**
     * Creates new form CrearConsulta
     */
    public CrearConsulta() {
        archivo.leer();
        try {
            this.conexioncitas = new ProcesosCitas(archivo.getBase(), archivo.getUser(), archivo.getPassword());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Especie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Especie.class.getName()).log(Level.SEVERE, null, ex);
        }
        vacunasaplicadas = new DefaultTableModel();

        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        try {
            llenarcomboBoxCitas();
        } catch (SQLException ex) {
            Logger.getLogger(CrearConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            llenarComboboxEnfermedades();
        } catch (SQLException ex) {
            Logger.getLogger(CrearConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        vacunasaplicadas.addColumn("Cod Enfermedad");
        vacunasaplicadas.addColumn("Enfermedad");
        vacunasaplicadas.addColumn("Cod Vacuna");
        vacunasaplicadas.addColumn("Vacuna");
        vacunasaplicadas.addColumn("Fecha");
        vacunasaplicadas.addColumn("Fecha Proxima");
        tablavacunasaplicadas.setModel(vacunasaplicadas);

    }

    public ArrayList<DatosCitas> obtenerdatosCitas() throws SQLException {
        ResultSet datos = conexioncitas.select2();
        ArrayList<DatosCitas> citas = new ArrayList();
        while (datos.next()) {
            DatosCitas cita = new DatosCitas(datos.getString("cod"), datos.getString("cod_mascota"), datos.getString("nombre_mascota"), datos.getString("fecha_cita"), datos.getString("estado"));
            citas.add(cita);
        }
        return citas;
    }

    public void llenarcomboBoxCitas() throws SQLException {
        for (int i = 0; i < obtenerdatosCitas().size(); i++) {
            if (String.valueOf(obtenerdatosCitas().get(i).getEstado()).equals("Pendiente")) {
                String datos = obtenerdatosCitas().get(i).getCodigo_Cita() + " "
                        + obtenerdatosCitas().get(i).getCod_mascota() + " "
                        + obtenerdatosCitas().get(i).getMascota() + " "
                        + obtenerdatosCitas().get(i).getFecha_cita();
                ComboBoxCitas.addItem(datos);
            }
        }
    }

    public ArrayList<EnfermedadDatos> obtenerEnfermedades() throws SQLException {
        ResultSet datos = conexioncitas.select("*", "\"schProyecto\".\"enfermedad\"", "");
        ArrayList<EnfermedadDatos> enfermedades = new ArrayList();
        while (datos.next()) {
            EnfermedadDatos enfermedad = new EnfermedadDatos(datos.getString("cod_enfermedad"), datos.getString("nombre_enfermedad"));
            enfermedades.add(enfermedad);
        }
        return enfermedades;
    }

    public ArrayList<Datosvacunaenfermedad> obtenerVacunas() throws SQLException {
        ResultSet datos = conexioncitas.select3(String.valueOf(obtenerEnfermedades().get(comboBoxEnfermedad.getSelectedIndex()).getCodigo_Enfermedad()));
        ArrayList<Datosvacunaenfermedad> vacunas = new ArrayList();
        while (datos.next()) {
            Datosvacunaenfermedad vacuna = new Datosvacunaenfermedad(datos.getString("cod_vacuna"), datos.getString("nombre_vacuna"),
                    datos.getString("porc_efectividad"));
            vacunas.add(vacuna);
        }
        return vacunas;
    }

    public void llenarComboboxEnfermedades() throws SQLException {
        for (int i = 0; i < obtenerEnfermedades().size(); i++) {
            comboBoxEnfermedad.addItem(obtenerEnfermedades().get(i).getCodigo_Enfermedad() + " " + obtenerEnfermedades().get(i).getNombre_Enfermedad());
        }
    }

    public void llenarComboboxvacunas() throws SQLException {
        combo = new DefaultComboBoxModel();
        for (int i = 0; i < obtenerVacunas().size(); i++) {
            combo.addElement(obtenerVacunas().get(i).getCod_vacuna() + " " + obtenerVacunas().get(i).getNombre_Vacuna() + " Efectividad:" + obtenerVacunas().get(i).getPorcentage_Efectividad() + "%");
        }
        ComboBoxVacunas.setModel(combo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog2 = new datechooser.beans.DateChooserDialog();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        ComboBoxCitas = new javax.swing.JComboBox();
        comboBoxEnfermedad = new javax.swing.JComboBox();
        ComboBoxVacunas = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablacita = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablavacunasaplicadas = new javax.swing.JTable();
        AplicarVacuna = new javax.swing.JButton();
        FechaProximaVacuna = new datechooser.beans.DateChooserCombo();
        FechaConsulta = new datechooser.beans.DateChooserCombo();
        jLabel1 = new javax.swing.JLabel();
        txtnumeroconsulta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        notas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        RealizarConsulta = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ComboBoxCitas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxCitasItemStateChanged(evt);
            }
        });
        getContentPane().add(ComboBoxCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 241, 25));

        comboBoxEnfermedad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxEnfermedadItemStateChanged(evt);
            }
        });
        getContentPane().add(comboBoxEnfermedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 181, -1));
        getContentPane().add(ComboBoxVacunas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 210, -1));

        tablacita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Numero Cita", "Cod mascota", "Mascota", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablacita.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tablacita.setSelectionForeground(new java.awt.Color(102, 102, 102));
        tablacita.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablacita);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 944, 43));

        tablavacunasaplicadas.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tablavacunasaplicadas.setSelectionForeground(new java.awt.Color(102, 102, 102));
        tablavacunasaplicadas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablavacunasaplicadas);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 653, 148));

        AplicarVacuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/AplicarVacuna.png"))); // NOI18N
        AplicarVacuna.setBorderPainted(false);
        AplicarVacuna.setContentAreaFilled(false);
        AplicarVacuna.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/AplicarVacuna2.png"))); // NOI18N
        AplicarVacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AplicarVacunaActionPerformed(evt);
            }
        });
        getContentPane().add(AplicarVacuna, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 160, -1));

        FechaProximaVacuna.setCalendarBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(FechaProximaVacuna, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 200, 27));

        FechaConsulta.setCalendarPreferredSize(new java.awt.Dimension(323, 215));
        getContentPane().add(FechaConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, 192, 25));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Numero Consulta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));
        getContentPane().add(txtnumeroconsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 126, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Cita");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Fecha Consulta");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Enfermedad del paciente");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Vacunas Aplicables");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Proxima Vacunacion");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));
        getContentPane().add(notas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 600, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Notas Consulta");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        RealizarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/RealizarConsulta.png"))); // NOI18N
        RealizarConsulta.setBorderPainted(false);
        RealizarConsulta.setContentAreaFilled(false);
        RealizarConsulta.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/RealizarConsulta2.png"))); // NOI18N
        RealizarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RealizarConsultaActionPerformed(evt);
            }
        });
        getContentPane().add(RealizarConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 190, 50));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/CrearConsulta.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/CrearConsulta2.png"))); // NOI18N
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1043, 102));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Cerrar.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Cerrar2.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 440, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/fondo-madera-negro.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 100, 1050, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxEnfermedadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxEnfermedadItemStateChanged
        try {
            // TODO add your handling code here:
            llenarComboboxvacunas();
        } catch (SQLException ex) {
            Logger.getLogger(CrearConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboBoxEnfermedadItemStateChanged
    public void agregarCelda() throws SQLException {
        Object valores[] = {obtenerEnfermedades().get(comboBoxEnfermedad.getSelectedIndex()).getCodigo_Enfermedad(),
            obtenerEnfermedades().get(comboBoxEnfermedad.getSelectedIndex()).getNombre_Enfermedad(),
            obtenerVacunas().get(ComboBoxVacunas.getSelectedIndex()).getCod_vacuna(),
            obtenerVacunas().get(ComboBoxVacunas.getSelectedIndex()).getNombre_Vacuna(),
            FechaConsulta.getText(), FechaProximaVacuna.getText()};
        vacunasaplicadas.addRow(valores);
        tablavacunasaplicadas.setModel(vacunasaplicadas);
    }
    private void ComboBoxCitasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxCitasItemStateChanged
        // TODO add your handling code here:
        try {
            tablacita.setValueAt(obtenerdatosCitas().get(ComboBoxCitas.getSelectedIndex()).getCodigo_Cita(), 0, 0);
            tablacita.setValueAt(obtenerdatosCitas().get(ComboBoxCitas.getSelectedIndex()).getCod_mascota(), 0, 1);
            tablacita.setValueAt(obtenerdatosCitas().get(ComboBoxCitas.getSelectedIndex()).getMascota(), 0, 2);
            tablacita.setValueAt(obtenerdatosCitas().get(ComboBoxCitas.getSelectedIndex()).getFecha_cita(), 0, 3);
        } catch (SQLException ex) {
            Logger.getLogger(CrearConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ComboBoxCitasItemStateChanged

    private void AplicarVacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AplicarVacunaActionPerformed
        try {
            // TODO add your handling code here:
            agregarCelda();
        } catch (SQLException ex) {
            Logger.getLogger(CrearConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AplicarVacunaActionPerformed

    private void RealizarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RealizarConsultaActionPerformed
        ResultSet datos = conexioncitas.select("*", "\"schProyecto\".\"consulta\"", "");
        boolean esta = false;
        try {
            while (datos.next()) {
                if (datos.getString("cod").equals(txtnumeroconsulta.getText())) {
                    esta = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrearConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (esta == true) {
            JOptionPane.showMessageDialog(this, "Ese codigo de consulta ya esta por favor escribe otro");
        } else {
            try {
                // TODO add your handling code here:
                String datostablaConsulta = "('" + txtnumeroconsulta.getText() + "','" + obtenerdatosCitas().get(ComboBoxCitas.getSelectedIndex()).getCodigo_Cita() + "','" + FechaConsulta.getText() + "')";
                conexioncitas.Insertar("\"schProyecto\".\"consulta\"", datostablaConsulta);
            } catch (SQLException ex) {
                Logger.getLogger(CrearConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }

            String datosEnfermedad_Mascota;
            for (int i = 0; i < tablavacunasaplicadas.getRowCount(); i++) {
                try {
                    datosEnfermedad_Mascota = "('" + obtenerdatosCitas().get(ComboBoxCitas.getSelectedIndex()).getCod_mascota() + "','"
                            + tablavacunasaplicadas.getValueAt(i, 0) + "','" + FechaConsulta.getText() + "','" + notas.getText() + "','" + txtnumeroconsulta.getText() + "')";
                    conexioncitas.Insertar("\"schProyecto\".\"enfermedad_mascota\"", datosEnfermedad_Mascota);
                } catch (SQLException ex) {
                    Logger.getLogger(CrearConsulta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                for (int i = 0; i < tablavacunasaplicadas.getRowCount(); i++) {
                    String datosMascota_vacuna = "('" + obtenerdatosCitas().get(ComboBoxCitas.getSelectedIndex()).getCod_mascota() + "','"
                            + FechaConsulta.getText() + "','" + tablavacunasaplicadas.getValueAt(i, 2) + "','" + tablavacunasaplicadas.getValueAt(i, 5)
                            + "','" + txtnumeroconsulta.getText() + "')";
                    conexioncitas.Insertar("\"schProyecto\".\"mascota_vacuna\"", datosMascota_vacuna);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CrearConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conexioncitas.Modificar("\"schProyecto\".\"cita\"", obtenerdatosCitas().get(ComboBoxCitas.getSelectedIndex()).getCodigo_Cita(),
                        obtenerdatosCitas().get(ComboBoxCitas.getSelectedIndex()).getCod_mascota(), obtenerdatosCitas().get(ComboBoxCitas.getSelectedIndex()).getFecha_cita(),
                         "Realizada", obtenerdatosCitas().get(ComboBoxCitas.getSelectedIndex()).getCodigo_Cita());
            } catch (SQLException ex) {
                Logger.getLogger(CrearConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
            notas.setText("");
            txtnumeroconsulta.setText("");
            dispose();
        }
    }//GEN-LAST:event_RealizarConsultaActionPerformed

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
            java.util.logging.Logger.getLogger(CrearConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AplicarVacuna;
    private javax.swing.JComboBox ComboBoxCitas;
    private javax.swing.JComboBox ComboBoxVacunas;
    private datechooser.beans.DateChooserCombo FechaConsulta;
    private datechooser.beans.DateChooserCombo FechaProximaVacuna;
    private javax.swing.JButton RealizarConsulta;
    private javax.swing.JComboBox comboBoxEnfermedad;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private datechooser.beans.DateChooserDialog dateChooserDialog2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField notas;
    private javax.swing.JTable tablacita;
    private javax.swing.JTable tablavacunasaplicadas;
    private javax.swing.JTextField txtnumeroconsulta;
    // End of variables declaration//GEN-END:variables
}
