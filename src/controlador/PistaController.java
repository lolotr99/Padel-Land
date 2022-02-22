/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.Pistas;
import org.hibernate.Session;
import utilidades.NewHibernateUtil;
/**
 *
 * @author Manolo
 */
public class PistaController {
    private Session sesion;
    
    private void iniciarOperacion(){
        sesion = NewHibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
    }
    private void terminarOperacion(){
        sesion.getTransaction().commit();
        sesion.close();
    }
    
    private long insertarPista(Pistas pista) {
        long id = 0;
        iniciarOperacion();
        id = (long) sesion.save(pista);
        terminarOperacion();
        return id;
    }
    
    private void updatePista(Pistas pista){
        iniciarOperacion();
        sesion.update(pista);
        terminarOperacion();
    }
    
    private void deletePista(Pistas pista){
        iniciarOperacion();
        sesion.delete(pista);
        terminarOperacion();
    }
    
    private Pistas selectPista(long idPista){
        Pistas pista;
        iniciarOperacion();
        pista = (Pistas) sesion.get(Pistas.class, idPista);
        terminarOperacion();
        return pista;
    }
    
    private List<Pistas> getListaPistas(){
        List<Pistas> listaPistas;
        iniciarOperacion();
        listaPistas = sesion.createQuery("from Pistas").list();
        terminarOperacion();
        return listaPistas;
    }
}
