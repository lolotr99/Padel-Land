/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.admin.diasnodisponibles;

import controlador.DiasNoDisponiblesController;
import controlador.PropertiesController;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Properties;
import utilidades.RenderUtil;


/**
 *
 * @author Manolo
 */
public class ManageDiasNoDisponiblesForm extends javax.swing.JFrame {

    /**
     * Creates new form AdminDiasNoDisponiblesForm
     */
    PropertiesController propertiesController;
    Properties propertie;
    DefaultTableModel model;
    DiasNoDisponiblesController diasNoDisponiblesController;
    public ManageDiasNoDisponiblesForm() {
        initComponents();
        propertiesController = new PropertiesController();
        propertie = propertiesController.selectPropertieFromName("LIMITE_RESERVAS_SIMULTANEAS");
        jTextFieldNumeroReservasSimultaneas.setText(propertie.getValue());
        
        
        diasNoDisponiblesController = new DiasNoDisponiblesController();
        
        jTableDiasNoDisponibles.setDefaultRenderer(Object.class, new RenderUtil());
        model = new DefaultTableModel(null,new Object[]{"Id", "Día",""}){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }  
        };
        
        jTableDiasNoDisponibles.setModel(model);
        diasNoDisponiblesController.fillTableDiasNoDisponibles(jTableDiasNoDisponibles);
        
        jTableDiasNoDisponibles.setRowHeight(45);
        jTableDiasNoDisponibles.setGridColor(Color.yellow);
        jTableDiasNoDisponibles.setSelectionBackground(Color.cyan);
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
        jTextFieldNumeroReservasSimultaneas = new javax.swing.JTextField();
        jButtonAcutalizarReservasSimultaneas = new javax.swing.JButton();
        jButtonAddDiaNoDisponible = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDiasNoDisponibles = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de días no disponibles");

        jPanel1.setBackground(new java.awt.Color(23, 255, 108));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Número de reservas simúltaneas:");

        jTextFieldNumeroReservasSimultaneas.setEditable(false);

        jButtonAcutalizarReservasSimultaneas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAcutalizarReservasSimultaneas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-actualizar.png"))); // NOI18N
        jButtonAcutalizarReservasSimultaneas.setText("Modificar");
        jButtonAcutalizarReservasSimultaneas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcutalizarReservasSimultaneasActionPerformed(evt);
            }
        });

        jButtonAddDiaNoDisponible.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonAddDiaNoDisponible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-anadir.png"))); // NOI18N
        jButtonAddDiaNoDisponible.setText("Añadir un día no disponible");
        jButtonAddDiaNoDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddDiaNoDisponibleActionPerformed(evt);
            }
        });

        jTableDiasNoDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Dia", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDiasNoDisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableDiasNoDisponiblesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDiasNoDisponibles);
        if (jTableDiasNoDisponibles.getColumnModel().getColumnCount() > 0) {
            jTableDiasNoDisponibles.getColumnModel().getColumn(0).setResizable(false);
            jTableDiasNoDisponibles.getColumnModel().getColumn(1).setResizable(false);
            jTableDiasNoDisponibles.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAddDiaNoDisponible)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(jTextFieldNumeroReservasSimultaneas, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonAcutalizarReservasSimultaneas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNumeroReservasSimultaneas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonAcutalizarReservasSimultaneas)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAddDiaNoDisponible)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAcutalizarReservasSimultaneasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcutalizarReservasSimultaneasActionPerformed
        // TODO add your handling code here:
        ModifyReservasSimultaneas dialog = new ModifyReservasSimultaneas(this, rootPaneCheckingEnabled, propertie);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonAcutalizarReservasSimultaneasActionPerformed

    private void jButtonAddDiaNoDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddDiaNoDisponibleActionPerformed
        // TODO add your handling code here:
        AddDiaNoDisponibleForm form = new AddDiaNoDisponibleForm();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButtonAddDiaNoDisponibleActionPerformed

    private void jTableDiasNoDisponiblesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDiasNoDisponiblesMousePressed
        // TODO add your handling code here:
        int column = jTableDiasNoDisponibles.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/jTableDiasNoDisponibles.getRowHeight();
        if (column == 2) {
            Object value = jTableDiasNoDisponibles.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                diasNoDisponiblesController.fillTableDiasNoDisponibles(jTableDiasNoDisponibles);
                if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar el día "+ model.getValueAt(row,1).toString()+"?", "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    diasNoDisponiblesController.deleteDiaNoDisponible(diasNoDisponiblesController.selectDia(Long.valueOf(model.getValueAt(row,0).toString())));
                    jTableDiasNoDisponibles.setModel(new DefaultTableModel(null,new Object[]{"Id", "Día", ""}){
                        @Override
                        public boolean isCellEditable(int row, int column){
                            return false;
                        }  
                        });
                    diasNoDisponiblesController.fillTableDiasNoDisponibles(jTableDiasNoDisponibles);
                }
            }
        }
    }//GEN-LAST:event_jTableDiasNoDisponiblesMousePressed

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
            java.util.logging.Logger.getLogger(ManageDiasNoDisponiblesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageDiasNoDisponiblesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageDiasNoDisponiblesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageDiasNoDisponiblesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageDiasNoDisponiblesForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcutalizarReservasSimultaneas;
    private javax.swing.JButton jButtonAddDiaNoDisponible;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    protected static javax.swing.JTable jTableDiasNoDisponibles;
    protected static javax.swing.JTextField jTextFieldNumeroReservasSimultaneas;
    // End of variables declaration//GEN-END:variables
}
