/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.auth;

import controlador.UsuarioController;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Usuarios;
import utilidades.CifradoUtil;
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
    
    public Registro() {
        initComponents();
        userController = new UsuarioController();
        //Centrar la pantalla
        this.setLocationRelativeTo(null);
        
        //Creamos un borde de color amarillo para el panel del título
        Border jPanelTitleBorder = BorderFactory.createMatteBorder(0,1,1,1,Color.YELLOW);
        jPanelTitle.setBorder(jPanelTitleBorder);
        
        //Se crea otro borde de color negro para los JLabel de cerrar y minimizar
        Border jLabelBorder = BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK);
        jLabelCerrar.setBorder(jLabelBorder);
        jLabelMinimizar.setBorder(jLabelBorder);
        
        //Se crea un borde para el label de iniciar sesion
        Border label_login_account_border = BorderFactory.createMatteBorder(0,0,1,0,Color.lightGray);
        jLabelIniciaSesion.setBorder(label_login_account_border);
        
        //Se crea un borde para los campos del formulario
        Border field_border = BorderFactory.createMatteBorder(1,5,1,1,Color.white);
        jTextFieldNombreCompleto.setBorder(field_border);
        jTextFieldUserName.setBorder(field_border);
        jPasswordField.setBorder(field_border);
        jPasswordConfirmField.setBorder(field_border);
        jTextFieldTelefono.setBorder(field_border);
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
        jButtonRegistro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNombreCompleto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUserName = new javax.swing.JTextField();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 51));

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

        jPanelTitle.setBackground(new java.awt.Color(0, 84, 140));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registro");

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTitleLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(21, 21, 21))
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
                .addGap(108, 108, 108)
                .addComponent(jLabelMinimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCerrar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelMinimizar)
                            .addComponent(jLabelCerrar)))
                    .addComponent(jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonRegistro.setBackground(new java.awt.Color(235, 47, 6));
        jButtonRegistro.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        jButtonRegistro.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistro.setText("Registro");
        jButtonRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonRegistroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonRegistroMouseExited(evt);
            }
        });
        jButtonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nombre Completo:");

        jTextFieldNombreCompleto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nombre Usuario:");

        jTextFieldUserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

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
        jLabelRutaImagen.setText("Ruta de imagen");

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
        jLabelIniciaSesion.setForeground(new java.awt.Color(0, 204, 51));
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jPasswordConfirmField, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(jTextFieldUserName)
                                    .addComponent(jTextFieldNombreCompleto)))
                            .addComponent(jButtonQuitarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(83, 83, 83))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRutaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonElegirImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelIniciaSesion)
                .addGap(180, 180, 180))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                .addGap(26, 26, 26)
                .addComponent(jButtonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelIniciaSesion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

    private void jLabelMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizarMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinimizarMouseClicked

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

    private void jLabelCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCerrarMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabelCerrarMouseClicked

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

    private void jButtonRegistroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegistroMouseEntered
        // TODO add your handling code here:
        //Seteamos el background del jbutton
        jButtonRegistro.setBackground(new Color(235,47,6));
    }//GEN-LAST:event_jButtonRegistroMouseEntered

    private void jButtonRegistroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegistroMouseExited
        // TODO add your handling code here:
        //Seteamos el background del jbutton
        jButtonRegistro.setBackground(new Color(0,84,104));
    }//GEN-LAST:event_jButtonRegistroMouseExited

    private void jButtonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroActionPerformed
        // TODO add your handling code heres
        String username = jTextFieldUserName.getText();
        if (verifyFields()){
            if (!checkUsername(username)){
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
                    user = new Usuarios(nombreCompleto, username, password, telefono, imageBlob, rol, null);
                }else{
                    user = new Usuarios(nombreCompleto, username, password, telefono, rol);
                }
                long result = userController.insertUsuario(user);
                if (result != 0){
                    JOptionPane.showMessageDialog(null, "¡Tu usuario ha sido creado correctamente!");
                }else{
                    JOptionPane.showMessageDialog(null, "Error en el registro, revisa tus datos");
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
        FileNameExtensionFilter extension = new FileNameExtensionFilter("*Images","jpg", "png", "jpeg");
        chooser.addChoosableFileFilter(extension);
        
        int filestate = chooser.showSaveDialog(null);
        
        //Comprobamos si el usuario ha seleccionado la imagen
        if (filestate == JFileChooser.APPROVE_OPTION){
            File selectedImage = chooser.getSelectedFile();
            path = selectedImage.getAbsolutePath();
            jLabelRutaImagen.setText(path);
            
            image_path = path;
        }
    }//GEN-LAST:event_jButtonElegirImagenActionPerformed

    private void jButtonQuitarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarImagenActionPerformed
        // TODO add your handling code here:
        image_path = null;
        jLabelRutaImagen.setText("Ruta de imagen");
    }//GEN-LAST:event_jButtonQuitarImagenActionPerformed

    private void jLabelIniciaSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIniciaSesionMouseClicked
        // TODO add your handling code here:
        Login login_form = new Login();
        login_form.setVisible(true);
        login_form.pack();
        login_form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabelIniciaSesionMouseClicked

    private void jLabelIniciaSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIniciaSesionMouseEntered
        // TODO add your handling code here:
        Border label_border = BorderFactory.createMatteBorder(0,0,1,0,new Color(0,204,0));
        jLabelIniciaSesion.setBorder(label_border);
    }//GEN-LAST:event_jLabelIniciaSesionMouseEntered

    private void jLabelIniciaSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIniciaSesionMouseExited
        // TODO add your handling code here:
        //Se crea un borde para el label de crear cuenta
        Border label_create_account_border = BorderFactory.createMatteBorder(0,0,1,0,Color.lightGray);
        jLabelIniciaSesion.setBorder(label_create_account_border);
    }//GEN-LAST:event_jLabelIniciaSesionMouseExited

    //Se crea un método para verificar y validar los campos
    public boolean verifyFields() {
        String nombreCompleto = jTextFieldNombreCompleto.getText();
        String username = jTextFieldUserName.getText();
        String password = String.valueOf(jPasswordField.getPassword());
        String confirmPass = String.valueOf(jPasswordConfirmField.getPassword());
        String telefono = jTextFieldTelefono.getText();
        
        //Comprobar si hay campos vacíos
        if (nombreCompleto.trim().equals("") || username.trim().equals("") || password.trim().equals("")
                || confirmPass.trim().equals("") || telefono.trim().equals("")){
            JOptionPane.showMessageDialog(null, "Uno o varios campos están vacíos","Campos vacíos",2);
            return false;
        } //Comprobar que las contraseñas coincide
        else if (!password.equals(confirmPass)) {
            JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden","Confirmar contraseña",2);
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
    private javax.swing.JLabel jLabelCerrar;
    private javax.swing.JLabel jLabelIniciaSesion;
    private javax.swing.JLabel jLabelMinimizar;
    private javax.swing.JLabel jLabelRutaImagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JPasswordField jPasswordConfirmField;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldNombreCompleto;
    private javax.swing.JTextField jTextFieldTelefono;
    private javax.swing.JTextField jTextFieldUserName;
    // End of variables declaration//GEN-END:variables
}
