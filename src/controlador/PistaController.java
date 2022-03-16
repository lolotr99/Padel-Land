/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
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
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Pistas;
import modelo.Usuarios;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utilidades.NewHibernateUtil;
import utilidades.SelfClosingInputStream;
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
        Blob blob = Hibernate.getLobCreator(sesion).createBlob(new SelfClosingInputStream(inputStream), file.length());
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
    
    public void fillPistasJTable(JTable tablaPistas, String valueBusqueda) throws SQLException, IOException{
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override //Redefinimos el método getColumnClass
            public Class getColumnClass(int column){
                switch(column) {
                    case 0: return Object.class;
                    case 1: return Object.class;
                    case 2: return ImageIcon.class;
                    default: return Object.class;
                }
            }
            
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        //Establecemos el modelo correspondiente en la JTable
        tablaPistas.setModel(modeloTabla);
        
        //Añadimos las columnas correspondientes
        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Nombre de pista");
        modeloTabla.addColumn("Imagen"); //Esta es la columna [3], es la que
                                         //nos interesa que sea una imagen.
                
        Object[] columna = new Object[3];
        
        List<Pistas> listaPistas = getPistasBusqueda(valueBusqueda);
        
        int numRegistros = listaPistas.size();
        
        for (int i = 0; i < numRegistros; i++) {
            columna[0] = listaPistas.get(i).getId();
            columna[1] = listaPistas.get(i).getNombrePista();

            //Transformamos el campo blob en ImageIcon
            Blob blob = listaPistas.get(i).getImagenPista();
            int blobLength = (int) blob.length();  
            byte[] bytes = blob.getBytes(1, blobLength);
            blob.free();
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));
            ImageIcon icon = new ImageIcon(img); 
            
            //Añadimos la imagen a la columna correspondiente
            columna[2] = icon;
            
            //Añadimos la fila al modelo
            modeloTabla.addRow(columna);                            
        }
      
        
   } 
}
