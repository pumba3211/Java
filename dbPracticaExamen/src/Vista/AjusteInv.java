/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Conexcion.Conectar;
import Datos.Productos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class AjusteInv extends javax.swing.JDialog {

    Conectar CT = new Conectar("dbPracticaExamen", "usrUTN", "12345");
    private int contLineas;
    private DefaultTableModel lineas;

    public AjusteInv(java.awt.Frame parent, boolean modal) throws ClassNotFoundException, SQLException {
        super(parent, modal);
        initComponents();
        obtenerProductos();
        CargarProductos();
        cargarNumeroPedido();

        lineas = new DefaultTableModel();

        lineas.addColumn("");
        lineas.addColumn("Codigo");
        lineas.addColumn("Descripcion");
        lineas.addColumn("Existencia teorica");
        lineas.addColumn("Existencia fisica");

    }

    public ArrayList<Datos.Productos> obtenerProductos() throws SQLException {

        ResultSet datos = CT.select("*", "\"schPracticaExamen\".\"articulo\"", "");
        ArrayList<Datos.Productos> productos = new ArrayList();
        while (datos.next()) {

            Productos pro = new Productos(datos.getString("descripcion"), datos.getString("codigo"), datos.getString("existencia"));
            productos.add(pro);

        }

        return productos;

    }

    public void CargarProductos() throws SQLException {

        for (int x = 0; x < obtenerProductos().size(); x++) {

            ComBoxListaProductos.addItem(obtenerProductos().get(x).getDescripcion());

        }

    }

    public void cargarNumeroPedido() throws SQLException {

        ResultSet datos = CT.select("num_documento", "\"schPracticaExamen\".toma_fisica", " order by num_documento DESC limit 1");

        while (datos.next()) {

            int numero = Integer.parseInt(datos.getString("num_documento")) + 1;
            lblPedido.setText(String.valueOf(numero));

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLineas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        ComBoxListaProductos = new javax.swing.JComboBox();
        btnInsertar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnProcesar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblPedido = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtJustificacion = new javax.swing.JTextArea();
        CKAplicado = new javax.swing.JCheckBox();

        jDialog1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblLineas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblLineas);

        jLabel2.setText("PRODUCTO:");

        ComBoxListaProductos.setToolTipText("");
        ComBoxListaProductos.setFocusable(false);

        btnInsertar.setText("INSERTAR");
        btnInsertar.setFocusable(false);
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        jLabel3.setText("CANTIDAD:");

        txtCantidad.setText("0");
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        btnProcesar.setText("PROCESAR PEDIDO");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("AJUSTE: #");

        lblPedido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPedido.setText("6789");

        txtJustificacion.setColumns(20);
        txtJustificacion.setRows(3);
        txtJustificacion.setBorder(javax.swing.BorderFactory.createTitledBorder("JUSTIFICACIÓN"));
        jScrollPane2.setViewportView(txtJustificacion);

        CKAplicado.setText("Aplicado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProcesar)
                .addGap(256, 256, 256))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnInsertar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComBoxListaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CKAplicado)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPedido)
                        .addGap(85, 85, 85)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ComBoxListaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CKAplicado))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInsertar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblPedido))
                        .addGap(29, 29, 29)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProcesar)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        try {
            contLineas++;

            ResultSet datos = CT.select("*", "\"schPracticaExamen\".\"articulo\"",
                    "where codigo='" + obtenerProductos().get(ComBoxListaProductos.getSelectedIndex()).getCodigo() + "'");

            while (datos.next()) {

                int total = Integer.parseInt(datos.getString("precio")) * Integer.parseInt(txtCantidad.getText());

                Object[] valores = {contLineas, obtenerProductos().get(ComBoxListaProductos.getSelectedIndex()).getCodigo(),
                    obtenerProductos().get(ComBoxListaProductos.getSelectedIndex()).getDescripcion(), datos.getString("existencia"), txtCantidad.getText()};
                lineas.addRow(valores);
            }

            tblLineas.setModel(lineas);
        } catch (SQLException ex) {
            Logger.getLogger(AjusteInv.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtCantidad.setText(null);
        btnProcesar.setEnabled(true);

    }//GEN-LAST:event_btnInsertarActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed

        String aplicado;

        if (CKAplicado.isSelected()) {

            aplicado = "S";
            for (int x = 0; x < tblLineas.getRowCount(); x++) {

                String ajusteInv = CT.Modificar("\"schPracticaExamen\".articulo", " set existencia='" + tblLineas.getValueAt(x, 4) + "'",
                        " where codigo='" + tblLineas.getValueAt(x, 1) + "'");

            }
        } else {

            aplicado = "N";
        }

        String ajuste = CT.Insertar("\"schPracticaExamen\".toma_fisica", "('" + lblPedido.getText() + "' , '" + txtJustificacion.getText() + "' , '" + aplicado + "')");

        for (int x = 0; x < tblLineas.getRowCount(); x++) {

            String detalles = CT.Insertar("\"schPracticaExamen\".detalle_toma_fisica",
                    "('" + lblPedido.getText() + "','" + tblLineas.getValueAt(x, 0) + "','" + tblLineas.getValueAt(x, 1)
                    + "','" + tblLineas.getValueAt(x, 3) + "','" + tblLineas.getValueAt(x, 4) + "')");

        }

        JOptionPane.showMessageDialog(rootPane, "Pedido realizado con exito");

    }//GEN-LAST:event_btnProcesarActionPerformed

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
            java.util.logging.Logger.getLogger(AjusteInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjusteInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjusteInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjusteInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AjusteInv dialog = null;
                try {
                    dialog = new AjusteInv(new javax.swing.JFrame(), true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AjusteInv.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AjusteInv.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CKAplicado;
    private javax.swing.JComboBox ComBoxListaProductos;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnProcesar;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPedido;
    private javax.swing.JTable tblLineas;
    public static javax.swing.JTextField txtCantidad;
    private javax.swing.JTextArea txtJustificacion;
    // End of variables declaration//GEN-END:variables
}
