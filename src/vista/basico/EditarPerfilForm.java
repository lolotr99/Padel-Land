/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.basico;

import controlador.UsuarioController;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.Usuarios;
import utilidades.CifradoUtil;
import vista.admin.users.AddUserForm;
import vista.admin.users.ManageUserForm;
import static vista.basico.MiPerfilForm.imgUsuario;

/**
 *
 * @author Manolo
 */
public class EditarPerfilForm extends javax.swing.JFrame {

    
    private Usuarios user;
    private String img_path = null;
    private UsuarioController userController;
    /**
     * Creates new form EditarPerfilForm
     */
    public EditarPerfilForm() {
        initComponents();
    }
    
    public EditarPerfilForm(Usuarios usuario) {
        initComponents();
        this.user = usuario;
        userController = new UsuarioController();
        rellenarCamposFormulario();
    }
    
    public void rellenarCamposFormulario() {
        jTextFieldNombreCompleto.setText(user.getNombreCompleto());
        jTextFieldNombreUsuario.setText(user.getUsername());
        jTextFieldTelefono.setText(user.getTelefono());
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNombreCompleto = new javax.swing.JTextField();
        jTextFieldNombreUsuario = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jButtonElegirImagen = new javax.swing.JButton();
        jButtonQuitarImagen = new javax.swing.JButton();
        jLabelRutaImagen = new javax.swing.JLabel();
        jButtonAnadir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(23, 255, 108));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setText("Editar perfil");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre completo:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nombre usuario:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nueva contraseña:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nº de teléfono:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Imagen usuario:");

        jTextFieldTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoKeyTyped(evt);
            }
        });

        jButtonElegirImagen.setText("Elegir");
        jButtonElegirImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonElegirImagenActionPerformed(evt);
            }
        });

        jButtonQuitarImagen.setText("Quitar");
        jButtonQuitarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitarImagenActionPerformed(evt);
            }
        });

        jLabelRutaImagen.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N

        jButtonAnadir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAnadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-actualizar.png"))); // NOI18N
        jButtonAnadir.setText("Editar");
        jButtonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabelRutaImagen))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(jTextFieldNombreCompleto, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(jPasswordField)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonElegirImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonQuitarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 167, Short.MAX_VALUE)
                .addComponent(jButtonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonElegirImagen)
                            .addComponent(jButtonQuitarImagen)
                            .addComponent(jLabel6))))
                .addGap(35, 35, 35)
                .addComponent(jLabelRutaImagen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
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

    private void jTextFieldTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoKeyTyped
        if (!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_jTextFieldTelefonoKeyTyped

    private void jButtonElegirImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonElegirImagenActionPerformed
        // TODO add your handling code here:
        String path= null;
        //Elegimos una imagen y la seteamos en el label
        JFileChooser chooser = new JFileChooser();

        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        //Extensión del archivo
        FileNameExtensionFilter extension = new FileNameExtensionFilter("*Images","jpg", "png", "jpeg");
        chooser.addChoosableFileFilter(extension);

        int filestate = chooser.showSaveDialog(null);

        //Comprobamos si el usuario ha seleccionado la imagen
        if (filestate == JFileChooser.APPROVE_OPTION){
            File selectedImage = chooser.getSelectedFile();
            path = selectedImage.getAbsolutePath();
            jLabelRutaImagen.setText(path);

            img_path = path;
        }
    }//GEN-LAST:event_jButtonElegirImagenActionPerformed

    private void jButtonQuitarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarImagenActionPerformed
        // TODO add your handling code here:
        img_path = null;
        jLabelRutaImagen.setText("");
    }//GEN-LAST:event_jButtonQuitarImagenActionPerformed

    private void jButtonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirActionPerformed
        // TODO add your handling code here:
        if (verifyFields()){
            user.setUsername(jTextFieldNombreUsuario.getText());
            user.setNombreCompleto(jTextFieldNombreCompleto.getText());
            if(jPasswordField.getPassword() != null && jPasswordField.getPassword().length != 0){
                user.setPassword(CifradoUtil.getHash(String.valueOf(jPasswordField.getPassword())));
            }
            user.setTelefono(jTextFieldTelefono.getText());
            if (img_path != null && !img_path.equals("")){
                File file = new File(img_path);
                Blob imageBlob = null;
                try {
                    FileInputStream fis = new FileInputStream(file);
                    imageBlob = userController.obtenerBlob(fis, file);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AddUserForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AddUserForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                user.setImagenUsuario(imageBlob);
            }
            
            userController.updateUsuario(user);
            JOptionPane.showMessageDialog(null, "¡Tu usuario ha sido actualizado correctamente!");
            actualizarCamposPerfil();
        }
    }//GEN-LAST:event_jButtonAnadirActionPerformed

    public void actualizarCamposPerfil() {
        MiPerfilForm.jLabelNombreUsuario.setText(user.getUsername());
        MiPerfilForm.jLabelNombreCompleto.setText(user.getNombreCompleto());
        MiPerfilForm.jLabelNTelefono.setText(user.getTelefono());
        
        if (user.getImagenUsuario() != null){
            BufferedImage img = null;
            Blob blob = user.getImagenUsuario();
            byte[] data;
            try {
                data = blob.getBytes(1, (int)blob.length());
                img = ImageIO.read(new ByteArrayInputStream(data));
                imgUsuario.setIcon(new ImageIcon(img.getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
            } catch (IOException | SQLException | NullPointerException ex) {
                Logger.getLogger(MiPerfilForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //Se crea un método para verificar y validar los campos
    public boolean verifyFields() {
        String nombreCompleto = jTextFieldNombreCompleto.getText();
        String username = jTextFieldNombreUsuario.getText();
        String telefono = jTextFieldTelefono.getText();
        
        //Comprobar si hay campos vacíos
        if (nombreCompleto.trim().equals("") || username.trim().equals("") || telefono.trim().equals("")){
            JOptionPane.showMessageDialog(null, "Uno o varios campos están vacíos","Campos vacíos",2);
            return false;
        }else {
            return true;
        }
    }

    //Creamos una funcíon para comprobar si el usuario introducido ya existe en la BBDD
    public boolean checkUsername(String username) {
        boolean username_exists = false;
        
        if (userController.obtenerUsuarioPorUserName(username) != null){
            username_exists = true;
            JOptionPane.showMessageDialog(null, "Este usuario ya existe en la BBDD", "Nombre de usuario fallido",2);
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
            java.util.logging.Logger.getLogger(EditarPerfilForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarPerfilForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarPerfilForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarPerfilForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarPerfilForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnadir;
    private javax.swing.JButton jButtonElegirImagen;
    private javax.swing.JButton jButtonQuitarImagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelRutaImagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldNombreCompleto;
    private javax.swing.JTextField jTextFieldNombreUsuario;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
