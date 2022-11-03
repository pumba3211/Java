/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazProyectoMascotaFeliz;

import datos.Especie;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyectomascotafeliz.MantemimientoRazas;
import proyectomascotafeliz.Mantenimientoespecies;
import proyectomascotafeliz.archivo;

/**
 *
 * @author Ronald
 */
public class Razas extends javax.swing.JFrame {

    private archivo archivo = new archivo();
    MantemimientoRazas conexion;//Se crea una conexion a las razas
    private DefaultTableModel razas;//Se crea un nuevo modelo para el jtable de las tazas
    private JPanel panelInsertar;//Se crea un panel para insertar
    private String codigoguardar;
    Mantenimientoespecies conexiontablaespecies;//Se crea una conexion a las especies

    /**
     * Creates new form Especie
     */
    //METODO CONSTRUCTOR
    public Razas() {
        archivo.leer();
        try {
            this.conexion = new MantemimientoRazas(archivo.getBase(), archivo.getUser(), archivo.getPassword());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Especie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Especie.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.conexiontablaespecies = new Mantenimientoespecies(archivo.getBase(), archivo.getUser(), archivo.getPassword());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Especie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Especie.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        try {
            llenarComboboxEspecies();
        } catch (SQLException ex) {
            Logger.getLogger(Razas.class.getName()).log(Level.SEVERE, null, ex);
        }
        cargarrazas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        Modificarrazas = new javax.swing.JButton();
        Insertarraza = new javax.swing.JButton();
        Eliminarraza = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablarazas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codraza = new javax.swing.JTextField();
        nomraza = new javax.swing.JTextField();
        comboxEspecie = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Modificarrazas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Dueño/Modificar.png"))); // NOI18N
        Modificarrazas.setBorderPainted(false);
        Modificarrazas.setContentAreaFilled(false);
        Modificarrazas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Dueño/Modificar2.png"))); // NOI18N
        Modificarrazas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarrazasActionPerformed(evt);
            }
        });
        getContentPane().add(Modificarrazas, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, -1, -1));

        Insertarraza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Dueño/Insertat.png"))); // NOI18N
        Insertarraza.setBorderPainted(false);
        Insertarraza.setContentAreaFilled(false);
        Insertarraza.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Dueño/Insertat2.png"))); // NOI18N
        Insertarraza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarrazaActionPerformed(evt);
            }
        });
        getContentPane().add(Insertarraza, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        Eliminarraza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Dueño/Eliminar.png"))); // NOI18N
        Eliminarraza.setBorderPainted(false);
        Eliminarraza.setContentAreaFilled(false);
        Eliminarraza.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Dueño/Eliminar2.png"))); // NOI18N
        Eliminarraza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarrazaActionPerformed(evt);
            }
        });
        getContentPane().add(Eliminarraza, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        tablarazas.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tablarazas.setSelectionForeground(new java.awt.Color(102, 102, 102));
        tablarazas.getTableHeader().setResizingAllowed(false);
        tablarazas.getTableHeader().setReorderingAllowed(false);
        tablarazas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablarazasMouseClicked(evt);
            }
        });
        tablarazas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablarazasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablarazas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 420, 301));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Dueño/Cerrar.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Dueño/Cerrar2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 150, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Codigo Raza");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Codigo Especie");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Nombre Raza");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, -1, -1));

        codraza.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        codraza.setSelectionColor(new java.awt.Color(204, 204, 204));
        getContentPane().add(codraza, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 130, -1));

        nomraza.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        nomraza.setSelectionColor(new java.awt.Color(204, 204, 204));
        getContentPane().add(nomraza, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 270, 130, -1));
        getContentPane().add(comboxEspecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 130, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Dueño/Raza.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setDefaultCapable(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Dueño/Raza2.png"))); // NOI18N
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 100));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseños/Dueño/fondo-madera-negro.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 780, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Se inserta una raza en la tabla de la base de datos
    private void InsertarrazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarrazaActionPerformed
        // TODO add your handling code here:
        //Se crean y se asignan los componentes al panel insertar
        panelInsertar = new JPanel();
        JButton insertar = new JButton("Insertar");
        JLabel codigo = new JLabel("Codigo Raza");
        JLabel codigoespecie = new JLabel("Codigo Especie");
        JLabel nombreraza = new JLabel("Raza");
        JTextField txtCodigo = new JTextField(10);
        JComboBox combocodigoespecie = new JComboBox();
        try {
            for (int x = 0; x < obtenerEspecies().size(); x++) {
                combocodigoespecie.addItem(obtenerEspecies().get(x).getCodigo() + " " + obtenerEspecies().get(x).getNombre());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Razas.class.getName()).log(Level.SEVERE, null, ex);
        }
        JTextField txtnombreraza = new JTextField(10);
        panelInsertar.add(codigo);
        panelInsertar.add(txtCodigo);
        panelInsertar.add(codigoespecie);
        panelInsertar.add(combocodigoespecie);
        panelInsertar.add(nombreraza);
        panelInsertar.add(txtnombreraza);
        JOptionPane.showConfirmDialog(null, panelInsertar, "Insertar Raza", JOptionPane.PLAIN_MESSAGE);
        String datos;
        String estado;
        try {
            datos = "('" + txtCodigo.getText() + "','" + obtenerEspecies().get(combocodigoespecie.getSelectedIndex()).getCodigo()
                    + "','" + txtnombreraza.getText() + "')";
            estado = conexion.Insertar("\"schProyecto\".\"raza\"", datos);
            JOptionPane.showMessageDialog(null, "Datos insertado con exito");
            cargarrazas();
        } catch (SQLException ex) {
            Logger.getLogger(Razas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_InsertarrazaActionPerformed
    //Cierra la ventana
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    //Elimina una raza de la tabla razas
    private void EliminarrazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarrazaActionPerformed
        // TODO add your handling code here:
        String estado;

        estado = this.conexion.eliminar("\"schProyecto\".\"raza\"", String.valueOf(tablarazas.getValueAt(tablarazas.getSelectedRow(), 0)));
        cargarrazas();
        JOptionPane.showMessageDialog(null, "Datos eliminados");

        codraza.setText("");

        nomraza.setText("");
    }//GEN-LAST:event_EliminarrazaActionPerformed
    //Guarda los valores de la tabla razas en las cajas de texto
    private void tablarazasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablarazasMouseClicked
        // TODO add your handling code here:
        codraza.setText((String) tablarazas.getValueAt(tablarazas.getSelectedRow(), 0));
        nomraza.setText((String) tablarazas.getValueAt(tablarazas.getSelectedRow(), 1));
        codigoguardar = (String) tablarazas.getValueAt(tablarazas.getSelectedRow(), 0);
    }//GEN-LAST:event_tablarazasMouseClicked
    //Modifica una raza de la tabla
    private void ModificarrazasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarrazasActionPerformed
        // TODO add your handling code here:
        String estado;
        try {
            estado = conexion.Modificar("\"schProyecto\".\"raza\"", codraza.getText(), (obtenerEspecies().get(comboxEspecie.getSelectedIndex()).getCodigo()), nomraza.getText(), codigoguardar);
        } catch (SQLException ex) {
            Logger.getLogger(Razas.class.getName()).log(Level.SEVERE, null, ex);
        }
        cargarrazas();
        JOptionPane.showMessageDialog(null, "Datos modificados con exito");

        codraza.setText("");
        nomraza.setText("");
    }//GEN-LAST:event_ModificarrazasActionPerformed

    private void tablarazasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablarazasKeyPressed
        // TODO add your handling code here:
        codraza.setText((String) tablarazas.getValueAt(tablarazas.getSelectedRow(), 0));
        nomraza.setText((String) tablarazas.getValueAt(tablarazas.getSelectedRow(), 1));
        codigoguardar = (String) tablarazas.getValueAt(tablarazas.getSelectedRow(), 0);
    }//GEN-LAST:event_tablarazasKeyPressed
    //Se cargan las razas de la tabla razas 
    public void cargarrazas() {
        razas = new DefaultTableModel();
        razas.addColumn("Codigo Raza");
        razas.addColumn("Raza");
        razas.addColumn("Codigo Especie");
        razas.addColumn("Nombre Especie");
        ResultSet datos = conexion.select2();

        try {

            while (datos.next()) {
                String[] valores = {datos.getString("cod_raza"), datos.getString("nombre_raza"), datos.getString("cod_especie"), datos.getString("nombre_especie")};
                razas.addRow(valores);
            }
            tablarazas.setModel(razas);

        } catch (Exception e) {

            System.out.println("Error: " + e.toString());
        }
    }

    //Se obtienen los valores de la tabla especies y se guardan en un array list
    public ArrayList<Especie> obtenerEspecies() throws SQLException {

        ResultSet datos = conexiontablaespecies.select("*", "\"schProyecto\".\"especie\"", "");
        ArrayList<Especie> especies = new ArrayList();
        while (datos.next()) {

            Especie especie = new Especie(datos.getString("cod_especie"), datos.getString("nombre_especie"));
            especies.add(especie);
        }
        return especies;
    }

    //Se llena el comboboxde las especies
    public void llenarComboboxEspecies() throws SQLException {
        for (int i = 0; i < obtenerEspecies().size(); i++) {
            comboxEspecie.addItem(obtenerEspecies().get(i).getCodigo() + " " + obtenerEspecies().get(i).getNombre());
        }
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
            java.util.logging.Logger.getLogger(Razas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Razas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Razas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Razas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Razas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminarraza;
    private javax.swing.JButton Insertarraza;
    private javax.swing.JButton Modificarrazas;
    private javax.swing.JTextField codraza;
    private javax.swing.JComboBox comboxEspecie;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomraza;
    private javax.swing.JTable tablarazas;
    // End of variables declaration//GEN-END:variables
}