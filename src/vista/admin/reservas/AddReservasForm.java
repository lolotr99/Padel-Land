/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.admin.reservas;

import controlador.DiasNoDisponiblesController;
import controlador.HorarioController;
import controlador.PistaController;
import controlador.PropertiesController;
import controlador.ReservaController;
import controlador.UsuarioController;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.DiasNoDisponibles;
import modelo.Horarios;
import modelo.Pistas;
import modelo.Properties;
import modelo.Reservas;
import modelo.Usuarios;
import utilidades.RenderUtil;
import static vista.admin.reservas.ManageReservasForm.jTableReservas;

/**
 *
 * @author Manolo
 */

public class AddReservasForm extends javax.swing.JFrame {

    /**
     * Creates new form AddReservasForm
     */
    
    ReservaController reservaController;
    DiasNoDisponiblesController diasNoDisponiblesController;
    HorarioController horarioController;
    PistaController pistaController;
    UsuarioController usuarioController;
    PropertiesController propertiesController;
    ArrayList<Pistas> pistasDisponiblesPorDiaYHora;
    ArrayList<Horarios> listaHorariosConPistasDisponibles;
    List<DiasNoDisponibles> listaDiasNoDisponibles;
    List<Usuarios> listaUsuarios;
    
    public AddReservasForm() {
        reservaController = new ReservaController();
        diasNoDisponiblesController = new  DiasNoDisponiblesController();
        horarioController = new HorarioController();
        pistaController = new PistaController();
        usuarioController = new UsuarioController();
        propertiesController = new PropertiesController();
        listaDiasNoDisponibles = diasNoDisponiblesController.getListaDias();
        initComponents();
        jDateChooserCita.setDate(new Date());
        
        //Rellenamos ComboBox con emails de usuarios
        listaUsuarios = usuarioController.getListaUsuarios();
        for (Usuarios user : listaUsuarios){
            jComboBoxEmailUser.addItem(user.getEmail());
        }
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jDateChooserCita = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxEmailUser = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxHorario = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxPistas = new javax.swing.JComboBox<>();
        jButtonReservar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Añadir Reserva");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(23, 255, 108));

        jPanel2.setBackground(new java.awt.Color(23, 255, 108));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Elige el día de la cita");

        jDateChooserCita.setDateFormatString("dd/MM/yyyy");
        jDateChooserCita.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserCitaPropertyChange(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("Email del usuario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooserCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxEmailUser, 0, 228, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxEmailUser, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jDateChooserCita, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(23, 255, 108));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Elige la pista");

        jComboBoxHorario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxHorarioItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("Elige hora de reserva");

        jButtonReservar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icons8-check-mark-40.png"))); // NOI18N
        jButtonReservar.setText("RESERVAR");
        jButtonReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReservarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPistas, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jButtonReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxPistas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButtonReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jDateChooserCitaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserCitaPropertyChange
        // TODO add your handling code here:
        SimpleDateFormat formatoDia = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        String dia = "";
        if (jDateChooserCita.getDate() != null)
        dia = formatoDia.format(jDateChooserCita.getDate());
        else{
            dia = formatoDia.format(new Date());
        }

        if ("date".equals(evt.getPropertyName())) {
            boolean isDiaSeleccionadoNoDisponible = false;
            for (DiasNoDisponibles diaNoDisponible : listaDiasNoDisponibles){
                if (formatoDia.format(diaNoDisponible.getDia()).equals(dia)){
                    isDiaSeleccionadoNoDisponible = true;
                    break;
                }
            }
            String hoy = formatoDia.format(new Date());
            String horaActual = formatoHora.format(new Date());
            if (hoy.equals(dia)){
                listaHorariosConPistasDisponibles = reservaController.getHorariosQueTenganPistasDisponiblesHoy(dia,horaActual);
                jComboBoxHorario.removeAllItems();
                jComboBoxPistas.removeAllItems();
                for (Horarios horario : listaHorariosConPistasDisponibles) {
                    jComboBoxHorario.addItem(formatoHora.format(horario.getHoraComienzo()));
                }
            }else if(jDateChooserCita.getDate().before(new Date())){
                jComboBoxHorario.removeAllItems();
                jComboBoxPistas.removeAllItems();
                JOptionPane.showMessageDialog(null,"El día seleccionado no puede ser anterior a la fecha actual","WARNING",JOptionPane.WARNING_MESSAGE);
            }else if (isDiaSeleccionadoNoDisponible){
                jComboBoxHorario.removeAllItems();
                jComboBoxPistas.removeAllItems();
                JOptionPane.showMessageDialog(null,"Padel Land cierra en el día seleccionado","WARNING",JOptionPane.WARNING_MESSAGE);
            }else{
                listaHorariosConPistasDisponibles = reservaController.getHorariosQueTenganPistasDisponibles(dia);
                jComboBoxHorario.removeAllItems();
                jComboBoxPistas.removeAllItems();
                for (Horarios horario : listaHorariosConPistasDisponibles) {
                    jComboBoxHorario.addItem(formatoHora.format(horario.getHoraComienzo()));
                }
            }
        }
    }//GEN-LAST:event_jDateChooserCitaPropertyChange

    private void jComboBoxHorarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxHorarioItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED){
            SimpleDateFormat formatoDia = new SimpleDateFormat("yyyy/MM/dd");
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
            String dia = "";
            String hora = "";
            if (jDateChooserCita.getDate() != null)
            dia = formatoDia.format(jDateChooserCita.getDate());
            else
            dia = formatoDia.format(new Date());

            if (jComboBoxHorario.getSelectedItem() != null)
            hora =  jComboBoxHorario.getSelectedItem().toString();
            else
            hora = formatoHora.format(new Date());
            pistasDisponiblesPorDiaYHora = reservaController.getPistasDisponiblesSegunDiayHora(dia, hora);
            jComboBoxPistas.removeAllItems();
            for (Pistas pista : pistasDisponiblesPorDiaYHora) {
                jComboBoxPistas.addItem(pista.getNombrePista());
            }
        }
    }//GEN-LAST:event_jComboBoxHorarioItemStateChanged

    private void jButtonReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReservarActionPerformed
        // TODO add your handling code here:
        if (verifyCampos()){
            Date dia = jDateChooserCita.getDate();
            String horaComienzo =jComboBoxHorario.getSelectedItem().toString();

            Horarios horario = horarioController.getHorarioByHoraComienzo(horaComienzo);
            Pistas pista = pistaController.getPistaByNombre(jComboBoxPistas.getSelectedItem().toString());
            Usuarios user = usuarioController.obtenerUsuarioPorEmail(jComboBoxEmailUser.getSelectedItem().toString());

            Reservas reserva = new Reservas(horario, pista, user, dia);
            long result = reservaController.insertarReserva(reserva);
            if (result != 0){
                JOptionPane.showMessageDialog(null,"Reserva añadida correctamente","INFO",JOptionPane.INFORMATION_MESSAGE);
                if (ManageReservasForm.jTableReservas != null){
                    fillTablaReservas(ManageReservasForm.jTableReservas);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Lo sentimos, ha ocurrido un error","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonReservarActionPerformed

    public boolean verifyCampos(){
        Date dia = jDateChooserCita.getDate();
        
        boolean usuarioSelected = jComboBoxEmailUser.getItemCount() > 0;
        String emailUsuario = "";
        if (usuarioSelected){
            emailUsuario = jComboBoxEmailUser.getSelectedItem().toString();
        }
        
        
        SimpleDateFormat formatoDia = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm"); 
        
        String hoy = formatoDia.format(new Date());
        String hora = formatoHora.format(new Date());
       
        Properties propertie = propertiesController.selectPropertieFromName("LIMITE_RESERVAS_SIMULTANEAS");
        int nReservasSimultaneasUsuario = reservaController.getNumeroReservasSimultaneasUsuario(emailUsuario, hoy, hora);
        
        if (Integer.valueOf(propertie.getValue()) <= nReservasSimultaneasUsuario) {
            //No se permite la reserva porque ya ha llegado al límite simultaneo
            return false;
        }
        
        boolean horarioSelected = jComboBoxHorario.getItemCount() > 0;
        String horaComienzo = "";
        if (horarioSelected){
            horaComienzo = jComboBoxHorario.getSelectedItem().toString();
        }
        
        boolean pistaSelected = jComboBoxPistas.getItemCount() > 0;
        String nombrePista = "";
        if (pistaSelected){
            nombrePista = jComboBoxPistas.getSelectedItem().toString();
        }
        
        return dia != null && !horaComienzo.trim().equals("") && !horaComienzo.trim().equals("");
        
    }
    
    
    public void fillTablaReservas(JTable tablaReservas) {
        tablaReservas.setDefaultRenderer(Object.class, new RenderUtil());
        DefaultTableModel model = new DefaultTableModel(null,new Object[]{"Id","Cliente", "Pista", "Horario","Dia","",""}){
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
            java.util.logging.Logger.getLogger(AddReservasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddReservasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddReservasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddReservasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddReservasForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonReservar;
    private javax.swing.JComboBox<String> jComboBoxEmailUser;
    private javax.swing.JComboBox<String> jComboBoxHorario;
    private javax.swing.JComboBox<String> jComboBoxPistas;
    private com.toedter.calendar.JDateChooser jDateChooserCita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
