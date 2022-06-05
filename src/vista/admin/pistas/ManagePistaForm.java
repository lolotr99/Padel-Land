/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.admin.pistas;

import com.sun.glass.events.KeyEvent;
import controlador.PistaController;
import controlador.ReservaController;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Pistas;
import utilidades.ImagenFondo;

/**
 *
 * @author Manolo
 */
public class ManagePistaForm extends javax.swing.JFrame {

    /**
     * Creates new form ManageUserForm
     */
    String img_path = null;
    PistaController pistaController;
    ReservaController reservaController;
    
    public ManagePistaForm() {
        initComponents();
        pistaController = new PistaController();
        reservaController = new ReservaController();
        pistaController.fillPistasJTable(jTablePistas, jTextFieldValorBusqueda.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new ImagenFondo();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNombrePista = new javax.swing.JTextField();
        jButtonAnadir = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePistas = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldValorBusqueda = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButtonElegirImagen = new javax.swing.JButton();
        jButtonQuitarImagen = new javax.swing.JButton();
        jLabelRutaImagen = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Padel Land - Gestion de Pistas");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setText("Gestionar Pistas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre pista:");

        jButtonAnadir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAnadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-anadir.png"))); // NOI18N
        jButtonAnadir.setText("Añadir");
        jButtonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirActionPerformed(evt);
            }
        });

        jButtonEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-borrar.png"))); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonActualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-actualizar.png"))); // NOI18N
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTablePistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre de pista"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePistas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablePistasMousePressed(evt);
            }
        });
        jTablePistas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTablePistasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePistas);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Valor de búsqueda:");

        jTextFieldValorBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldValorBusquedaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldValorBusquedaKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Imagen pista:");

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Id:");

        jTextFieldId.setEditable(false);

        jLabel3.setText("(Doble click en la fila para ver imagen de la pista)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRutaImagen)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButtonElegirImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33)
                                    .addComponent(jButtonQuitarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextFieldId)
                                .addComponent(jTextFieldNombrePista)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldValorBusqueda)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldNombrePista, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldValorBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jButtonElegirImagen)
                            .addComponent(jButtonQuitarImagen))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelRutaImagen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirActionPerformed
        // TODO add your handling code here:
        AddPistaForm addPF = new AddPistaForm();
        addPF.setVisible(true);
        addPF.pack();
        addPF.setLocationRelativeTo(null);
        addPF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButtonAnadirActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
        String id = jTextFieldId.getText();
        if (id.equals("")){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna pista","WARNING", JOptionPane.WARNING_MESSAGE);
        }else{
            Pistas pista = pistaController.selectPista(Integer.valueOf(id));
            if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar la pista '"+pista.getNombrePista()+"' ?","WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (reservaController.pistaTieneReservas(Long.valueOf(id))){
                    JOptionPane.showMessageDialog(null,"No se puede eliminar una pista que tiene reservas asociadas","¡NOO!",JOptionPane.ERROR_MESSAGE);
                }else{
                    pistaController.deletePista(pista);
                    pistaController.fillPistasJTable(jTablePistas, jTextFieldValorBusqueda.getText());
                    limpiarCampos();
                }
            }
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jTextFieldValorBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorBusquedaKeyPressed
        // TODO add your handling code here:
        pistaController.fillPistasJTable(jTablePistas, jTextFieldValorBusqueda.getText());
        
    }//GEN-LAST:event_jTextFieldValorBusquedaKeyPressed

    private void jTextFieldValorBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorBusquedaKeyReleased
        // TODO add your handling code here:
        pistaController.fillPistasJTable(jTablePistas, jTextFieldValorBusqueda.getText());
    }//GEN-LAST:event_jTextFieldValorBusquedaKeyReleased

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        // TODO add your handling code here:
        if (!jTextFieldId.getText().trim().equals("")){
            String nombrePista = jTextFieldNombrePista.getText();
            Pistas pista = pistaController.selectPista(Integer.valueOf(jTextFieldId.getText()));
                   
            pista.setNombrePista(nombrePista);
            
            if (img_path != null && !img_path.equals("")){
                File file = new File(img_path);
                Blob imageBlob = null;
            
                try {
                    FileInputStream fis = new FileInputStream(file);
                    imageBlob = pistaController.obtenerBlob(fis, file);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ManagePistaForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ManagePistaForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                pista.setImagenPista(imageBlob);
            }
            
            pistaController.updatePista(pista);
            JOptionPane.showMessageDialog(null, "Pista modificada correctamente","INFO",JOptionPane.INFORMATION_MESSAGE);
            pistaController.fillPistasJTable(jTablePistas, "");
        } else{
            JOptionPane.showMessageDialog(null,"No se ha seleccionado ninguna pista","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonActualizarActionPerformed

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
            
            img_path = path;
        }
    }//GEN-LAST:event_jButtonElegirImagenActionPerformed

    private void jButtonQuitarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarImagenActionPerformed
        // TODO add your handling code here:
        img_path = null;
        jLabelRutaImagen.setText("");
    }//GEN-LAST:event_jButtonQuitarImagenActionPerformed

    private void jTablePistasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablePistasKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_ENTER){
            int rowIndex = jTablePistas.getSelectedRow();
            jTextFieldId.setText(jTablePistas.getModel().getValueAt(rowIndex, 0).toString());
            jTextFieldNombrePista.setText(jTablePistas.getModel().getValueAt(rowIndex,1).toString());
        }
    }//GEN-LAST:event_jTablePistasKeyReleased

    private void jTablePistasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePistasMousePressed
        // TODO add your handling code here:
         JTable table =(JTable) evt.getSource();
         Point point = evt.getPoint();
         int fila = table.rowAtPoint(point);
         if (evt.getClickCount() == 2 && table.getSelectedRow() != -1) {
            try {
                pistaController.verImagenPista(pistaController.selectPista(Long.valueOf(jTablePistas.getModel().getValueAt(fila,0).toString())));
            } catch (IOException ex) {
                Logger.getLogger(PistaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PistaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        jTextFieldId.setText(jTablePistas.getModel().getValueAt(fila, 0).toString());
        jTextFieldNombrePista.setText(jTablePistas.getModel().getValueAt(fila,1).toString());
    }//GEN-LAST:event_jTablePistasMousePressed

    
    
    public void limpiarCampos() {
        jTextFieldId.setText("");
        jTextFieldNombrePista.setText("");
        img_path = null;
        jLabelRutaImagen.setText("");
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
            java.util.logging.Logger.getLogger(ManagePistaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagePistaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagePistaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagePistaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagePistaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonAnadir;
    private javax.swing.JButton jButtonElegirImagen;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonQuitarImagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelRutaImagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTablePistas;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNombrePista;
    private javax.swing.JTextField jTextFieldValorBusqueda;
    // End of variables declaration//GEN-END:variables
}
