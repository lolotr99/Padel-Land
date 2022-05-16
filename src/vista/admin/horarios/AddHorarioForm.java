/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.admin.horarios;

import controlador.HorarioController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import modelo.Horarios;

/**
 *
 * @author Manolo
 */
public class AddHorarioForm extends javax.swing.JFrame {

    /**
     * Creates new form AddHorarioForm
     */
    HorarioController horarioController;
    public AddHorarioForm() {
        initComponents();
        horarioController = new HorarioController();
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
        jButtonCancelar = new javax.swing.JButton();
        jButtonAnadir = new javax.swing.JButton();
        Date date = new Date();
        SpinnerDateModel sm =
        new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
        jSpinner1 = new javax.swing.JSpinner(sm);
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Añadir Horario");

        jPanel1.setBackground(new java.awt.Color(23, 255, 108));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setText("Nuevo Tramo Horario");

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-borrar.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonAnadir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAnadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-anadir.png"))); // NOI18N
        jButtonAnadir.setText("Añadir");
        jButtonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirActionPerformed(evt);
            }
        });

        JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinner1, "HH:mm");
        jSpinner1.setEditor(de);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Hora de comienzo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAnadir, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jSpinner1))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
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

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirActionPerformed
        // TODO add your handling code here
        Object value = jSpinner1.getValue();
        if (value instanceof Date){
            Date horaComienzo = (Date)value;
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            String time = format.format(horaComienzo);
            if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres insertar el tramo horario: "+time+"?", "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                //Se comprueba que ese tramo horario no exista ya
                if (!checkHorario(horaComienzo)){
                    try {
                        Date horaCambioTurno = format.parse("14:00");
                        String turno = "";
                        if (horaComienzo.before(horaCambioTurno) || horaComienzo.equals(horaCambioTurno)){
                            turno = "mañana";
                        } else{
                            turno = "tarde";
                        }
                        
                        Horarios horario = new Horarios(turno, horaComienzo);
                        long result = horarioController.insertarHorario(horario);
                        if (result != 0){
                            JOptionPane.showMessageDialog(null, "¡Tu tramo horario ha sido creado correctamente!");
                        }else{
                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en el registro, revisa tus datos.");
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(AddHorarioForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } 
        } else{
            JOptionPane.showMessageDialog(null, "Introduce una hora válida (HH:mm) ", "Formato incorrecto",2);
        }
        
        if (ManageHorarioForm.jTableHorarios != null){
            ManageHorarioForm.jTableHorarios.setModel(new DefaultTableModel(null,new Object[]{"Id", "Turno", "Hora Comienzo", ""}){
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }  
            });
            horarioController.fillHorariosTable(ManageHorarioForm.jTableHorarios);
        }
        
    }//GEN-LAST:event_jButtonAnadirActionPerformed

    //Creamos una funcíon para comprobar si el horario introducido ya existe en la BBDD
    public boolean checkHorario(Date horario) {
        boolean horario_exists = false;
        
        if (horarioController.getHorarioByHoraComienzo(horario) != null){
            horario_exists = true;
            JOptionPane.showMessageDialog(null, "Este tramo horario ya existe en la BBDD", "Horario fallido",2);
        }
        
        return horario_exists;
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
            java.util.logging.Logger.getLogger(AddHorarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddHorarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddHorarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddHorarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddHorarioForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnadir;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}