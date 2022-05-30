/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.basico;

import controlador.PropertiesController;
import controlador.ReservaController;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Properties;
import modelo.Usuarios;
import vista.auth.Login;

/**
 *
 * @author Manolo
 */
public class VistaUsuarioBasicoForm extends javax.swing.JFrame {

    /**
     * Creates new form VistaUsuarioBasicoForm
     */
    
    Usuarios user;
    ReservaController reservaController;
    PropertiesController propertieController;
    
    public VistaUsuarioBasicoForm() {
        initComponents();
    }
    
    public VistaUsuarioBasicoForm(Usuarios usuario) {
        this.user = usuario;
        reservaController = new ReservaController();
        propertieController = new PropertiesController();
        initComponents();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuVerPistas = new javax.swing.JMenu();
        jMenuReservar = new javax.swing.JMenu();
        jMenuMiPerfil = new javax.swing.JMenu();
        jMenuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vista de usuario");

        jPanel1.setBackground(new java.awt.Color(23, 255, 108));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
        );

        jMenuVerPistas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-pistas-menubar.png"))); // NOI18N
        jMenuVerPistas.setText("Ver Pistas");
        jMenuVerPistas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuVerPistasMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuVerPistas);

        jMenuReservar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-reserva-menubar.png"))); // NOI18N
        jMenuReservar.setText("Reservar");
        jMenuReservar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuReservarMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuReservar);

        jMenuMiPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icons8-configuración-del-administrador-40.png"))); // NOI18N
        jMenuMiPerfil.setText("Ver Perfil");
        jMenuMiPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuMiPerfilMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuMiPerfil);

        jMenuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-salir.png"))); // NOI18N
        jMenuSalir.setText("Cerrar");
        jMenuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSalir);

        setJMenuBar(jMenuBar1);

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

    private void jMenuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSalirMouseClicked
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir? ", "Confirmación de cierre de ventana",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            Login form = new Login();
            form.setVisible(true);
            form.setLocationRelativeTo(null);
            form.pack();
            this.dispose();
        }
    }//GEN-LAST:event_jMenuSalirMouseClicked

    private void jMenuMiPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuMiPerfilMouseClicked
        // TODO add your handling code here:
        MiPerfilForm form = new MiPerfilForm(user);
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuMiPerfilMouseClicked

    private void jMenuVerPistasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuVerPistasMouseClicked
        // TODO add your handling code here:
        VerPistasForm form = new VerPistasForm();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuVerPistasMouseClicked

    private void jMenuReservarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuReservarMouseClicked
        // TODO add your handling code here:
        
        SimpleDateFormat formatoDia = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm"); 
        
        String dia = formatoDia.format(new Date());
        String hora = formatoHora.format(new Date());
       
        Properties propertie = propertieController.selectPropertieFromName("LIMITE_RESERVAS_SIMULTANEAS");
        int nReservasSimultaneasUsuario = reservaController.getNumeroReservasSimultaneasUsuario(user.getId(), dia, hora);
        
        if (Integer.valueOf(propertie.getValue()) <= nReservasSimultaneasUsuario) {
            //No se permite la reserva porque ya ha llegado al límite simultaneo
            JOptionPane.showMessageDialog(null,"Este usuario ya ha excedido el número de reservas simultáneas (3). ¡Vuelve cuando ya hayas jugado algún partido!","¡Noo!",JOptionPane.WARNING_MESSAGE);
        }else{
            ReservaForm form = new ReservaForm(user);
            form.setVisible(true);
            form.pack();
            form.setLocationRelativeTo(null);
            form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jMenuReservarMouseClicked

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
            java.util.logging.Logger.getLogger(VistaUsuarioBasicoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaUsuarioBasicoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaUsuarioBasicoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaUsuarioBasicoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaUsuarioBasicoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuMiPerfil;
    private javax.swing.JMenu jMenuReservar;
    private javax.swing.JMenu jMenuSalir;
    private javax.swing.JMenu jMenuVerPistas;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
