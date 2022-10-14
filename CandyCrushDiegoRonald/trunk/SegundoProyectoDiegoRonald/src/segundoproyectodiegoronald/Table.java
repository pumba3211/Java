/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segundoproyectodiegoronald;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class Table extends javax.swing.JDialog {

    Jugador jugador;
    int f;
    int c;
    private Dulce[][] dulce;
    private JButton[][] boton;
    private String[] location1;
    private String[] location2;
    boolean marcado = false;
    String aux1;
    String aux2;
    String btn1;
    String btn1_1;
    String btn2;
    String btn2_2;
    String color1;
    String color2;
    String aux;

    /**
     * Creates new form Table
     */
    public Table(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        iniciar();

    }

    public void iniciar() {

        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre.", "NOMBRE DEL JUGADOR.", JOptionPane.INFORMATION_MESSAGE);
        jugador = new Jugador();
        jugador.setNombre(nombre);
        jugar();
        this.vidas.setText(String.valueOf(jugador.getCantVidas()));
        this.movimientos.setText(String.valueOf(jugador.getMovimientos()));
        this.nivel.setText(String.valueOf(jugador.getNivel()));
        this.puntos.setText(String.valueOf(jugador.getPuntos() + 1));
        this.nombre.setText(jugador.getNombre());


    }

    public void jugar() {
        if (jugador.getNivel() == 1) {
            this.f = 5;
            this.c = 8;
        } else if (jugador.getNivel() == 2) {
            this.f = 9;
            this.c = 9;
        } else if (jugador.getNivel() == 3) {
            this.f = 7;
            this.c = 7;
        }
        dulce = new Dulce[f][c];
        boton = new JButton[f][c];
        crearDulces();
    }

    public boolean comprobarColor(int colorDulce, int i, int j) {
        boolean asignarColor = true; //true: color se queda, false: hay que calcular otro color

        if (i - 1 >= 0) { //Revisa si existe la fila menos uno
            //Revisa si el dulce en la fila menos uno es igual al dulce calculado
            if (this.dulce[i - 1][j].getNumero() == colorDulce) {
                //Revisa si existe la fila menos dos
                if (i - 2 >= 0) {
                    //Revisa si el dulce de la fila menos dos es igual al dulce calculado
                    if (this.dulce[i - 2][j].getNumero() == colorDulce) {
                        /**
                         * Devuelve la variable falsa para que se tenga que
                         * calcular un nuevo color.
                         */
                        asignarColor = false;
                    }
                }
            }
        }
        /**
         * Nota: Si ninguna de estas condiciones se cumple significa que el
         * color es correcto y se puede quedar en esa poscisión, por lo tanto el
         * método retorna en verdadero y no entra en el ciclo.
         */
        if (j - 1 >= 0) {
            if (this.dulce[i][j - 1].getNumero() == colorDulce) {
                if (j - 2 >= 0) {
                    if (this.dulce[i][j - 2].getNumero() == colorDulce) {
                        asignarColor = false;
                    }
                }
            }
        }
        return (asignarColor);
    }

    public void crearDulces() {
        int num = 0;
        //Ciclo que recorre las filas de la matriz
        for (int i = 0; i < dulce.length; i++) {
            //Ciclo que recorre las columnas de la matriz
            for (int j = 0; j < dulce[0].length; j++) {
                //Crea un nuevo dulce
                Dulce dul = new Dulce();
                //Calcula un color de dulce aleatorio
                num = dul.numero();
                while (!comprobarColor(num, i, j)) {
                    num = dul.numero();
                }
                dul.setNumero(num);
                dulce[i][j] = dul;
            }
        }

        crearBotones();
    }
    /**
     * metodo que crea los botones
     */
    public void crearBotones() {
        String text = "";
        //this.panel.setLayout(new GridLayout(this.dulce.length, this.dulce[0].length));
        for (int i = 0; i < boton.length; i++) {
            for (int j = 0; j < boton[0].length; j++) {
                //-------------------------------agrega nuevo boton-------------------
                this.panel.setLayout(new GridLayout(f, c));
                boton[i][j] = new JButton();
                text = i + " - " + j;
                //boton[i][j].setBounds((50 * i), (50 * j), 50, 50);
                boton[i][j].setActionCommand(text);
                boton[i][j].setText(text);
                //boton[i][j].setName(text);


                //-----------------------------agregar evento a los botones-------------
                boton[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        JButton evento = (JButton) evt.getSource();
                        if (marcado) {
                            aux2 = evento.getActionCommand();
                            location2 = aux2.split(" - ");
                            btn2 = location2[0];
                            btn2_2 = location2[1];
                            cambiarColor();

                            //JOptionPane.showMessageDialog(null, "peeec \n Se apreto el boton " +btn2);
                        } else {
                            aux1 = evento.getActionCommand();
                            marcado = true;
                            location1 = aux1.split(" - ");
                            btn1 = location1[0];
                            btn1_1 = location1[1];
                            //JOptionPane.showMessageDialog(null, "Se apreto el boton " +btn1);

                        }
                    }
                });
                //---------------------------termina de agregar evento-----------------


                //---------------------------asigna color tipo dulce a los botones------

                if (dulce[i][j].getColor().equals("Rojo")) {
                    boton[i][j].setBackground(Color.red);
                } else if (dulce[i][j].getColor().equals("Naranja")) {
                    boton[i][j].setBackground(Color.orange);
                } else if (dulce[i][j].getColor().equals("Amarillo")) {
                    boton[i][j].setBackground(Color.yellow);
                } else if (dulce[i][j].getColor().equals("Verde")) {
                    boton[i][j].setBackground(Color.green);
                } else if (dulce[i][j].getColor().equals("Azul")) {
                    boton[i][j].setBackground(Color.blue);
                } else if (dulce[i][j].getColor().equals("Morado")) {
                    boton[i][j].setBackground(Color.magenta);
                }
                this.panel.add(boton[i][j]);
            }
        }
    }
/**
 * Metodo para verificar los movimientos no validos si el boton 2 esta antes que
 * el primero en la matriz.
 * @return retorna boolean
 */
    public boolean noValidos2Primero() {
        boolean no = false;
        //movimientos no validos numero dos de primero ---------------------
        if ((Integer.parseInt(btn2)) < (Integer.parseInt(btn1)) && (Integer.parseInt(btn2_2) ) < (Integer.parseInt(btn1_1))) {
            //JOptionPane.showMessageDialog(this, "Movimiento no valido");
            no = true;
        } else if ((Integer.parseInt(btn2)) < (Integer.parseInt(btn1)) && (Integer.parseInt(btn2_2) ) > (Integer.parseInt(btn1_1))) {
            //JOptionPane.showMessageDialog(this, "Movimiento no valido");
            no = true;
//        } else if ((Integer.parseInt(btn2) - 1) == (Integer.parseInt(btn1)) && (Integer.parseInt(btn2_2) - 1) == (Integer.parseInt(btn1_1) )) {
//            JOptionPane.showMessageDialog(this, "Movimiento no valido");
//            no = true;
//        } else if ((Integer.parseInt(btn2) - 1) == (Integer.parseInt(btn1)) && (Integer.parseInt(btn2_2) + 1) == (Integer.parseInt(btn1_1))) {
//            JOptionPane.showMessageDialog(this, "Movimiento no valido");
//            no = true;
        }
        return no;
    }
    /**
     * Metodo para verificar los movimientos validos si el boton 2 esta primero
     * @return retorna booleano
     */
    public boolean valido2Primero() {
        //movimientos validos dos de primero------------------------------------------------
        boolean si = false;
        if ((Integer.parseInt(btn2)) == (Integer.parseInt(btn1)) && (Integer.parseInt(btn2_2) + 1) == (Integer.parseInt(btn1_1))) {
            //JOptionPane.showMessageDialog(this, "Movimiento hacia la izquierda");
            si = true;
        } else if ((Integer.parseInt(btn2) + 1) == (Integer.parseInt(btn1)) && (Integer.parseInt(btn2_2)) == (Integer.parseInt(btn1_1) )) {
            //JOptionPane.showMessageDialog(this, "Movimiento hacia la arriba");
            si = true;
        }
        return si;
    }
/**
 * Metodo para verificar los movimientos no validos si el boton 1 esta primero
 * @return retorna booleano
 */
    public boolean noValidos1primero() {
        boolean no = false;
        //movimientos no validos numero uno de primero ---------------------
        if ((Integer.parseInt(btn2)) > (Integer.parseInt(btn1)) && (Integer.parseInt(btn2_2)) > (Integer.parseInt(btn1_1))) {
            //JOptionPane.showMessageDialog(this, "Movimiento no valido");
            no = true;
        } else if ((Integer.parseInt(btn2) ) > (Integer.parseInt(btn1)) && (Integer.parseInt(btn2_2))< (Integer.parseInt(btn1_1) )) {
            //JOptionPane.showMessageDialog(this, "Movimiento no valido");
            no = true;
//        } else if ((Integer.parseInt(btn2) - 1) == (Integer.parseInt(btn1)) && (Integer.parseInt(btn2_2) + 1) == (Integer.parseInt(btn1_1))) {
//            JOptionPane.showMessageDialog(this, "Movimiento no valido");
//            no = true;
//        } else if ((Integer.parseInt(btn2) - 1) == (Integer.parseInt(btn1)) && (Integer.parseInt(btn2_2) - 1) == (Integer.parseInt(btn1_1))) {
//            JOptionPane.showMessageDialog(this, "Movimiento no valido");
//            no = true;
        }
        return no;
    }
/**
 * Metodo para verificar los movimientos validos si el boton 1 esta primero
 * @return retorna booleano
 */
    public boolean validos1primero() {
        boolean si = false;
        //movimientos validos uno de primero------------------------------------------------

        if ((Integer.parseInt(btn2)) == (Integer.parseInt(btn1)) && (Integer.parseInt(btn2_2)-1) == (Integer.parseInt(btn1_1))) {
            JOptionPane.showMessageDialog(this, "Movimiento hacia la derecha");
            si = true;
        } else if ((Integer.parseInt(btn2)-1) == (Integer.parseInt(btn1)) && (Integer.parseInt(btn2_2) ) == (Integer.parseInt(btn1_1))) {
            JOptionPane.showMessageDialog(this, "Movimiento hacia la abajo");
            si = true;
        }
        return si;
    }
/**
 * se prueban los movimientos y le muestra si es valido o no valido 
 */
    public void cambiarColor() {
        /**
         * validar el primer boton y si los movimientos son validos
         * recordar que solo se pueden los movimientos arriba abajo izq o derecha
         */
        int no = 0;
        if ((Integer.parseInt(btn2)) < (Integer.parseInt(btn1)) && (Integer.parseInt(btn2_2)) == (Integer.parseInt(btn1_1))||(Integer.parseInt(btn2)) == (Integer.parseInt(btn1)) && (Integer.parseInt(btn2_2)) < (Integer.parseInt(btn1_1))){
            if (noValidos2Primero()) {
                JOptionPane.showMessageDialog(this, "Movimiento no valido N° Primero");
            } else if (valido2Primero()) {
                JOptionPane.showMessageDialog(this, "Movimiento valido");
            }
        } else {
            if (noValidos1primero()) {
                JOptionPane.showMessageDialog(this, "Movimiento no valido N° Primero");
            } else if (validos1primero()) {
//                JOptionPane.showMessageDialog(this, "Movimiento valido");

            }
        }

        if (no <= 0) {
            /**
             * if para saber si fue el boton dos el primero en seleccionarse o
             * si fue el numero uno
             * PD:todavia no funciona XD!
             */
            if ((Integer.parseInt(btn2)) < (Integer.parseInt(btn1)) && (Integer.parseInt(btn2_2)) == (Integer.parseInt(btn1_1))||(Integer.parseInt(btn2)) == (Integer.parseInt(btn1)) && (Integer.parseInt(btn2_2)) < (Integer.parseInt(btn1_1))) {
                int contador = 0;
                for (int i = 0; i < dulce.length; i++) {
                    for (int j = 0; j < dulce[i].length; j++) {
                        if (dulce[i][j] == dulce[Integer.parseInt(location2[0])][Integer.parseInt(location2[1])]) {
                            String color2 = dulce[i][j].getColor();
                            contador += 1;

                        }
                        if (dulce[j][i] == dulce[Integer.parseInt(location1[0])][Integer.parseInt(location1[1])]) {
                            String color1 = dulce[i][j].getColor();
                            contador += 1;
                            String aux = color1;
                            color1 = color2;
                            color2 = aux;
                            dulce[Integer.parseInt(location1[0])][Integer.parseInt(location1[1])].setColor(color1);
                            dulce[Integer.parseInt(location2[0])][Integer.parseInt(location2[1])].setColor(aux);

                        }

                    }

                }
            } else {
                int contador = 0;
                for (int i = 0; i < dulce.length; i++) {
                    for (int j = 0; j < dulce[i].length; j++) {
                        if (dulce[i][j] == dulce[Integer.parseInt(location1[0])][Integer.parseInt(location1[1])]) {
                            String color1 = dulce[i][j].getColor();
                            contador += 1;

                        }
                        if (dulce[i][j] == dulce[Integer.parseInt(location2[0])][Integer.parseInt(location2[1])]) {
                            String color2 = dulce[i][j].getColor();
                            contador += 1;
                            String aux = color1;
                            color1 = color2;
                            color2 = aux;
                            dulce[Integer.parseInt(location1[0])][Integer.parseInt(location1[1])].setColor(color1);
                            dulce[Integer.parseInt(location2[0])][Integer.parseInt(location2[1])].setColor(aux);
                        }
                    }

                }
            }


        }
        //limipia todo para poder hacer otro movimiento sin que se caiga XD!
        marcado = false;
        aux2 = "";
        aux1 = "";
        btn2 = "";
        btn2_2 = "";
        btn1 = "";
        btn1_1 = "";
//        for (int i = 0; i < dulce.length; i++) {
//            for (int j = 0; j < dulce[i].length; j++) {
//                //dulce[Integer.parseInt(location1[0])][Integer.parseInt(location1[1])].getColor();
//                
//            }
//            
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        vidas = new javax.swing.JLabel();
        puntos = new javax.swing.JLabel();
        movimientos = new javax.swing.JLabel();
        nivel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setUndecorated(true);
        setResizable(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        vidas.setText("jLabel1");

        puntos.setText("jLabel1");

        movimientos.setText("jLabel1");

        nivel.setText("jLabel1");

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel1.setText("Vidas:");

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel2.setText("Puntos:");

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel3.setText("Movimientos:");

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel4.setText("Nivel:");

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel5.setText("Nombre:");

        nombre.setText("jLabel6");

        jButton1.setFont(new java.awt.Font("Adobe Caslon Pro", 1, 18)); // NOI18N
        jButton1.setText("Salir");
        jButton1.setPreferredSize(new java.awt.Dimension(17, 32));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(nombre))
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(vidas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(puntos)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(movimientos))
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(nivel))
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vidas)
                    .addComponent(puntos)
                    .addComponent(movimientos)
                    .addComponent(nivel)
                    .addComponent(nombre))
                .addGap(63, 63, 63)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 372, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Table dialog = new Table(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel movimientos;
    private javax.swing.JLabel nivel;
    private javax.swing.JLabel nombre;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel puntos;
    private javax.swing.JLabel vidas;
    // End of variables declaration//GEN-END:variables
}
