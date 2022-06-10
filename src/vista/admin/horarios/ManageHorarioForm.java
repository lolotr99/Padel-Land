/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.admin.horarios;

import controlador.HorarioController;
import controlador.ReservaController;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import utilidades.ImagenFondo;
import vista.admin.users.AddUserForm;
/**
 *
 * @author Manolo
 */
public class ManageHorarioForm extends javax.swing.JFrame {

    /**
     * Creates new form AdminHorario
     */
    
    HorarioController horarioController;
    ReservaController reservaController;
    
    public ManageHorarioForm() {
        initComponents();
        horarioController = new HorarioController();
        reservaController = new ReservaController();
        horarioController.fillHorariosTable(jTableHorarios);
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHorarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Padel Land - Gestión de tramos horarios");
        setResizable(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-anadir.png"))); // NOI18N
        jButton1.setText("Añade un tramo horario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CONTROL DE TRAMOS HORARIOS:");

        jTableHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Turno", "Hora Comienzo", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableHorariosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableHorarios);
        if (jTableHorarios.getColumnModel().getColumnCount() > 0) {
            jTableHorarios.getColumnModel().getColumn(0).setResizable(false);
            jTableHorarios.getColumnModel().getColumn(1).setResizable(false);
            jTableHorarios.getColumnModel().getColumn(2).setResizable(false);
            jTableHorarios.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel1))
                        .addGap(0, 263, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableHorariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHorariosMousePressed
        // TODO add your handling code here:
        try{
            int column = jTableHorarios.getColumnModel().getColumnIndexAtX(evt.getX());
            int row = evt.getY()/jTableHorarios.getRowHeight();
            if (column == 3) {
                Object value = jTableHorarios.getValueAt(row, column);
                if (value instanceof JButton) {
                    ((JButton) value).doClick();
                    if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar el tramo horario de las "+ jTableHorarios.getModel().getValueAt(row,2)+"?", "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        if (reservaController.horarioTieneReservas(Long.valueOf(jTableHorarios.getModel().getValueAt(row,0).toString()))){
                            JOptionPane.showMessageDialog(null,"No se puede eliminar un horario que tiene reservas asociadas","¡NOO!",JOptionPane.ERROR_MESSAGE);
                        }else{
                            horarioController.deleteHorario(horarioController.selectHorario(Long.valueOf(jTableHorarios.getModel().getValueAt(row,0).toString())));
                            horarioController.fillHorariosTable(jTableHorarios);
                            JOptionPane.showMessageDialog(null,"Horario eliminado correctamente", "INFO",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        }catch(HeadlessException | NumberFormatException ex){
            Logger.getLogger(ManageHorarioForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }catch(Exception ex){
            Logger.getLogger(ManageHorarioForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTableHorariosMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AddHorarioForm addHF = new AddHorarioForm();
        addHF.setVisible(true);
        addHF.pack();
        addHF.setLocationRelativeTo(null);
        addHF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
            java.util.logging.Logger.getLogger(ManageHorarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageHorarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageHorarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageHorarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageHorarioForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    protected static javax.swing.JTable jTableHorarios;
    // End of variables declaration//GEN-END:variables
}
