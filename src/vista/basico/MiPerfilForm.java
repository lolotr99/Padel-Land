/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.basico;

import controlador.HorarioController;
import controlador.PistaController;
import controlador.UsuarioController;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Reservas;
import modelo.Usuarios;
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
    UsuarioController userController;
    HorarioController horarioController;
    PistaController pistaController;
    public MiPerfilForm() {
        initComponents();
    }
    
    public MiPerfilForm(Usuarios user) {
        this.user = user;
        userController = new UsuarioController();
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
        
        jLabelNombreUsuario.setText(user.getUsername());
        jLabelNombreCompleto.setText(user.getNombreCompleto());
        jLabelNTelefono.setText(user.getTelefono());
        
        fillTablaReservas(jTableReservasUser, user.getId());
    }
    
    public void fillTablaReservas(JTable tablaReservas, long idUsuario) {
        tablaReservas.setDefaultRenderer(Object.class, new RenderUtil());
        model = new DefaultTableModel(null,new Object[]{"Pista", "Horario","Dia",""}){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }  
        };
      
        Object[] row;
        model.setRowCount(0);
        List<Reservas> listaReservas = userController.getReservasUsuario(idUsuario);
        
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatoDia = new SimpleDateFormat("dd-MM-yyyy");
        
        for(Reservas reserva : listaReservas){
            String hora = formatoHora.format(horarioController.selectHorario(reserva.getHorarios().getId()).getHoraComienzo());
            String dia = formatoDia.format(reserva.getDia());
            String diaActual = formatoDia.format(new Date());
            row = new Object[4];
            row[0] = pistaController.selectPista(reserva.getPistas().getId()).getNombrePista();
            row[1] = hora;
            row[2] = dia;
            if (reserva.getDia().after(new Date())){
                row[3] = new JButton("Anular reserva");
            }else{
                if (dia.equals(diaActual) && LocalTime.now().isBefore(LocalTime.parse(hora))){
                    row[3] = new JButton("Anular reserva");
                }
            }
            model.addRow(row);
        }
        
        tablaReservas.setRowHeight(45);
        tablaReservas.setGridColor(Color.yellow);
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

        jPanel1 = new javax.swing.JPanel();
        jPanelImagenUser = new javax.swing.JPanel();
        imgUsuario = new javax.swing.JLabel();
        jPanelDatosUser = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jLabelNombreCompleto = new javax.swing.JLabel();
        jButtonEditarPerfil = new javax.swing.JButton();
        jLabelNTelefono = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelHistorialReservasUser = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReservasUser = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PADEL LAND - Vista de usuario");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(23, 255, 108));

        jPanelImagenUser.setBackground(new java.awt.Color(23, 255, 108));

        javax.swing.GroupLayout jPanelImagenUserLayout = new javax.swing.GroupLayout(jPanelImagenUser);
        jPanelImagenUser.setLayout(jPanelImagenUserLayout);
        jPanelImagenUserLayout.setHorizontalGroup(
            jPanelImagenUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        jPanelImagenUserLayout.setVerticalGroup(
            jPanelImagenUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelDatosUser.setBackground(new java.awt.Color(23, 255, 108));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("DATOS DEL USUARIO");

        jLabelNombreUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-nombre-usuario.png"))); // NOI18N
        jLabelNombreUsuario.setText("nombre de usuario");

        jLabelNombreCompleto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icono-nombre-completo.png"))); // NOI18N
        jLabelNombreCompleto.setText("nombre completo");

        jButtonEditarPerfil.setText("Editar perfil");
        jButtonEditarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarPerfilActionPerformed(evt);
            }
        });

        jLabelNTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/icons8-phone-50.png"))); // NOI18N
        jLabelNTelefono.setText("nº telefono");

        javax.swing.GroupLayout jPanelDatosUserLayout = new javax.swing.GroupLayout(jPanelDatosUser);
        jPanelDatosUser.setLayout(jPanelDatosUserLayout);
        jPanelDatosUserLayout.setHorizontalGroup(
            jPanelDatosUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanelDatosUserLayout.createSequentialGroup()
                .addGroup(jPanelDatosUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosUserLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jButtonEditarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDatosUserLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))
                    .addGroup(jPanelDatosUserLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelDatosUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombreUsuario)
                            .addGroup(jPanelDatosUserLayout.createSequentialGroup()
                                .addComponent(jLabelNombreCompleto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                                .addComponent(jLabelNTelefono)))))
                .addGap(52, 52, 52))
        );
        jPanelDatosUserLayout.setVerticalGroup(
            jPanelDatosUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreCompleto)
                    .addComponent(jLabelNTelefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelNombreUsuario)
                .addGap(7, 7, 7)
                .addComponent(jButtonEditarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelHistorialReservasUser.setBackground(new java.awt.Color(23, 255, 108));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Historial de reservas de " + user.getNombreCompleto());

        jTableReservasUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pista", "Horario", "Dia", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableReservasUser);
        if (jTableReservasUser.getColumnModel().getColumnCount() > 0) {
            jTableReservasUser.getColumnModel().getColumn(0).setResizable(false);
            jTableReservasUser.getColumnModel().getColumn(1).setResizable(false);
            jTableReservasUser.getColumnModel().getColumn(2).setResizable(false);
            jTableReservasUser.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanelHistorialReservasUserLayout = new javax.swing.GroupLayout(jPanelHistorialReservasUser);
        jPanelHistorialReservasUser.setLayout(jPanelHistorialReservasUserLayout);
        jPanelHistorialReservasUserLayout.setHorizontalGroup(
            jPanelHistorialReservasUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHistorialReservasUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHistorialReservasUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelHistorialReservasUserLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelHistorialReservasUserLayout.setVerticalGroup(
            jPanelHistorialReservasUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHistorialReservasUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelHistorialReservasUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelImagenUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelDatosUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelImagenUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDatosUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelHistorialReservasUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jButtonEditarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarPerfilActionPerformed
        // TODO add your handling code here:
        EditarPerfilForm form = new EditarPerfilForm(user);
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButtonEditarPerfilActionPerformed

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
    protected static javax.swing.JLabel jLabelNTelefono;
    protected static javax.swing.JLabel jLabelNombreCompleto;
    protected static javax.swing.JLabel jLabelNombreUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDatosUser;
    private javax.swing.JPanel jPanelHistorialReservasUser;
    private javax.swing.JPanel jPanelImagenUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableReservasUser;
    // End of variables declaration//GEN-END:variables
}
