/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.admin.diasnodisponibles;

import controlador.DiasNoDisponiblesController;
import controlador.HorarioController;
import controlador.PistaController;
import controlador.ReservaController;
import controlador.UsuarioController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.DiasNoDisponibles;
import modelo.Horarios;
import modelo.Pistas;
import modelo.Reservas;
import modelo.Usuarios;
import utilidades.Constantes;
import utilidades.ImagenFondo;
import utilidades.Mailer;

/**
 *
 * @author Manolo
 */
public class AddDiaNoDisponibleForm extends javax.swing.JFrame {

    /**
     * Creates new form AddDiaNoDisponibleForm
     */
    DiasNoDisponiblesController diasNoDisponiblesController;
    ReservaController reservaController;
    UsuarioController usuarioController;
    PistaController pistaController;
    HorarioController horarioController;
    
    public AddDiaNoDisponibleForm() {
        initComponents();
        diasNoDisponiblesController = new DiasNoDisponiblesController();
        reservaController = new ReservaController();
        usuarioController = new UsuarioController();
        pistaController = new PistaController();
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

        jPanel1 = new ImagenFondo();
        jLabel1 = new javax.swing.JLabel();
        jCalendar = new com.toedter.calendar.JCalendar();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAnadir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Padel Land - Añadir dia no disponible");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setText("Nuevo día no disponible");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(46, 46, 46)
                        .addComponent(jButtonAnadir, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
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
        Date fecha = jCalendar.getDate();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String fechaFormateada = formato.format(fecha);
        
        if (fecha.before(new Date())){
            JOptionPane.showMessageDialog(null, "No se puede añadir un día anterior al de hoy","Información",JOptionPane.ERROR_MESSAGE);
        }else {
            //Se comprueba que ese tramo horario no exista ya
            if (!checkDia(fechaFormateada)){
                if (reservaController.diaNoDisponibleEstaEnReservas(fechaFormateada)){
                    if(JOptionPane.showConfirmDialog(null, "Al insertar este día, se cancelarán las reservas que haya programadas. ¿Seguro que quieres insertar el día : "+fechaFormateada+"?", "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        //Anular todas las reservas de este día y notificar al usuario por correo
                        List<Reservas> listaReservasDia = reservaController.getReservasByDia(fechaFormateada);
                        for (Reservas reserva : listaReservasDia){
                            Usuarios user = usuarioController.selectUsuario(reserva.getUsuarios().getId());
                            Pistas pista = pistaController.selectPista(reserva.getPistas().getId());
                            Horarios horario = horarioController.selectHorario(reserva.getHorarios().getId());
                            String message = "¡Hola "+user.getNombreCompleto()+"!\nDesde Padel Land confirmamos que se ha cancelado la reserva en la pista " +pista.getNombrePista()
                                    + " para el día "+ new SimpleDateFormat("dd-MM-yyyy").format(reserva.getDia())+ " a las " + new SimpleDateFormat("HH:mm").format(horario.getHoraComienzo());
                            message+=" debido a que cerramos el club este día.\n ¡Pase usted un buen día!";
                            reservaController.deleteReserva(reserva);
                            Mailer mailer = new Mailer();
                            mailer.enviarMail(Constantes.EMAIL_ADMIN, user.getEmail(), "Confirmación de Anulación de reserva",message);
                        }   
                    }else{
                        return;
                    }
                }
                //Insertar
                DiasNoDisponibles dia = new DiasNoDisponibles(fecha);
                long result = diasNoDisponiblesController.insertarDia(dia);
                if (result != 0){
                    JOptionPane.showMessageDialog(null, "¡Nuevo día no disponible ha sido creado correctamente!","INFO",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error en el registro, revisa tus datos.","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
                    if (ManageDiasNoDisponiblesForm.jTableDiasNoDisponibles != null){
                        diasNoDisponiblesController.fillTableDiasNoDisponibles(ManageDiasNoDisponiblesForm.jTableDiasNoDisponibles);
                    }
            }
        
       
    }//GEN-LAST:event_jButtonAnadirActionPerformed

    //Creamos una funcíon para comprobar si el dia introducido ya existe en la BBDD
    public boolean checkDia(String dia) {
        boolean dia_exists = false;
        
        if (diasNoDisponiblesController.getDiaNoDisponibleByDate(dia) != null){
            dia_exists = true;
            JOptionPane.showMessageDialog(null, "Este día no disponible ya está registrado en la BBDD", "No se puede insertar este registro",JOptionPane.ERROR_MESSAGE);
        }
        
        return dia_exists;
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
            java.util.logging.Logger.getLogger(AddDiaNoDisponibleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDiaNoDisponibleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDiaNoDisponibleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDiaNoDisponibleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddDiaNoDisponibleForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnadir;
    private javax.swing.JButton jButtonCancelar;
    private com.toedter.calendar.JCalendar jCalendar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
