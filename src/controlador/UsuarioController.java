/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Usuarios;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utilidades.NewHibernateUtil;
import utilidades.SelfClosingInputStreamUtil;


/**
 *
 * @author Manolo
 */
public class UsuarioController {
    private Session sesion;
    
    private void iniciarOperacion(){
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
        }catch(HibernateException ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);

        }
    }
    private void terminarOperacion(){
        try{
            sesion.getTransaction().commit();
            sesion.close();
        }catch(HibernateException ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public long insertUsuario(Usuarios usuario){
        long id=0;
        iniciarOperacion();
        try{
            id = (long) sesion.save(usuario);
        }catch(Exception ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        terminarOperacion();
        return id;
    }
    public void updateUsuario(Usuarios usuario){
        iniciarOperacion();
        try{
            sesion.update(usuario);
        }catch(Exception ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        terminarOperacion();
    }
    public void deleteUsuario(Usuarios usuario){
        iniciarOperacion ();
        try{
            sesion.delete(usuario);
        }catch(Exception ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        terminarOperacion();
    }
    public Usuarios selectUsuario (long idUsuario){
        Usuarios usuario =null;
        iniciarOperacion();
        try{
            usuario = (Usuarios) sesion.get(Usuarios.class, idUsuario);
        }catch(Exception ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        terminarOperacion();
        return usuario;
    }
    
    public Usuarios obtenerUsuarioPorEmailAndPassword(String email, String password){
        Usuarios usuario = null;
        iniciarOperacion();
        try{
            usuario = (Usuarios)sesion.createQuery("FROM Usuarios U WHERE U.email='"+email+"' and U.password='"+password+"'").uniqueResult();
         }catch(Exception ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
         }
        terminarOperacion();
        return usuario;
    }
    
    
    public Usuarios obtenerUsuarioPorEmail(String email){
        Usuarios usuario = null;
        iniciarOperacion();
        try{
            usuario = (Usuarios)sesion.createQuery("from Usuarios U WHERE U.email='"+email+"'").uniqueResult();
        }catch(Exception ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        terminarOperacion();
        return usuario;
    }
    
    public List<Usuarios> getListaUsuarios(){
        List<Usuarios> listaUsuarios = null;
        iniciarOperacion();
        try{
            listaUsuarios = sesion.createQuery("from Usuarios").list();
        }catch(Exception ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        terminarOperacion();
        return listaUsuarios;
    }
    
    public List<Usuarios> getUsuariosBusqueda(String value){
        List<Usuarios> listaUsuarios = null;
        iniciarOperacion();
        String query = "from Usuarios U WHERE concat(U.nombreCompleto, U.email, U.telefono, U.rol) like '%"+value+"%'";        
        try{            
            listaUsuarios = sesion.createQuery(query).list();
        }catch(Exception ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        terminarOperacion();
        return listaUsuarios;
    }
    
    public void fillUsersJTable(JTable tabla, String valorBusqueda){
        List<Usuarios> listaUser = getUsuariosBusqueda(valorBusqueda);
        Object[] row;
        DefaultTableModel model = new DefaultTableModel(null,new Object[]{"Id", "Nombre completo", "Email", "Nº de Telefono", "Rol"}){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }  
        };
        model.setRowCount(0);        
        for(Usuarios user : listaUser){
            row = new Object[5];
            row[0] = user.getId();
            row[1] = user.getNombreCompleto();
            row[2] = user.getEmail();
            row[3] = user.getTelefono();
            row[4] = user.getRol();
                    
            model.addRow(row);
        }
        
        tabla.setRowHeight(40);
        tabla.setShowGrid(true);
        tabla.setGridColor(Color.green);
        tabla.setSelectionBackground(Color.cyan);
        
        tabla.setModel(model);
    }
    
    public void verImagenUsuario(Usuarios user) throws SQLException, IOException{
        BufferedImage bufferedImage = null;
        if (user.getImagenUsuario() != null){
            InputStream in = user.getImagenUsuario().getBinaryStream();  
            bufferedImage = ImageIO.read(in);
        }else{
            URL imgStream = UsuarioController.class.getClassLoader().getResource("resources/img/defecto.png");
            bufferedImage = ImageIO.read(imgStream);
        }
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = bufferedImage.getWidth();
        if (bufferedImage.getWidth() > screenSize.getWidth()){
            width = (int) screenSize.getWidth();
        }
        int height = bufferedImage.getHeight();
        if (bufferedImage.getHeight() > screenSize.getHeight()){
            height = (int)screenSize.getHeight()-25;
        }
        
        Image image = bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);

        ImageIcon icon = new ImageIcon(image);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(image.getWidth(frame), image.getHeight(frame));
       
        JLabel jLabel = new JLabel();
        jLabel.setIcon(icon);
        frame.add(jLabel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Visor de imagen de usuario -> " + user.getNombreCompleto());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    
    public Blob obtenerBlob(FileInputStream inputStream, File file) throws IOException{
        iniciarOperacion();
        Blob blob = Hibernate.getLobCreator(sesion).createBlob(new SelfClosingInputStreamUtil(inputStream), file.length());
        terminarOperacion();
        return blob;
    }
    
    public Session getSession() {
        return sesion;
    }
}
