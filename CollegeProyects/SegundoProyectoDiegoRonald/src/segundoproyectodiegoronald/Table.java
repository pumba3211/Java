/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segundoproyectodiegoronald;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
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
    private ArrayList<Dulce> listCol;
    boolean marcado = false;
    int reversa = 0;
    String aux1;
    String aux2;
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

        String nombre = JOptionPane.showInputDialog(this, "Ingrese su nombre.", "Nombre.", JOptionPane.INFORMATION_MESSAGE);
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
        listCol = new ArrayList<>();
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
            for (int j = 0; j < dulce[i].length; j++) {
                //Crea un nuevo dulce
                Dulce dul = new Dulce();
                //Calcula un color de dulce aleatorio

                do {
                    num = dul.numero();
                } while (!comprobarColor(num, i, j));
                dul.setNumero(num);
                dul.setPosX(i);
                dul.setPosY(j);
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
            for (int j = 0; j < boton[i].length; j++) {
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
                           
                            cambiarColor();

                            quitarColores(Integer.parseInt(location2[0]), Integer.parseInt(location2[1]));
                            quitarColores(Integer.parseInt(location1[0]), Integer.parseInt(location1[1]));

//                            nuevosColores();
//                            if (reversa == 2) {
//                                cambiarColor();
//                            }
//                            reversa = 0;


                            //JOptionPane.showMessageDialog(null, "peeec \n Se apreto el boton " +btn2);
                        } else {
                            aux1 = evento.getActionCommand();
                            marcado = true;
                            location1 = aux1.split(" - ");
                            //btn1 = location1[0];
                            //btn1_1 = location1[1];
                            //JOptionPane.showMessageDialog(null, "Se apreto el boton " +btn1);

                        }
                    }
                });
                //---------------------------termina de agregar evento-----------------


                //---------------------------asigna color tipo dulce a los botones------
                obtenerColor(i, j);

                this.panel.add(boton[i][j]);
            }
        }
    }

    public Color obtenerColor(int i, int j) {
        Color color = Color.BLACK;
        if (dulce[i][j].getColor().equals("Rojo")) {
            boton[i][j].setBackground(Color.red);
            color = color.red;
        } else if (dulce[i][j].getColor().equals("Naranja")) {
            boton[i][j].setBackground(Color.orange);
            color = color.orange;
        } else if (dulce[i][j].getColor().equals("Amarillo")) {
            boton[i][j].setBackground(Color.yellow);
            color = Color.yellow;
        } else if (dulce[i][j].getColor().equals("Verde")) {
            boton[i][j].setBackground(Color.green);
            color = Color.green;
        } else if (dulce[i][j].getColor().equals("Azul")) {
            boton[i][j].setBackground(Color.blue);
            color = Color.blue;
        } else if (dulce[i][j].getColor().equals("Morado")) {
            boton[i][j].setBackground(Color.magenta);
            color = Color.magenta;
        }
        return color;

    }

    public boolean validarMovimiento() {
        boolean movimiento = false;
        if ((Integer.parseInt(location1[0]) == Integer.parseInt(location2[0])) || (Integer.parseInt(location1[1]) == Integer.parseInt(location2[1]))) {
            if ((Integer.parseInt(location1[0]) - 1 == Integer.parseInt(location2[0])) || (Integer.parseInt(location1[1]) - 1 == Integer.parseInt(location2[1])) || (Integer.parseInt(location1[1]) + 1 == Integer.parseInt(location2[1])) || (Integer.parseInt(location1[0]) + 1 == Integer.parseInt(location2[0]))) {
                movimiento = true;
            }
        } else {
            movimiento = false;
        }
        return movimiento;
    }

    public void eliminarColores(int posX, int posY) {
        dulce[posX][posY].setColor("BLACK");
        boton[posX][posY].setBackground(obtenerColor(posX, posY));
//        dulce[posX][posY].setColor(dulce[posX - 1][posY].getColor());
//        boton[posX][posY].setBackground(obtenerColor(posX - 1, posY));

    }

    public void moverColores(int posX, int posY) {
        for (int i = posX; i > 0; i--) {
            color1 = dulce[i][posY].getColor();
            color2 = dulce[i - 1][posY].getColor();
            String aux = color1;
            color1 = color2;
            color2 = aux;
            dulce[i][posY].setColor(color1);
            dulce[i - 1][posY].setColor(color2);
//            dulce[Integer.parseInt(location1[0])][Integer.parseInt(location1[1])].getColor();
//            dulce[Integer.parseInt(location2[0])][Integer.parseInt(location2[1])].getColor();
            boton[i][posY].setBackground(obtenerColor(i, posY));
            boton[i - 1][posY].setBackground(obtenerColor(i - 1, posY));
//            quitarColores(i, posY);
        }
    }

    public void quitarColores(int posX, int posY) {
        color2 = dulce[posX][posY].getColor();
        ArrayList<String> posiciones = new ArrayList<>();
        ArrayList<String> posiciones2 = new ArrayList<>();
        for (int i = posY; i < dulce[1].length; i++) {
            if (color2.equals(dulce[posX][i].getColor()) && !color2.equals("BLACK")) {
                posiciones.add(posX + "-" + i);
            } else {
                i = dulce[1].length + 1;
            }
        }
        for (int i = posY - 1; i >= 0; i--) {
            if (color2.equals(dulce[posX][i].getColor())&& !color2.equals("BLACK")) {
                posiciones.add(posX + "-" + i);
            } else {
                i = 0;
            }
        }
        if (posiciones.size() <= 2) {
            posiciones.clear();
        }
        for (int i = posX; i < dulce[0].length; i++) {
            if (color2.equals(dulce[i][posY].getColor())&& !color2.equals("BLACK")) {
                posiciones2.add(i + "-" + posY);
            } else {
                i = dulce[1].length + 1;
            }
        }
        for (int i = posX - 1; i >= 0; i--) {
            if (color2.equals(dulce[i][posY].getColor())&& !color2.equals("BLACK")) {
                posiciones2.add(i + "-" + posY);
            } else {
                i = 0;
            }
        }
        if (posiciones2.size() <= 2) {
            posiciones2.clear();
        }
        posiciones.addAll(posiciones2);
        Collections.sort(posiciones);
        for (int i = 0; i < posiciones.size(); i++) {
            String vect[] = posiciones.get(i).split("-");
            eliminarColores(Integer.parseInt(vect[0]), Integer.parseInt(vect[1]));
        }
        for (int i = 0; i < posiciones.size(); i++) {
            String vect[] = posiciones.get(i).split("-");
            moverColores(Integer.parseInt(vect[0]), Integer.parseInt(vect[1]));
        }

        //JOptionPane.showMessageDialog(rootPane, ""+posiciones.size());
        if (posiciones.size() <= 2) {
            reversa++;
        }
    }

    public void nuevosColores() {
        for (int i = 0; i < dulce.length; i++) {
            for (int j = 0; j < dulce[i].length; j++) {
                String tempColor = dulce[i][j].getColor();
                if (tempColor.equals("BLACK")) {
                    int num = 0;
                    do {
                        num = dulce[i][j].numero();
                    } while (!comprobarColor(num, i, j));
                    dulce[i][j].setNumero(num);
                    boton[i][j].setBackground(obtenerColor(i, j));
                }

            }

        }
    }

    public void cambiarColor() {
        if (validarMovimiento()) {
            color1 = dulce[Integer.parseInt(location1[0])][Integer.parseInt(location1[1])].getColor();
            color2 = dulce[Integer.parseInt(location2[0])][Integer.parseInt(location2[1])].getColor();
            String aux = color1;
            color1 = color2;
            color2 = aux;
            dulce[Integer.parseInt(location1[0])][Integer.parseInt(location1[1])].setColor(color1);
            dulce[Integer.parseInt(location2[0])][Integer.parseInt(location2[1])].setColor(color2);
//            dulce[Integer.parseInt(location1[0])][Integer.parseInt(location1[1])].getColor();
//            dulce[Integer.parseInt(location2[0])][Integer.parseInt(location2[1])].getColor();
            boton[Integer.parseInt(location1[0])][Integer.parseInt(location1[1])].setBackground(obtenerColor((Integer.parseInt(location1[0])), (Integer.parseInt(location1[1]))));
            boton[Integer.parseInt(location2[0])][Integer.parseInt(location2[1])].setBackground(obtenerColor((Integer.parseInt(location2[0])), (Integer.parseInt(location2[1]))));
        }
        marcado = false;
        aux2 = "";
        aux1 = "";
        //btn2 = "";
        //btn2_2 = "";
        //btn1 = "";
        //btn1_1 = "";


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
        setTitle("Juego");
        setAutoRequestFocus(false);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(puntos)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
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
                .addGap(54, 54, 54)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
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
