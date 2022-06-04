/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.admin.reservas;

import controlador.HorarioController;
import controlador.PistaController;
import controlador.ReservaController;
import controlador.UsuarioController;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Reservas;
import utilidades.Mailer;
import utilidades.RenderUtil;

/**
 *
 * @author Manolo
 */
public class ManageReservasForm extends javax.swing.JFrame {

    DefaultTableModel model;
    ReservaController reservaController;
    HorarioController horarioController; 
    PistaController pistaController;
    UsuarioController usuarioController;
    
    /**
     * Creates new form ManageReservasForm
     */
    public ManageReservasForm() {
        reservaController = new ReservaController();
        horarioController = new HorarioController();
        pistaController = new PistaController();
        usuarioController = new UsuarioController();
        initComponents();
        fillTablaReservasFiltro(jTableReservas,"","","");
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
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReservas = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jDateChooserFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jDateChooserFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jButtonFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de reservas");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(23, 255, 108));

        jPanel4.setBackground(new java.awt.Color(23, 255, 108));

        jTableReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cliente", "Pista", "Horario", "Dia", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableReservasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableReservas);
        if (jTableReservas.getColumnModel().getColumnCount() > 0) {
            jTableReservas.getColumnModel().getColumn(0).setResizable(false);
            jTableReservas.getColumnModel().getColumn(1).setResizable(false);
            jTableReservas.getColumnModel().getColumn(2).setResizable(false);
            jTableReservas.getColumnModel().getColumn(3).setResizable(false);
            jTableReservas.getColumnModel().getColumn(4).setResizable(false);
            jTableReservas.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton2.setText("Añade reserva");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Fecha Inicio");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Fecha Fin");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Email usuario");

        jButtonFiltrar.setText("Buscar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jDateChooserFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooserFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jDateChooserFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(4, 4, 4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AddReservasForm arf = new AddReservasForm();
        arf.setVisible(true);
        arf.setLocationRelativeTo(null);
        arf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        arf.pack();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTableReservasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableReservasMousePressed
        // TODO add your handling code here:
        int column = jTableReservas.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/jTableReservas.getRowHeight();
        if (column == 5){
            //Eliminar
            Object value = jTableReservas.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                fillTablaReservasFiltro(jTableReservas,"","","");
                String mensaje = "¿Seguro que quieres eliminar la reserva de las "+ jTableReservas.getModel().getValueAt(row,3)+" el día "
                        + jTableReservas.getModel().getValueAt(row,4) + " para el cliente "+ jTableReservas.getModel().getValueAt(row,1) 
                        + " en la pista " + jTableReservas.getModel().getValueAt(row, 2) + "?";
                if (JOptionPane.showConfirmDialog(null, mensaje, "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    Reservas reserva = reservaController.selectReserva(Long.valueOf(jTableReservas.getModel().getValueAt(row,0).toString()));
                    String email = usuarioController.selectUsuario(reserva.getUsuarios().getId()).getEmail();
                    reservaController.deleteReserva(reserva);
                    String message = "¡Hola "+jTableReservas.getModel().getValueAt(row, 1)+"!\nDesde Padel Land confirmamos que se ha cancelado la reserva en la pista " +jTableReservas.getModel().getValueAt(row, 2)
                            + " para el día "+ jTableReservas.getModel().getValueAt(row, 4) + " a las " + jTableReservas.getModel().getValueAt(row, 3);
                    mensaje+="\n ¡Pase usted un buen día!";
                    Mailer mailer = new Mailer();
                    mailer.enviarMail("Confirmación de Anulación de reserva", email, message);                    
                    fillTablaReservasFiltro(jTableReservas, "", "", "");
                }
            }
        }
    }//GEN-LAST:event_jTableReservasMousePressed

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        // TODO add your handling code here:
        String email = jTextFieldEmail.getText();
        String fechaInicio ="";
        String fechaFin = "";
        if (jDateChooserFechaInicio.getDate() != null){
            fechaInicio = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooserFechaInicio.getDate());
        }
        if (jDateChooserFechaFin.getDate() != null){
            fechaFin = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooserFechaFin.getDate());
        }
        
        fillTablaReservasFiltro(jTableReservas, email, fechaInicio, fechaFin);
    }//GEN-LAST:event_jButtonFiltrarActionPerformed
    
    public void fillTablaReservasFiltro(JTable tablaReservas, String email, String fechaInicio, String fechaFin){
        tablaReservas.setDefaultRenderer(Object.class, new RenderUtil());
        model = new DefaultTableModel(null,new Object[]{"Id","Cliente", "Pista", "Horario","Dia",""}){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }  
        };
        
        
        Object[] row;
        model.setRowCount(0);
        
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatoDia = new SimpleDateFormat("dd-MM-yyyy");
        
        List<Reservas> listaReservas = null;
        if (!email.trim().equals("") && !fechaInicio.trim().equals("") && !fechaFin.trim().equals("")){
            //Viene email, fechaInicio y fechaFin
            listaReservas = reservaController.getReservasByEmailFechaInicioFechaFin(email, fechaInicio, fechaFin);
        }else if (!email.trim().equals("") && !fechaInicio.trim().equals("") && fechaFin.trim().equals("")){
            //Viene email y fechaInicio
            listaReservas = reservaController.getReservasByEmailFechaInicio(email, fechaInicio);
        }else if (!email.trim().equals("") && fechaInicio.trim().equals("") && fechaFin.trim().equals("")){
            //Viene email
            listaReservas = reservaController.getReservasByEmail(email);
        }else if (!email.trim().equals("") && fechaInicio.trim().equals("") && !fechaFin.trim().equals("")){
            //Viene email y fechaFin
            listaReservas = reservaController.getReservasByEmailFechaFin(email, fechaFin);
        }else if (email.trim().equals("") && !fechaInicio.trim().equals("") && !fechaFin.trim().equals("")) {
            //Viene fechaInicio y fechaFin
            listaReservas = reservaController.getReservasByFechaInicioFechaFin(fechaInicio,fechaFin);
        }else if (email.trim().equals("") && !fechaInicio.trim().equals("") && fechaFin.trim().equals("")){
            //Viene fechaInicio
            listaReservas = reservaController.getReservasByFechaInicio(fechaInicio);
        }else if (email.trim().equals("") && fechaInicio.trim().equals("") && !fechaFin.trim().equals("")){
            //Viene fechaFin
            listaReservas = reservaController.getReservasByFechaFin(fechaFin);
        }else if (email.trim().equals("") && fechaInicio.trim().equals("") && fechaFin.trim().equals("")){
            //No viene nada
            listaReservas = reservaController.getReservasDesdeHoy(formatoDia.format(new Date()));
        }
        
        for(Reservas reserva : listaReservas){
            String dia = formatoDia.format(reserva.getDia());
            String hora = formatoHora.format(horarioController.selectHorario(reserva.getHorarios().getId()).getHoraComienzo());
            if (reserva.getDia().after(new Date()) || 
                    (dia.equals(formatoDia.format(new Date())) && LocalTime.now().isBefore(LocalTime.parse(hora)))){
                row = new Object[6];
                row[0] = reserva.getId();
                row[1] = usuarioController.selectUsuario(reserva.getUsuarios().getId()).getNombreCompleto();
                row[2] = pistaController.selectPista(reserva.getPistas().getId()).getNombrePista();
                row[3] = hora;
                row[4] = dia;
                row[5] = new JButton("Eliminar");
                model.addRow(row);
            }else {
                row = new Object[6];
                row[0] = reserva.getId();
                row[1] = usuarioController.selectUsuario(reserva.getUsuarios().getId()).getNombreCompleto();
                row[2] = pistaController.selectPista(reserva.getPistas().getId()).getNombrePista();
                row[3] = hora;
                row[4] = dia;
                row[5] = "";
                model.addRow(row);
            }
        }
        
        tablaReservas.setRowHeight(45);
        tablaReservas.setGridColor(Color.yellow);
        tablaReservas.setSelectionBackground(Color.cyan);
        
        jTableReservas.setModel(model);
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
            java.util.logging.Logger.getLogger(ManageReservasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageReservasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageReservasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageReservasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageReservasForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonFiltrar;
    private com.toedter.calendar.JDateChooser jDateChooserFechaFin;
    private com.toedter.calendar.JDateChooser jDateChooserFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    protected static javax.swing.JTable jTableReservas;
    private javax.swing.JTextField jTextFieldEmail;
    // End of variables declaration//GEN-END:variables
}
