/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cajabanco;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author John
 */
public class SegundaOpcion extends javax.swing.JFrame {

    int suma = 1;
    /**
     * Creates new form VentanaCajeros
     */
    Lista cola = new Lista();

    public SegundaOpcion() {
        initComponents();
        PanelFondo F = new PanelFondo();
        this.add(F, BorderLayout.CENTER);
        this.pack();

        for (int i = 0; i < 4; i++) {
            String[] cat = {"A", "C", "C"};
            int numRandon = (int) (Math.random() * 3);
            Ficha ficha = new Ficha(cat[numRandon], suma);
            cola.agregaFinal(ficha);

            cola.ordenaPrioridad();
            suma++;

        }

        Resultado.setText(cola.toString());

        ResultadoCaja1.setText(cola.extraer());
        ResultadoCaja2.setText(cola.extraer());
        ResultadoCaja3.setText(cola.extraer());
        ResultadoCaja4.setText(cola.extraer());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Caja1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Resultado = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        ResultadoCaja2 = new javax.swing.JLabel();
        Caja3 = new javax.swing.JButton();
        Caja4 = new javax.swing.JButton();
        Caja2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ResultadoCaja1 = new javax.swing.JLabel();
        ResultadoCaja3 = new javax.swing.JLabel();
        ResultadoCaja4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Caja1.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        Caja1.setText("Caja#1");
        Caja1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caja1ActionPerformed(evt);
            }
        });
        getContentPane().add(Caja1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 29, 185, 42));

        Resultado.setColumns(20);
        Resultado.setRows(5);
        jScrollPane2.setViewportView(Resultado);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 127, 262, 388));

        jLabel5.setText("Atendiendo");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 77, 59, 27));
        getContentPane().add(ResultadoCaja2, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 77, 75, 27));

        Caja3.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        Caja3.setText("Caja#3");
        Caja3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caja3ActionPerformed(evt);
            }
        });
        getContentPane().add(Caja3, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 29, 185, 42));

        Caja4.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        Caja4.setText("Caja#4");
        Caja4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caja4ActionPerformed(evt);
            }
        });
        getContentPane().add(Caja4, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 29, 185, 42));

        Caja2.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        Caja2.setText("Caja#2");
        Caja2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caja2ActionPerformed(evt);
            }
        });
        getContentPane().add(Caja2, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 29, 185, 42));

        jLabel7.setText("Atendiendo");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 77, 59, 27));

        jLabel8.setText("Atendiendo");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 77, 59, 27));

        jLabel10.setText("Atendiendo");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 77, 59, 27));
        getContentPane().add(ResultadoCaja1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 77, 75, 27));
        getContentPane().add(ResultadoCaja3, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 77, 75, 27));
        getContentPane().add(ResultadoCaja4, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 77, 75, 27));

        jButton1.setText("SacarFicha");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 533, 110, -1));

        jButton2.setText("Regresar");
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Caja4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caja4ActionPerformed
        ResultadoCaja4.setText(cola.extraer());
        Resultado.setText(cola.toString());// actualiza la lista cuando se le extrae una ficha a la caja 4
    }//GEN-LAST:event_Caja4ActionPerformed

    private void Caja2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caja2ActionPerformed
        // TODO add your handling code here:
        ResultadoCaja2.setText(cola.extraer());
        Resultado.setText(cola.toString());//actualiza la lista cuando se le extrae una ficha a la caja 2
    }//GEN-LAST:event_Caja2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String[] cat = {"A", "B", "C"};
        int numRandon = (int) (Math.random() * 3);

        Ficha ficha = new Ficha(cat[numRandon], suma);
        cola.BuscarAgregar(ficha);

        Resultado.setText(cola.toString());

        suma++;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Caja3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caja3ActionPerformed
        ResultadoCaja3.setText(cola.extraer()); //actualiza la lista cuando se le extrae una ficha a la caja 3
        Resultado.setText(cola.toString());
        // TODO add your handling code here:
    }//GEN-LAST:event_Caja3ActionPerformed

    private void Caja1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caja1ActionPerformed
        // TODO add your handling code here:
        ResultadoCaja1.setText(cola.extraer());//actualiza la lista cuando se le extrae una ficha a la caja 1
        Resultado.setText(cola.toString());
    }//GEN-LAST:event_Caja1ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        primeraPantalla p = new primeraPantalla();
        p.pack();
        p.setVisible(true);
        setLocationRelativeTo(null);
        dispose();
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(SegundaOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SegundaOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SegundaOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SegundaOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SegundaOpcion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Caja1;
    private javax.swing.JButton Caja2;
    private javax.swing.JButton Caja3;
    private javax.swing.JButton Caja4;
    private javax.swing.JTextArea Resultado;
    private javax.swing.JLabel ResultadoCaja1;
    private javax.swing.JLabel ResultadoCaja2;
    private javax.swing.JLabel ResultadoCaja3;
    private javax.swing.JLabel ResultadoCaja4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JMenu jMenu1;
}