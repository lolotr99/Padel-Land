/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.basico;

import controlador.HorarioController;
import controlador.PistaController;
import controlador.ReservaController;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Reservas;
import modelo.Usuarios;
import utilidades.ImagenFondo;
import utilidades.Mailer;
import utilidades.RenderUtil;

/**
 *
 * @author Manolo
 */
public class MiPerfilForm extends javax.swing.JFrame {

    /**
     * Creates new form UserForm
     */
    Usuarios user;
    DefaultTableModel model;
    ReservaController reservaController;
    HorarioController horarioController;
    PistaController pistaController;
    
    public MiPerfilForm() {
        initComponents();
    }
    
    public MiPerfilForm(Usuarios user) {
        this.user = user;
        reservaController = new ReservaController();
        pistaController = new PistaController();
        horarioController = new HorarioController();
        initComponents();
        rellenarDatosUsuario();
    }
    
    public void rellenarDatosUsuario() {
        
        if (user.getImagenUsuario() != null){
            BufferedImage img = null;
            Blob blob = user.getImagenUsuario();
            byte[] data;
            try {
                data = blob.getBytes(1, (int)blob.length());
                img = ImageIO.read(new ByteArrayInputStream(data));
                imgUsuario.setIcon(new ImageIcon(img.getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
            } catch (IOException | SQLException | NullPointerException ex) {
                Logger.getLogger(MiPerfilForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            URL imgStream = MiPerfilForm.class.getClassLoader().getResource("resources/img/defecto.png");
            BufferedImage defecto = null;
            try {
                defecto = ImageIO.read(imgStream);
            } catch (IOException ex) {
                Logger.getLogger(MiPerfilForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            imgUsuario.setIcon(new ImageIcon(defecto));
        }
        
        jLabelEmail.setText(user.getEmail());
        jLabelNombreCompleto.setText(user.getNombreCompleto());
        jLabelNTelefono.setText(user.getTelefono());
        
        fillTablaReservas(jTableReservasUser, user.getId());
    }
    
    public void fillTablaReservas(JTable tablaReservas, long idUsuario) {
        tablaReservas.setDefaultRenderer(Object.class, new RenderUtil());
        model = new DefaultTableModel(null,new Object[]{"Id", "Pista", "Horario","Dia",""}){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }  
        };
      
        Object[] row;
        model.setRowCount(0);
        List<Reservas> listaReservas = reservaController.getReservasUsuario(idUsuario);
        
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatoDia = new SimpleDateFormat("dd-MM-yyyy");
        
        for(Reservas reserva : listaReservas){
            String hora = formatoHora.format(horarioController.selectHorario(reserva.getHorarios().getId()).getHoraComienzo());
            String dia = formatoDia.format(reserva.getDia());
            String diaActual = formatoDia.format(new Date());
            row = new Object[5];
            row[0] = reserva.getId();
            row[1] = pistaController.selectPista(reserva.getPistas().getId()).getNombrePista();
            row[2] = hora;
            row[3] = dia;
            if (reserva.getDia().after(new Date())){
                Image imgEliminar = null;
                try {
                    imgEliminar = ImageIO.read(MiPerfilForm.class.getClassLoader().getResource("resources/img/icono-borrar.png"));
                } catch (IOException ex) {
                    Logger.getLogger(MiPerfilForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                row[4] = new JButton("Anular", new ImageIcon(imgEliminar));
            }else{
                if (dia.equals(diaActual) && LocalTime.now().isBefore(LocalTime.parse(hora))){
                    Image imgEliminar = null;
                    try {
                        imgEliminar = ImageIO.read(MiPerfilForm.class.getClassLoader().getResource("resources/img/icono-borrar.png"));
                    } catch (IOException ex) {
                        Logger.getLogger(MiPerfilForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    row[4] = new JButton("Anular", new ImageIcon(imgEliminar));
                }
            }
            model.addRow(row);
        }
        
        tablaReservas.setRowHeight(45);
        tablaReservas.setGridColor(Color.green);
        tablaReservas.setSelectionBackground(Color.cyan);
        
        jTableReservasUser.setModel(model);
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
        jSeparator1 = new javax.swing.JSeparator();
        imgUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReservasUser = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelEmail = new javax.swing.JLabel();
        jLabelNombreCompleto = new javax.swing.JLabel();
        jButtonEditarPerfil = new javax.swing.JButton();
        jLabelNTelefono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Padel Land - Mi Perfil");
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Historial de reservas de " + user.getNombreCompleto());

        jTableReservasUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Pista", "Horario", "Dia", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableReservasUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableReservasUserMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableReservasUser);
        if (jTableReservasUser.getColumnModel().getColumnCount() > 0) {
            jTableReservasUser.getColumnModel().getColumn(0).setResizable(false);
            jTableReservasUser.getColumnModel().getColumn(1).setResizable(false);
            jTableReservasUser.getColumnModel().getColumn(2).setResizable(false);
            jTableReservasUser.getColumnModel().getColumn(3).setResizable(false);
            jTableReservasUser.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("DATOS DEL USUARIO");

        jLabelEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-nombre-usuario.png"))); // NOI18N
        jLabelEmail.setText("email");

        jLabelNombreCompleto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-nombre-completo.png"))); // NOI18N
        jLabelNombreCompleto.setText("nombre completo");

        jButtonEditarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-actualizar.png"))); // NOI18N
        jButtonEditarPerfil.setText("Editar perfil");
        jButtonEditarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarPerfilActionPerformed(evt);
            }
        });

        jLabelNTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icons8-phone-50.png"))); // NOI18N
        jLabelNTelefono.setText("nº telefono");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabelNombreCompleto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNTelefono)
                            .addGap(42, 42, 42)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabelEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(imgUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(177, 177, 177)
                                                .addComponent(jLabel1))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(183, 183, 183)
                                                .addComponent(jButtonEditarPerfil)))))
                                .addGap(0, 182, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombreCompleto)
                            .addComponent(jLabelNTelefono))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEditarPerfil)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(imgUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
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

    private void jButtonEditarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarPerfilActionPerformed
        // TODO add your handling code here:
        EditarPerfilForm form = new EditarPerfilForm(user);
        form.pack();
        form.setLocationRelativeTo(null);
        form.setVisible(true);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButtonEditarPerfilActionPerformed

    private void jTableReservasUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableReservasUserMousePressed
        // TODO add your handling code here:
        int column = jTableReservasUser.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/jTableReservasUser.getRowHeight();
        if (column == 4){
            //Eliminar
            Object value = jTableReservasUser.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                String mensaje = "¿Seguro que quieres eliminar la reserva de las "+ jTableReservasUser.getModel().getValueAt(row,2)+" el día "
                        + jTableReservasUser.getModel().getValueAt(row,3) + " en la pista " + jTableReservasUser.getModel().getValueAt(row, 1) + "?";
                if (JOptionPane.showConfirmDialog(null, mensaje, "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    Reservas reserva = reservaController.selectReserva(Long.valueOf(jTableReservasUser.getModel().getValueAt(row,0).toString()));
                    String email = user.getEmail();
                    reservaController.deleteReserva(reserva);
                    String message = "¡Hola "+user.getNombreCompleto()+"!\nDesde Padel Land confirmamos que se ha cancelado la reserva en la pista " +jTableReservasUser.getModel().getValueAt(row, 1)
                            + " para el día "+ jTableReservasUser.getModel().getValueAt(row, 3) + " a las " + jTableReservasUser.getModel().getValueAt(row, 2);
                    mensaje+="\n ¡Pase usted un buen día!";
                    Mailer mailer = new Mailer();
                    mailer.enviarMail("Confirmación de Anulación de reserva", email, message);                    
                    fillTablaReservas(jTableReservasUser, user.getId());
                }
            }
        }
    }//GEN-LAST:event_jTableReservasUserMousePressed

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
            java.util.logging.Logger.getLogger(MiPerfilForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiPerfilForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiPerfilForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiPerfilForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiPerfilForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JLabel imgUsuario;
    private javax.swing.JButton jButtonEditarPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    protected static javax.swing.JLabel jLabelEmail;
    protected static javax.swing.JLabel jLabelNTelefono;
    protected static javax.swing.JLabel jLabelNombreCompleto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableReservasUser;
    // End of variables declaration//GEN-END:variables
}
