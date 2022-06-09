/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.auth;

import controlador.UsuarioController;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Usuarios;
import utilidades.CifradoUtil;
import utilidades.Constantes;
import utilidades.ImagenFondo;
import utilidades.Mailer;
import validator.EmailValidator;
import vista.basico.VistaUsuarioBasicoForm;
/**
 *
 * @author Manolo
 */
public class Registro extends javax.swing.JFrame {

    /**
     * Creates new form Registro
     */
    UsuarioController userController;
    //Variable para almacenar la ruta de la imagen
    String image_path = null;
    JFrame form;
    
    public Registro() {
        initComponents();
        userController = new UsuarioController();
    }
    
    public Registro(JFrame form){
        initComponents();
        this.form = form;
        userController = new UsuarioController();
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
        jPanel3 = new ImagenFondo();
        jButtonRegistro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNombreCompleto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButtonElegirImagen = new javax.swing.JButton();
        jLabelRutaImagen = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jPasswordConfirmField = new javax.swing.JPasswordField();
        jButtonQuitarImagen = new javax.swing.JButton();
        jLabelIniciaSesion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Padel Land - Registro ");
        setResizable(false);

        jButtonRegistro.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        jButtonRegistro.setText("Registro");
        jButtonRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nombre Completo:");

        jTextFieldNombreCompleto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Email:");

        jTextFieldEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Password:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Confirmar password:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Nº Teléfono:");

        jTextFieldTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Imagen de usuario:");

        jButtonElegirImagen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonElegirImagen.setText("Elegir imagen");
        jButtonElegirImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonElegirImagenActionPerformed(evt);
            }
        });

        jLabelRutaImagen.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N

        jPasswordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jPasswordConfirmField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButtonQuitarImagen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonQuitarImagen.setText("Quitar imagen");
        jButtonQuitarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitarImagenActionPerformed(evt);
            }
        });

        jLabelIniciaSesion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIniciaSesion.setForeground(new java.awt.Color(0, 51, 255));
        jLabelIniciaSesion.setText("¿Ya tienes cuenta? ¡Inicia sesión!");
        jLabelIniciaSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelIniciaSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIniciaSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelIniciaSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelIniciaSesionMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Registro");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jButtonElegirImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButtonQuitarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabelRutaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPasswordConfirmField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(83, 83, 83))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabelIniciaSesion)
                        .addGap(184, 184, 184))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jPasswordConfirmField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jButtonElegirImagen)
                    .addComponent(jButtonQuitarImagen))
                .addGap(18, 18, 18)
                .addComponent(jLabelRutaImagen)
                .addGap(31, 31, 31)
                .addComponent(jButtonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelIniciaSesion)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jButtonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroActionPerformed
        // TODO add your handling code heres
        String email = jTextFieldEmail.getText();
        if (verifyFields()){
            if (!checkEmail(email)){
                Usuarios user;
                String nombreCompleto = jTextFieldNombreCompleto.getText();
                String password = CifradoUtil.getHash(String.valueOf(jPasswordField.getPassword()));
                String telefono = jTextFieldTelefono.getText();
                String rol = "basico";
                if (image_path != null && !image_path.equals("")){
                    File file = new File(image_path);
                    Blob imageBlob = null;
                    try {
                        FileInputStream fis = new FileInputStream(file);
                        imageBlob = userController.obtenerBlob(fis, file);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    user = new Usuarios(nombreCompleto, email, password, telefono, imageBlob, rol, null);
                }else{
                    user = new Usuarios(nombreCompleto, email, password, telefono, rol);
                }
                long result = userController.insertUsuario(user);
                if (result != 0){
                    JOptionPane.showMessageDialog(null, "¡Usuario creado correctamente!","INFO", JOptionPane.INFORMATION_MESSAGE);
                    Mailer mailer = new Mailer();
                    String mensaje = "¡Hola " + user.getNombreCompleto()+ "!\nNos complace darte la bienvenida a Padel Land, esperemos que te guste nuestro servicio y que disfrutes de nuestras maravillosas pistas\n¡A jugar!";
                    mailer.enviarMail(Constantes.EMAIL_ADMIN,user.getEmail(),"¡Bienvenido a Padel Land!",mensaje);
                    
                    if (form != null){
                        VistaUsuarioBasicoForm vistaUser = new VistaUsuarioBasicoForm(user);
                        vistaUser.pack();
                        vistaUser.setVisible(true);
                        vistaUser.setLocationRelativeTo(null);
                        vistaUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        this.dispose();
                        form.dispose();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error en el registro, revisa tus datos","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jButtonRegistroActionPerformed

    private void jTextFieldTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoKeyTyped
        // TODO add your handling code here:
        //Permitir solo la entrada de números
        if (!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldTelefonoKeyTyped

    private void jButtonElegirImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonElegirImagenActionPerformed
        // TODO add your handling code here:
        String path= null;
        //Elegimos una imagen y la seteamos en el label
        JFileChooser chooser = new JFileChooser();
        
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        //Extensión del archivo
        FileNameExtensionFilter extension =new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");     
        chooser.setFileFilter(extension);
        
        int filestate = chooser.showSaveDialog(null);
        
        //Comprobamos si el usuario ha seleccionado la imagen
        if (filestate == JFileChooser.APPROVE_OPTION){
            File selectedImage = chooser.getSelectedFile();
            path = selectedImage.getAbsolutePath();
            jLabelRutaImagen.setText("Imagen seleccionada");
            
            image_path = path;
        }
    }//GEN-LAST:event_jButtonElegirImagenActionPerformed

    private void jButtonQuitarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarImagenActionPerformed
        // TODO add your handling code here:
        image_path = null;
        jLabelRutaImagen.setText("");
    }//GEN-LAST:event_jButtonQuitarImagenActionPerformed

    private void jLabelIniciaSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIniciaSesionMouseClicked
        // TODO add your handling code here:
        Login login_form = new Login(form);
        login_form.setVisible(true);
        login_form.pack();
        login_form.setLocationRelativeTo(null);
        login_form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabelIniciaSesionMouseClicked

    private void jLabelIniciaSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIniciaSesionMouseEntered
        // TODO add your handling code here:
        Font font = jLabelIniciaSesion.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        jLabelIniciaSesion.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_jLabelIniciaSesionMouseEntered

    private void jLabelIniciaSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIniciaSesionMouseExited
        // TODO add your handling code here:
        Font font = jLabelIniciaSesion.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        jLabelIniciaSesion.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_jLabelIniciaSesionMouseExited

    //Se crea un método para verificar y validar los campos
    public boolean verifyFields() {
        String nombreCompleto = jTextFieldNombreCompleto.getText();
        String email = jTextFieldEmail.getText();
        String password = String.valueOf(jPasswordField.getPassword());
        String confirmPass = String.valueOf(jPasswordConfirmField.getPassword());
        String telefono = jTextFieldTelefono.getText();
        EmailValidator emailValidator = new EmailValidator();

        //Comprobar si hay campos vacíos
        if (nombreCompleto.trim().equals("") || email.trim().equals("") || password.trim().equals("")
                || confirmPass.trim().equals("") || telefono.trim().equals("")){
            JOptionPane.showMessageDialog(null, "Uno o varios campos están vacíos","Campos vacíos",JOptionPane.WARNING_MESSAGE);
            return false;
        }else if(!emailValidator.validate(email.trim())){
            JOptionPane.showMessageDialog(null, "No se cumple el formato de email","Email inválido",JOptionPane.WARNING_MESSAGE);
            return false;
        } //Comprobar que las contraseñas coincide
        else if (!password.equals(confirmPass)) {
            JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden","Confirmar contraseña",JOptionPane.WARNING_MESSAGE);
            return false;
        }else {
            return true;
        }
    }
    
    //Creamos una funcíon para comprobar si el usuario introducido ya existe en la BBDD
    public boolean checkEmail(String email) {
        boolean username_exists = false;
        
        if (userController.obtenerUsuarioPorEmail(email) != null){
            username_exists = true;
            JOptionPane.showMessageDialog(null, "Este usuario ya existe en la BBDD", "Email fallido",JOptionPane.ERROR_MESSAGE);
        }
        
        return username_exists;
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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonElegirImagen;
    private javax.swing.JButton jButtonQuitarImagen;
    private javax.swing.JButton jButtonRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelIniciaSesion;
    private javax.swing.JLabel jLabelRutaImagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordConfirmField;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNombreCompleto;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
