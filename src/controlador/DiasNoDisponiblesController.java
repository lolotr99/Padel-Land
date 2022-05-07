/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.DiasNoDisponibles;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utilidades.NewHibernateUtil;

/**
 *
 * @author Manolo
 */
public class DiasNoDisponiblesController {
     private Session sesion;
    
    private void iniciarOperacion(){
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
        }catch (HibernateException ex){
             Logger.getLogger(DiasNoDisponiblesController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    private void terminarOperacion(){
        try{
            sesion.getTransaction().commit();
            sesion.close();
        }catch (HibernateException ex){
             Logger.getLogger(DiasNoDisponiblesController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public DiasNoDisponibles selectDia(long idDia){
        DiasNoDisponibles dia = null;
        iniciarOperacion();
        try{
            dia = (DiasNoDisponibles) sesion.get(DiasNoDisponibles.class, idDia);
        }catch (Exception ex){
           Logger.getLogger(DiasNoDisponiblesController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return dia;
    }
    
    public long insertarDia(DiasNoDisponibles dia) {
        long id = 0;
        iniciarOperacion();
        try{
            id = (long) sesion.save(dia);
       }catch (Exception ex){
           Logger.getLogger(DiasNoDisponiblesController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return id;
    }
    
     public void deleteDiaNoDisponible(DiasNoDisponibles dia){
        iniciarOperacion();
        try{
            sesion.delete(dia);
        }catch (Exception ex){
           Logger.getLogger(DiasNoDisponiblesController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
    }
     
    public DiasNoDisponibles getDiaNoDisponibleByDate(String dia){
        DiasNoDisponibles diaNoDisponible = null;
        iniciarOperacion();
        try{
            diaNoDisponible = (DiasNoDisponibles)sesion.createQuery("from DiasNoDisponibles d where d.dia='"+dia+"'").uniqueResult();
        }catch(Exception ex){
            Logger.getLogger(DiasNoDisponiblesController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return diaNoDisponible;
    }
     
    public List<DiasNoDisponibles> getListaDias(){
        List<DiasNoDisponibles> listaDias = null;
        iniciarOperacion();
        try{
            listaDias = sesion.createQuery("from DiasNoDisponibles d ORDER BY d.dia ASC").list();
        }catch (Exception ex){
           Logger.getLogger(DiasNoDisponiblesController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaDias;
    }
     
     public void fillTableDiasNoDisponibles(JTable tablaDias){
        List<DiasNoDisponibles> listaDias = getListaDias();
        Object[] row;
        DefaultTableModel model = (DefaultTableModel)tablaDias.getModel();
        model.setRowCount(0);
        for(DiasNoDisponibles dia : listaDias){
            row = new Object[3];
            row[0] = dia.getId();
            row[1] = dia.getDia();
            row[2] = new JButton("Eliminar");
            model.addRow(row);
        }
   } 
}
