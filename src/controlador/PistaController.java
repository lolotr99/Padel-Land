/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pistas;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utilidades.NewHibernateUtil;
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
    
    private long insertarPista(Pistas pista) {
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
    
    private void updatePista(Pistas pista){
        iniciarOperacion();
        try{
            sesion.update(pista);
        }catch (Exception ex){
           Logger.getLogger(PistaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
    }
    
    private void deletePista(Pistas pista){
        iniciarOperacion();
        try{
            sesion.delete(pista);
        }catch (Exception ex){
           Logger.getLogger(PistaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
    }
    
    private Pistas selectPista(long idPista){
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
    
    private List<Pistas> getListaPistas(){
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
}
