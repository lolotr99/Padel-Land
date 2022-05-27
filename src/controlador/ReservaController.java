/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Reservas;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utilidades.NewHibernateUtil;

/**
 *
 * @author Manolo
 */
public class ReservaController {
    private Session sesion;
    
    private void iniciarOperacion(){
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
        }catch (HibernateException ex){
             Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    private void terminarOperacion(){
        try{
            sesion.getTransaction().commit();
            sesion.close();
        }catch (HibernateException ex){
             Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public Reservas selectReserva(long idReserva){
        Reservas reserva = null;
        iniciarOperacion();
        try{
            reserva = (Reservas) sesion.get(Reservas.class, idReserva);
        }catch (Exception ex){
           Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return reserva;
    }
    
    public List<Reservas> getReservasUsuario(long idUsuario) {
        List<Reservas> listaReservasUsuario = null;
        iniciarOperacion();
        try{
            listaReservasUsuario = sesion.createQuery("select r from Reservas r, Usuarios u, Pistas p, Horarios h WHERE u.id = r.usuarios.id AND p.id = r.pistas.id AND h.id = r.horarios.id AND u.id='"+idUsuario+"'").list();
        }catch(Exception ex){
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaReservasUsuario;
    }
    
    public void deleteReserva(Reservas reserva){
        iniciarOperacion();
        try{
            sesion.delete(reserva);
        }catch (Exception ex){
           Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
    }
    
    public boolean usuarioTieneReservas(long idUsuario) {
        iniciarOperacion();
        boolean exists = false;
        try{
            exists = (Long) sesion.createQuery("select count(r.id) from Reservas r where r.usuarios.id = '"+idUsuario+"'").uniqueResult() > 0;
        }catch(Exception ex){
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return exists;
    }
    
    public boolean pistaTieneReservas(long idPista) {
        iniciarOperacion();
        boolean exists = false;
        try{
            exists = (Long) sesion.createQuery("select count(r.id) from Reservas r where r.pistas.id = '"+idPista+"'").uniqueResult() > 0;
        }catch(Exception ex){
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return exists;
    }
    
    public boolean horarioTieneReservas(long idHorario) {
        iniciarOperacion();
        boolean exists = false;
        try{
            exists = (Long) sesion.createQuery("select count(r.id) from Reservas r where r.horarios.id = '"+idHorario+"'").uniqueResult() > 0;
        }catch(Exception ex){
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return exists;
    }
    
    public boolean diaNoDisponibleEstaEnReservas(String dia) {
        iniciarOperacion();
        boolean exists = false;
        try{
            exists = (Long) sesion.createQuery("select count(r.id) from Reservas r where r.dia = '"+dia+"'").uniqueResult() > 0;
        }catch(Exception ex){
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return exists;
    }
    
    public ArrayList<Map> getPistasYHorasDisponiblesPorDia(String dia) {
        iniciarOperacion();
        ArrayList<Map> respuestaHQL = null;
        String queryHQL = "SELECT new Map(p.id,h.id) FROM Horarios h, Pistas p WHERE NOT EXISTS "
                + " (SELECT r FROM Reservas r WHERE r.horarios.id = h.id  AND p.id = r.pistas.id AND r.dia = '"+dia+"')";
        try{
            respuestaHQL=(ArrayList<Map>)sesion.createQuery(queryHQL).list();
        }catch(Exception ex){
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return respuestaHQL;
    }
}
