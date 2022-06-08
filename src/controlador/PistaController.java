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
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Pistas;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utilidades.NewHibernateUtil;
import utilidades.SelfClosingInputStreamUtil;
/**
 *
 * @author Manolo
 */
public class PistaController {
    private Session sesion;
    
    private void iniciarOperacion(){
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
        }catch (HibernateException ex){
             Logger.getLogger(PistaController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    private void terminarOperacion(){
        try{
            sesion.getTransaction().commit();
            sesion.close();
        }catch (HibernateException ex){
             Logger.getLogger(PistaController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public long insertarPista(Pistas pista) {
        long id = 0;
        iniciarOperacion();
        try{
            id = (long) sesion.save(pista);
       }catch (Exception ex){
           Logger.getLogger(PistaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return id;
    }
    
    public void updatePista(Pistas pista){
        iniciarOperacion();
        try{
            sesion.update(pista);
        }catch (Exception ex){
           Logger.getLogger(PistaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
    }
    
    public void deletePista(Pistas pista){
        iniciarOperacion();
        try{
            sesion.delete(pista);
        }catch (Exception ex){
           Logger.getLogger(PistaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
    }
    
    public Pistas selectPista(long idPista){
        Pistas pista = null;
        iniciarOperacion();
        try{
            pista = (Pistas) sesion.get(Pistas.class, idPista);
        }catch (Exception ex){
           Logger.getLogger(PistaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return pista;
    }
    
    public List<Pistas> getListaPistas(){
        List<Pistas> listaPistas = null;
        iniciarOperacion();
        try{
            listaPistas = sesion.createQuery("from Pistas p ORDER BY p.nombrePista ASC").list();
        }catch (Exception ex){
           Logger.getLogger(PistaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaPistas;
    }
    
    public Blob obtenerBlob(FileInputStream inputStream, File file) throws IOException{
        iniciarOperacion();
        Blob blob = Hibernate.getLobCreator(sesion).createBlob(new SelfClosingInputStreamUtil(inputStream), file.length());
        terminarOperacion();
        return blob;
    }
    
    public List<Pistas> getPistasBusqueda(String value){
        List<Pistas> listaPistas = null;
        iniciarOperacion();
        String query = "from Pistas P WHERE P.nombrePista like '%"+value+"%'";        
        try{            
            listaPistas = sesion.createQuery(query).list();
        }catch(Exception ex){
            Logger.getLogger(PistaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaPistas;
    }
    
    public Pistas getPistaByNombre(String nombrePista){
        Pistas pista = null;
        iniciarOperacion();
        try{
            pista = (Pistas) sesion.createQuery("FROM Pistas p where p.nombrePista = '"+nombrePista+"'").uniqueResult();
        }catch(Exception ex) {
            Logger.getLogger(PistaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return pista;
    }
    
    public void fillPistasJTable(JTable tablaPistas, String valueBusqueda){
        List<Pistas> listaPistas = getPistasBusqueda(valueBusqueda);
        Object[] row;
        DefaultTableModel model = new DefaultTableModel(null,new Object[]{"Id", "Nombre de pista"}) {
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }  
        };
        
        model.setRowCount(0);
        for(Pistas pista : listaPistas){
            row = new Object[2];
            row[0] = pista.getId();
            row[1] = pista.getNombrePista();
            model.addRow(row);
        }
        
        tablaPistas.setRowHeight(40);
        tablaPistas.setShowGrid(true);
        tablaPistas.setGridColor(Color.green);
        tablaPistas.setSelectionBackground(Color.cyan);
        
        tablaPistas.setModel(model);
   } 
    
    public void verImagenPista(Pistas pista) throws IOException, SQLException {
        InputStream in = pista.getImagenPista().getBinaryStream();  
        BufferedImage bufferedImage = ImageIO.read(in);
        
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
        frame.setTitle("Visor de imagen de pista -> " + pista.getNombrePista());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
