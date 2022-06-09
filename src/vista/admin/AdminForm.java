/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.admin;

import vista.admin.users.ManageUserForm;
import javax.swing.JFrame;
import modelo.Usuarios;
import utilidades.ImagenFondo;
import vista.admin.diasnodisponibles.AddDiaNoDisponibleForm;
import vista.admin.diasnodisponibles.ManageDiasNoDisponiblesForm;
import vista.admin.horarios.AddHorarioForm;
import vista.admin.horarios.ManageHorarioForm;
import vista.admin.users.AddUserForm;
import vista.admin.pistas.AddPistaForm;
import vista.admin.pistas.ManagePistaForm;
import vista.admin.reservas.AddReservasForm;
import vista.admin.reservas.ManageReservasForm;


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
    ManageHorarioForm mhf;
    ManageDiasNoDisponiblesForm mdndf;
    ManageReservasForm mrf;
    Usuarios user;
    
    public AdminForm() {
        initComponents();
    }
    
    public AdminForm(Usuarios user) {
        this.user = user;
        initComponents();
        this.setTitle("Padel Land - Panel de Administrador | Logged ["+user.getEmail()+"]");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContent = new ImagenFondo();
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
        jMenuItemAddHorario = new javax.swing.JMenuItem();
        jMenuItemManageHorario = new javax.swing.JMenuItem();
        jMenuReservas = new javax.swing.JMenu();
        jMenuItemAddReserva = new javax.swing.JMenuItem();
        jMenuItemManageReserva = new javax.swing.JMenuItem();
        jMenuDiasNoDisponibles = new javax.swing.JMenu();
        jMenuItemAddDias = new javax.swing.JMenuItem();
        jMenuItemGestionDias = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Padel Land - Panel de Administrador");
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/logoSinFondo.png"))); // NOI18N

        jLabelBienvenida.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

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
                .addContainerGap(215, Short.MAX_VALUE))
        );

        jMenuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-users-menubar.png"))); // NOI18N
        jMenuUsuarios.setText("Usuarios");

        jMenuItemAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-crear.png"))); // NOI18N
        jMenuItemAddUser.setText("Añadir usuario");
        jMenuItemAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddUserActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(jMenuItemAddUser);

        jMenuItemManageUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-gestionar.png"))); // NOI18N
        jMenuItemManageUser.setText("Gestionar usuarios");
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
        jMenuItemAddPista.setText("Añadir pista");
        jMenuItemAddPista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddPistaActionPerformed(evt);
            }
        });
        jMenuPistas.add(jMenuItemAddPista);

        jMenuItemManagePista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-gestionar.png"))); // NOI18N
        jMenuItemManagePista.setText("Gestionar pistas");
        jMenuItemManagePista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemManagePistaActionPerformed(evt);
            }
        });
        jMenuPistas.add(jMenuItemManagePista);

        jMenuBar1.add(jMenuPistas);

        jMenuHorarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-horario-menubar.png"))); // NOI18N
        jMenuHorarios.setText("Horarios");

        jMenuItemAddHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-crear.png"))); // NOI18N
        jMenuItemAddHorario.setText("Añadir tramo horario");
        jMenuItemAddHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddHorarioActionPerformed(evt);
            }
        });
        jMenuHorarios.add(jMenuItemAddHorario);

        jMenuItemManageHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-gestionar.png"))); // NOI18N
        jMenuItemManageHorario.setText("Gestionar tramos horarios");
        jMenuItemManageHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemManageHorarioActionPerformed(evt);
            }
        });
        jMenuHorarios.add(jMenuItemManageHorario);

        jMenuBar1.add(jMenuHorarios);

        jMenuReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-reserva-menubar.png"))); // NOI18N
        jMenuReservas.setText("Reservas");

        jMenuItemAddReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-crear.png"))); // NOI18N
        jMenuItemAddReserva.setText("Añadir reservas");
        jMenuItemAddReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddReservaActionPerformed(evt);
            }
        });
        jMenuReservas.add(jMenuItemAddReserva);

        jMenuItemManageReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-gestionar.png"))); // NOI18N
        jMenuItemManageReserva.setText("Gestionar reservas");
        jMenuItemManageReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemManageReservaActionPerformed(evt);
            }
        });
        jMenuReservas.add(jMenuItemManageReserva);

        jMenuBar1.add(jMenuReservas);

        jMenuDiasNoDisponibles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-dianodisponible.png"))); // NOI18N
        jMenuDiasNoDisponibles.setText("Días no disponibles");

        jMenuItemAddDias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-crear.png"))); // NOI18N
        jMenuItemAddDias.setText("Añadir dias");
        jMenuItemAddDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddDiasActionPerformed(evt);
            }
        });
        jMenuDiasNoDisponibles.add(jMenuItemAddDias);

        jMenuItemGestionDias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-gestionar.png"))); // NOI18N
        jMenuItemGestionDias.setText("Gestionar días");
        jMenuItemGestionDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGestionDiasActionPerformed(evt);
            }
        });
        jMenuDiasNoDisponibles.add(jMenuItemGestionDias);

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

    private void jMenuItemManageHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemManageHorarioActionPerformed
        // TODO add your handling code here:
        mhf = new ManageHorarioForm();
        mhf.setVisible(true);
        mhf.pack();
        mhf.setLocationRelativeTo(null);
        mhf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItemManageHorarioActionPerformed

    private void jMenuItemAddHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddHorarioActionPerformed
        // TODO add your handling code here:
        AddHorarioForm addHF = new AddHorarioForm();
        addHF.setVisible(true);
        addHF.pack();
        addHF.setLocationRelativeTo(null);
        addHF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItemAddHorarioActionPerformed

    private void jMenuItemGestionDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGestionDiasActionPerformed
        // TODO add your handling code here:
        mdndf = new ManageDiasNoDisponiblesForm();
        mdndf.setVisible(true);
        mdndf.pack();
        mdndf.setLocationRelativeTo(null);
        mdndf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItemGestionDiasActionPerformed

    private void jMenuItemAddDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddDiasActionPerformed
        // TODO add your handling code here:
        AddDiaNoDisponibleForm form = new AddDiaNoDisponibleForm();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItemAddDiasActionPerformed

    private void jMenuItemAddReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddReservaActionPerformed
        // TODO add your handling code here:
        AddReservasForm arf = new AddReservasForm();
        arf.setVisible(true);
        arf.setLocationRelativeTo(null);
        arf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        arf.pack();
    }//GEN-LAST:event_jMenuItemAddReservaActionPerformed

    private void jMenuItemManageReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemManageReservaActionPerformed
        // TODO add your handling code here:
        mrf = new ManageReservasForm();
        mrf.setVisible(true);
        mrf.setLocationRelativeTo(null);
        mrf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mrf.pack();
    }//GEN-LAST:event_jMenuItemManageReservaActionPerformed

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
    private javax.swing.JMenuItem jMenuItemAddDias;
    private javax.swing.JMenuItem jMenuItemAddHorario;
    private javax.swing.JMenuItem jMenuItemAddPista;
    private javax.swing.JMenuItem jMenuItemAddReserva;
    private javax.swing.JMenuItem jMenuItemAddUser;
    private javax.swing.JMenuItem jMenuItemGestionDias;
    private javax.swing.JMenuItem jMenuItemManageHorario;
    private javax.swing.JMenuItem jMenuItemManagePista;
    private javax.swing.JMenuItem jMenuItemManageReserva;
    private javax.swing.JMenuItem jMenuItemManageUser;
    private javax.swing.JMenu jMenuPistas;
    private javax.swing.JMenu jMenuReservas;
    private javax.swing.JMenu jMenuUsuarios;
    private javax.swing.JPanel jPanelContent;
    // End of variables declaration//GEN-END:variables
}
