/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.basico;

import vista.admin.AdminForm;
import controlador.UsuarioController;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import modelo.Usuarios;
import utilidades.CifradoUtils;

/**
 *
 * @author Manolo
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    UsuarioController userController;
    
    public Login() {
        initComponents();
        
        //Centramos la ventana
        this.setLocationRelativeTo(null);
        
        //Creamos un borde de color amarillo para el panel del título
        Border jPanelTitleBorder = BorderFactory.createMatteBorder(0,1,1,1,Color.YELLOW);
        jPanelTitle.setBorder(jPanelTitleBorder);
        
        //Creamos un borde naranja para el panel global
        Border glob_panel_border = BorderFactory.createMatteBorder(1,1,1,1,Color.orange);
        jPanel1.setBorder(glob_panel_border);
        
        //Se crea otro borde de color negro para los JLabel de cerrar y minimizar
        Border jLabelBorder = BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK);
        jLabelCerrar.setBorder(jLabelBorder);
        jLabelMinimizar.setBorder(jLabelBorder);
        
        //Se crea un borde para el label de crear cuenta
        Border label_create_account_border = BorderFactory.createMatteBorder(0,0,1,0,Color.lightGray);
        jLabelRegistraCuenta.setBorder(label_create_account_border);
        
        //Se crea un border con el color del JPanel padre para los label de los iconos para borrar el movimiento
        Border label_icons_border = BorderFactory.createMatteBorder(1,1,1,1,new Color(153,153,153));
        jLabelUsername.setBorder(label_icons_border);
        jLabelPassword.setBorder(label_icons_border);
        
        //Se crea un borde para los campos de username_field y el password_field
        Border field_border = BorderFactory.createMatteBorder(1,5,1,1,Color.white);
        jTextFieldUsername.setBorder(field_border);
        jPasswordField.setBorder(field_border);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelMinimizar = new javax.swing.JLabel();
        jLabelCerrar = new javax.swing.JLabel();
        jPanelTitle = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jLabelRegistraCuenta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Padel Land");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabelMinimizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMinimizar.setText(" - ");
        jLabelMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMinimizarMouseExited(evt);
            }
        });

        jLabelCerrar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelCerrar.setText(" X ");
        jLabelCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelCerrarMouseExited(evt);
            }
        });

        jPanelTitle.setBackground(new java.awt.Color(23, 255, 108));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Login");

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTitleLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(20, 20, 20))
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addComponent(jLabelMinimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCerrar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelMinimizar)
                            .addComponent(jLabelCerrar))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabelPassword.setOpaque(true);

        jLabelUsername.setOpaque(true);

        jTextFieldUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldUsername.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldUsernameFocusLost(evt);
            }
        });

        jPasswordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPasswordField.setForeground(new java.awt.Color(153, 153, 153));
        jPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusLost(evt);
            }
        });

        jButtonLogin.setBackground(new java.awt.Color(0, 84, 140));
        jButtonLogin.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setText("Login");
        jButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseExited(evt);
            }
        });
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jLabelRegistraCuenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelRegistraCuenta.setForeground(new java.awt.Color(255, 0, 0));
        jLabelRegistraCuenta.setText("¿No tienes cuenta? ¡Regístrate!");
        jLabelRegistraCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRegistraCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegistraCuentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelRegistraCuentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelRegistraCuentaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 54, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldUsername)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelRegistraCuenta)
                .addGap(154, 154, 154))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelRegistraCuenta)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        //Seteamos el en el icono la imagen de username_field.png
        jLabelPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/password_field.png")));
        //Seteamos el en el icono la imagen de username_field.png
        jLabelUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/username_field.png")));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizarMouseEntered
        // TODO add your handling code here:
        Border jLabelBorder = BorderFactory.createMatteBorder(1,1,1,1,Color.WHITE);
        jLabelMinimizar.setBorder(jLabelBorder);
        jLabelMinimizar.setForeground(Color.WHITE);
    }//GEN-LAST:event_jLabelMinimizarMouseEntered

    private void jLabelMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizarMouseExited
        // TODO add your handling code here:
        Border jLabelBorder = BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK);
        jLabelMinimizar.setBorder(jLabelBorder);
        jLabelMinimizar.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabelMinimizarMouseExited

    private void jLabelCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCerrarMouseEntered
        // TODO add your handling code here:
        Border jLabelBorder = BorderFactory.createMatteBorder(1,1,1,1,Color.WHITE);
        jLabelCerrar.setBorder(jLabelBorder);
        jLabelCerrar.setForeground(Color.WHITE);
    }//GEN-LAST:event_jLabelCerrarMouseEntered

    private void jLabelCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCerrarMouseExited
        // TODO add your handling code here:
        Border jLabelBorder = BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK);
        jLabelCerrar.setBorder(jLabelBorder);
        jLabelCerrar.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabelCerrarMouseExited

    private void jTextFieldUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUsernameFocusGained
        // TODO add your handling code here:
        
        //Si el jtextfield de username coge el foco le damos color de fondo a negro
        jTextFieldUsername.setForeground(Color.BLACK);
        
        //Ponemos un borde verde para el jlabel del icono de username
        Border jLabelIcon = BorderFactory.createMatteBorder(1,1,1,1,Color.orange);
        jLabelUsername.setBorder(jLabelIcon);
    }//GEN-LAST:event_jTextFieldUsernameFocusGained

    private void jTextFieldUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUsernameFocusLost
        // TODO add your handling code here:
        
        //Si el jtextfield esta vacío o tiene username, seteamos "username" en el campo al perder el foco
        jTextFieldUsername.setForeground(new Color(153,153,153));
        
        //Se crea un border con el color del JPanel padre para los label de los iconos para borrar el movimiento
        Border label_icons_border = BorderFactory.createMatteBorder(1,1,1,1,new Color(153,153,153));
        jLabelUsername.setBorder(label_icons_border);
    }//GEN-LAST:event_jTextFieldUsernameFocusLost

    private void jPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldFocusGained
        // TODO add your handling code here:
        jPasswordField.setForeground(Color.BLACK);
        
        //Ponemos un borde verde para el jlabel del icono de password
        Border jLabelIcon = BorderFactory.createMatteBorder(1,1,1,1,Color.orange);
        jLabelPassword.setBorder(jLabelIcon);
    }//GEN-LAST:event_jPasswordFieldFocusGained

    private void jPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldFocusLost
        // TODO add your handling code here:

        jPasswordField.setForeground(new Color(153,153,153));
        
        //Se crea un border con el color del JPanel padre para los label de los iconos para borrar el movimiento
        Border label_icons_border = BorderFactory.createMatteBorder(1,1,1,1,new Color(153,153,153));
        jLabelPassword.setBorder(label_icons_border);
    }//GEN-LAST:event_jPasswordFieldFocusLost

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        // TODO add your handling code here:
        
        if (verifyFields()){
            //Obtenemos los datos del formulario
            String username = jTextFieldUsername.getText();
            String password = String.valueOf(jPasswordField.getPassword());
        
            userController = new UsuarioController();
            try {
                Usuarios usuario = userController.obtenerUsuarioPorUsernameAndPassword(username, CifradoUtils.getMD5(password));
                if (usuario != null){
                    if (usuario.getRol().equals("basico")){
                        MisDatos md = new MisDatos(this, rootPaneCheckingEnabled);
                        md.setVisible(true);
                        md.pack();
                        md.setLocationRelativeTo(null);
                        //Cerramos el formulario actual
                        this.dispose();
                    }else if (usuario.getRol().equals("administrador")){
                        AdminForm af = new AdminForm();
                        af.setVisible(true);
                        af.pack();
                        af.setLocationRelativeTo(null);
                        af.jLabelBienvenida.setText("<html><body>¡Bienvenido #"+usuario.getUsername()+"#!<br>Esta es la vista de Administrador de Padel Land</body></html>");
                        this.dispose();
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Usuario/Contraseña son inválidos","Error de inicio de sesión",2);
                }
            }catch(HeadlessException ex){
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jButtonLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseEntered
        // TODO add your handling code here:
        //Seteamos el background del jbutton
        jButtonLogin.setBackground(new Color(0,101,183));
    }//GEN-LAST:event_jButtonLoginMouseEntered

    private void jButtonLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseExited
        // TODO add your handling code here:
        //Seteamos el background del jbutton
        jButtonLogin.setBackground(new Color(0,84,104));
    }//GEN-LAST:event_jButtonLoginMouseExited

    private void jLabelMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizarMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinimizarMouseClicked

    private void jLabelCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCerrarMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabelCerrarMouseClicked

    private void jLabelRegistraCuentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRegistraCuentaMouseEntered
        // TODO add your handling code here:
        Border label_border = BorderFactory.createMatteBorder(0,0,1,0,Color.red);
        jLabelRegistraCuenta.setBorder(label_border);
    }//GEN-LAST:event_jLabelRegistraCuentaMouseEntered

    private void jLabelRegistraCuentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRegistraCuentaMouseExited
        // TODO add your handling code here:
         //Se crea un borde para el label de crear cuenta
        Border label_create_account_border = BorderFactory.createMatteBorder(0,0,1,0,Color.lightGray);
        jLabelRegistraCuenta.setBorder(label_create_account_border);
    }//GEN-LAST:event_jLabelRegistraCuentaMouseExited

    private void jLabelRegistraCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRegistraCuentaMouseClicked
        // TODO add your handling code here:
        Registro register_form = new Registro();
        register_form.setVisible(true);
        register_form.pack();
        register_form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabelRegistraCuentaMouseClicked

    
    //Se crea un método para verificar y validar los campos
    public boolean verifyFields() {
        String username = jTextFieldUsername.getText();
        String password = String.valueOf(jPasswordField.getPassword());
        
        //Comprobar si hay campos vacíos
        if (username.trim().equals("")){
            JOptionPane.showMessageDialog(null, "Introduce username","Username vacío",2);
            return false;
        }else if(password.trim().equals("")){
            JOptionPane.showMessageDialog(null, "Introduce password","Password vacía",2);
            return false;
        }else {
            return true;
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCerrar;
    private javax.swing.JLabel jLabelMinimizar;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelRegistraCuenta;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}