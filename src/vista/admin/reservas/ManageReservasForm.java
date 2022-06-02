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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Reservas;
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
        fillTablaReservas(jTableReservas);
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
        jTextField1 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de reservas");

        jPanel1.setBackground(new java.awt.Color(23, 255, 108));

        jPanel4.setBackground(new java.awt.Color(23, 255, 108));

        jTableReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cliente", "Pista", "Horario", "Dia", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            jTableReservas.getColumnModel().getColumn(6).setResizable(false);
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
            .addComponent(jScrollPane1)
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

        jButton1.setText("Filtrar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 326, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
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
            //Modificar
        }else if (column == 6){
            //Eliminar
        }
    }//GEN-LAST:event_jTableReservasMousePressed
    
    public void fillTablaReservas(JTable tablaReservas) {
        tablaReservas.setDefaultRenderer(Object.class, new RenderUtil());
        model = new DefaultTableModel(null,new Object[]{"Id","Cliente", "Pista", "Horario","Dia","",""}){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }  
        };
        
        
        Object[] row;
        model.setRowCount(0);
        
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatoDia = new SimpleDateFormat("dd-MM-yyyy");
        
        List<Reservas> listaReservas = reservaController.getReservasDesdeHoy(formatoDia.format(new Date()));
        
        for(Reservas reserva : listaReservas){
            String dia = formatoDia.format(reserva.getDia());
            String hora = formatoHora.format(horarioController.selectHorario(reserva.getHorarios().getId()).getHoraComienzo());
            if (reserva.getDia().after(new Date())){
                row = new Object[7];
                row[0] = reserva.getId();
                row[1] = usuarioController.selectUsuario(reserva.getUsuarios().getId()).getEmail();
                row[2] = pistaController.selectPista(reserva.getPistas().getId()).getNombrePista();
                row[3] = hora;
                row[4] = dia;
                row[5] = new JButton("Modificar");
                row[6] = new JButton("Eliminar");
                model.addRow(row);
            }else {
                if (dia.equals(formatoDia.format(new Date())) && LocalTime.now().isBefore(LocalTime.parse(hora))){
                    row = new Object[7];
                    row[0] = reserva.getId();
                    row[1] = usuarioController.selectUsuario(reserva.getUsuarios().getId()).getNombreCompleto();
                    row[2] = pistaController.selectPista(reserva.getPistas().getId()).getNombrePista();
                    row[3] = hora;
                    row[4] = dia;
                    row[5] = new JButton("Modificar");
                    row[6] = new JButton("Eliminar");
                    model.addRow(row);
                }
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    protected static javax.swing.JTable jTableReservas;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
