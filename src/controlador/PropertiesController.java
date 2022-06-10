/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utilidades.NewHibernateUtil;

/**
 *
 * @author Manolo
 */
public class PropertiesController {
    private Session sesion;
    
    private void iniciarOperacion(){
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
        }catch(HibernateException ex){
            Logger.getLogger(PropertiesController.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    private void terminarOperacion(){
        try{
            sesion.getTransaction().commit();
            sesion.close();
        }catch(HibernateException ex){
            Logger.getLogger(PropertiesController.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updatePropertie(Properties propertie){
        iniciarOperacion();
        try{
            sesion.update(propertie);
        }catch(Exception ex){
            Logger.getLogger(PropertiesController.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        terminarOperacion();
    }
    
    public Properties selectPropertieFromName(String namePropertie) {
        Properties propertie = null;
        iniciarOperacion();
        try{
            propertie = (Properties)sesion.createQuery("from Properties P WHERE P.propertie='"+namePropertie+"'").uniqueResult();
        }catch(Exception ex){
            Logger.getLogger(PropertiesController.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        terminarOperacion();
        return propertie;
    }
    
}
