/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.admin;

import vista.admin.users.ManageUserForm;
import javax.swing.JFrame;
import vista.admin.users.AddUserForm;
import vista.admin.pistas.AddPistaForm;
import vista.admin.pistas.ManagePistaForm;


/**
 *
 * @author Manolo
 */
public class AdminForm extends javax.swing.JFrame {

    /**
     * Creates new form AdminForm
     */
    ManageUserForm muf;
    ManagePistaForm mpf;
    
    public AdminForm() {
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

        jPanelContent = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelBienvenida = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuUsuarios = new javax.swing.JMenu();
        jMenuItemAddUser = new javax.swing.JMenuItem();
        jMenuItemManageUser = new javax.swing.JMenuItem();
        jMenuPistas = new javax.swing.JMenu();
        jMenuItemAddPista = new javax.swing.JMenuItem();
        jMenuItemManagePista = new javax.swing.JMenuItem();
        jMenuHorarios = new javax.swing.JMenu();
        jMenuReservas = new javax.swing.JMenu();
        jMenuDiasNoDisponibles = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel de Administrador");
        setResizable(false);

        jPanelContent.setBackground(new java.awt.Color(23, 255, 108));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/logo-color.png"))); // NOI18N

        jLabelBienvenida.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelBienvenida.setText("<html><body>¡Bienvenido <####>! <br>Esta es la vista de Administrador de Padel Land</body></html>");

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContentLayout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelContentLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabelBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(jLabelBienvenida)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        jMenuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-users-menubar.png"))); // NOI18N
        jMenuUsuarios.setText("Usuarios");

        jMenuItemAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-crear.png"))); // NOI18N
        jMenuItemAddUser.setText("Añadir");
        jMenuItemAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddUserActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(jMenuItemAddUser);

        jMenuItemManageUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-gestionar.png"))); // NOI18N
        jMenuItemManageUser.setText("Gestionar");
        jMenuItemManageUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemManageUserActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(jMenuItemManageUser);

        jMenuBar1.add(jMenuUsuarios);

        jMenuPistas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-pistas-menubar.png"))); // NOI18N
        jMenuPistas.setText("Pistas");

        jMenuItemAddPista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-crear.png"))); // NOI18N
        jMenuItemAddPista.setText("Añadir");
        jMenuItemAddPista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddPistaActionPerformed(evt);
            }
        });
        jMenuPistas.add(jMenuItemAddPista);

        jMenuItemManagePista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-gestionar.png"))); // NOI18N
        jMenuItemManagePista.setText("Gestionar");
        jMenuItemManagePista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemManagePistaActionPerformed(evt);
            }
        });
        jMenuPistas.add(jMenuItemManagePista);

        jMenuBar1.add(jMenuPistas);

        jMenuHorarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-horario-menubar.png"))); // NOI18N
        jMenuHorarios.setText("Horarios");
        jMenuBar1.add(jMenuHorarios);

        jMenuReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-reserva-menubar.png"))); // NOI18N
        jMenuReservas.setText("Reservas");
        jMenuBar1.add(jMenuReservas);

        jMenuDiasNoDisponibles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-dianodisponible.png"))); // NOI18N
        jMenuDiasNoDisponibles.setText("Días no disponibles");
        jMenuBar1.add(jMenuDiasNoDisponibles);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddUserActionPerformed
        // TODO add your handling code here:
        AddUserForm addUF = new AddUserForm();
        addUF.setVisible(true);
        addUF.pack();
        addUF.setLocationRelativeTo(null);
        addUF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItemAddUserActionPerformed

    private void jMenuItemManageUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemManageUserActionPerformed
        // TODO add your handling code here:
        muf = new ManageUserForm();
        muf.setVisible(true);
        muf.pack();
        muf.setLocationRelativeTo(null);
        muf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItemManageUserActionPerformed

    private void jMenuItemAddPistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddPistaActionPerformed
        // TODO add your handling code here:
        AddPistaForm addPF = new AddPistaForm();
        addPF.setVisible(true);
        addPF.pack();
        addPF.setLocationRelativeTo(null);
        addPF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItemAddPistaActionPerformed

    private void jMenuItemManagePistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemManagePistaActionPerformed
        // TODO add your handling code here:
        mpf = new ManagePistaForm();
        mpf.setVisible(true);
        mpf.pack();
        mpf.setLocationRelativeTo(null);
        mpf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItemManagePistaActionPerformed

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
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabelBienvenida;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuDiasNoDisponibles;
    private javax.swing.JMenu jMenuHorarios;
    private javax.swing.JMenuItem jMenuItemAddPista;
    private javax.swing.JMenuItem jMenuItemAddUser;
    private javax.swing.JMenuItem jMenuItemManagePista;
    private javax.swing.JMenuItem jMenuItemManageUser;
    private javax.swing.JMenu jMenuPistas;
    private javax.swing.JMenu jMenuReservas;
    private javax.swing.JMenu jMenuUsuarios;
    private javax.swing.JPanel jPanelContent;
    // End of variables declaration//GEN-END:variables
}
