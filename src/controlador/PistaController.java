/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
            listaPistas = sesion.createQuery("from Pistas").list();
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
    
    public void fillPistasJTable(JTable tablaPistas, String valueBusqueda){
        List<Pistas> listaPistas = getPistasBusqueda(valueBusqueda);
        Object[] row;
        DefaultTableModel model = (DefaultTableModel)tablaPistas.getModel();
        for(Pistas pista : listaPistas){
            row = new Object[2];
            row[0] = pista.getId();
            row[1] = pista.getNombrePista();
            model.addRow(row);
        }
        tablaPistas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int fila = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    try {
                        verImagenPista(listaPistas.get(fila));
                    } catch (IOException ex) {
                        Logger.getLogger(PistaController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(PistaController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
   } 
    
    public void verImagenPista(Pistas pista) throws IOException, SQLException {
        InputStream in = pista.getImagenPista().getBinaryStream();  
        BufferedImage image = ImageIO.read(in);
        
        if (image != null){
            JFrame frame = new JFrame();
            frame.getContentPane().setLayout(new FlowLayout());
            frame.getContentPane().add(new JLabel(new ImageIcon(image)));
            frame.pack();
            frame.setVisible(true);
            frame.setTitle("Visor de imagenes -> " + pista.getNombrePista());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        }

    }

}
