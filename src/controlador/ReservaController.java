/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Horarios;
import modelo.Pistas;
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
    
    public Reservas getReserva(long idPista, long idHorario, String dia){
        Reservas reserva = null;
        iniciarOperacion();
        try{
            reserva = (Reservas) sesion.createQuery("FROM Reservas r WHERE r.horarios.id = "+idHorario+" AND r.pistas.id = "+idPista+" AND r.dia = '"+dia+"'").uniqueResult();
        }catch(Exception ex){
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return reserva;
    }
    
    public List<Reservas> getReservasUsuario(long idUsuario) {
        List<Reservas> listaReservasUsuario = null;
        iniciarOperacion();
        try{
            listaReservasUsuario = sesion.createQuery("select r from Reservas r, Usuarios u, Pistas p, Horarios h WHERE u.id = r.usuarios.id AND p.id = r.pistas.id AND h.id = r.horarios.id AND u.id='"+idUsuario+"' ORDER BY r.dia DESC, h.horaComienzo ASC").list();
        }catch(Exception ex){
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaReservasUsuario;
    }
    
    
    public List<Reservas> getReservasByDia(String dia) {
        List<Reservas> listaReservas = null;
        iniciarOperacion();
        try{
            listaReservas = sesion.createQuery("SELECT r FROM Reservas r , Usuarios u WHERE r.usuarios.id = u.id AND r.dia >= '"+dia+"'").list();
        }catch(Exception ex){
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaReservas;
    }
    
    public List<Reservas> getReservasDesdeHoy(String dia) {
        List<Reservas> listaReservas = null;
        iniciarOperacion();
        try{
            listaReservas = sesion.createQuery("SELECT r FROM Reservas r , Horarios h WHERE r.horarios.id = h.id AND r.dia >= '"+dia+"' ORDER BY r.dia DESC, h.horaComienzo ASC").list();
        }catch(Exception ex){
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaReservas;
    }
    
    public List<Reservas> getReservasByEmailFechaInicioFechaFin(String email, String fechaInicio, String fechaFin){
        List<Reservas> listaReservas = null;
        iniciarOperacion();
        try{
            listaReservas = sesion.createQuery("SELECT r FROM Reservas r, Usuarios u, Horarios h WHERE r.usuarios.id = u.id AND r.horarios.id = h.id AND u.email like '%"+email+"%' AND r.dia BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"' ORDER BY r.dia ASC, h.horaComienzo ASC").list();
        }catch(Exception ex){            
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaReservas;
    }
    
     public List<Reservas> getReservasByEmailFechaInicio(String email, String fechaInicio){
        List<Reservas> listaReservas = null;
        iniciarOperacion();
        try{
            listaReservas = sesion.createQuery("SELECT r FROM Reservas r, Usuarios u, Horarios h WHERE r.usuarios.id = u.id AND r.horarios.id = h.id AND u.email like '%"+email+"%' AND r.dia >= '"+fechaInicio+"' ORDER BY r.dia ASC, h.horaComienzo ASC").list();
        }catch(Exception ex){            
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaReservas;
    }
    public List<Reservas> getReservasByEmailFechaFin(String email, String fechaFin){
        List<Reservas> listaReservas = null;
        iniciarOperacion();
        try{
            listaReservas = sesion.createQuery("SELECT r FROM Reservas r, Usuarios u, Horarios h WHERE r.usuarios.id = u.id AND r.horarios.id = h.id AND u.email like '%"+email+"%' AND r.dia <= '"+fechaFin+"' ORDER BY r.dia ASC, h.horaComienzo ASC").list();
        }catch(Exception ex){            
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaReservas;
    }
    
    public List<Reservas> getReservasByEmail(String email){
        List<Reservas> listaReservas = null;
        iniciarOperacion();
        try{
            listaReservas = sesion.createQuery("SELECT r FROM Reservas r, Usuarios u, Horarios h WHERE r.usuarios.id = u.id AND r.horarios.id = h.id AND u.email like '%"+email+"%' ORDER BY r.dia ASC, h.horaComienzo ASC").list();
        }catch(Exception ex){            
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaReservas;
    }
    
    public List<Reservas> getReservasByFechaInicioFechaFin(String fechaInicio,String fechaFin){
        List<Reservas> listaReservas = null;
        iniciarOperacion();
        try{
            listaReservas = sesion.createQuery("SELECT r FROM Reservas r, Horarios h WHERE r.horarios.id = h.id AND r.dia BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"' ORDER BY r.dia ASC, h.horaComienzo ASC").list();
        }catch(Exception ex){            
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaReservas;
    }
    
    public List<Reservas> getReservasByFechaInicio(String fechaInicio){
        List<Reservas> listaReservas = null;
        iniciarOperacion();
        try{
            listaReservas = sesion.createQuery("SELECT r FROM Reservas r, Horarios h WHERE r.horarios.id = h.id AND r.dia >= '"+fechaInicio+"' ORDER BY r.dia ASC, h.horaComienzo ASC").list();
        }catch(Exception ex){            
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaReservas;
    }
    
    public List<Reservas> getReservasByFechaFin(String fechaFin){
        List<Reservas> listaReservas = null;
        iniciarOperacion();
        try{
            listaReservas = sesion.createQuery("SELECT r FROM Reservas r, Horarios h WHERE r.horarios.id = h.id AND r.dia <= '"+fechaFin+"' ORDER BY r.dia ASC, h.horaComienzo ASC").list();
        }catch(Exception ex){            
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaReservas;
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
    
    public long insertarReserva(Reservas reserva) {
        long id = 0;
        iniciarOperacion();
        try{
            id = (long) sesion.save(reserva);
        }catch (Exception ex){           
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return id;
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
    
    public ArrayList<Pistas> getPistasDisponiblesSegunDiayHora(String dia, String hora) {
        iniciarOperacion();
        ArrayList<Pistas> listaPistasDisponibles = null;
        String queryHQL = "SELECT p FROM Pistas p WHERE NOT EXISTS (SELECT r FROM Reservas r WHERE p.id = r.pistas.id AND r.dia = '"+dia+"' AND EXISTS (SELECT h FROM Horarios h WHERE h.id = r.horarios.id and h.horaComienzo = '"+hora+"')) ORDER BY p.nombrePista ASC";
        try{
            listaPistasDisponibles=(ArrayList<Pistas>)sesion.createQuery(queryHQL).list();
        }catch(Exception ex){
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaPistasDisponibles;
    }
    
    public ArrayList<Horarios> getHorariosQueTenganPistasDisponibles(String dia) {
        iniciarOperacion();
        ArrayList<Horarios> listaHorariosConPistasDisponibles = null;
        String queryHQL = "SELECT h FROM Horarios h WHERE EXISTS (SELECT p FROM Pistas p WHERE NOT EXISTS (SELECT r FROM Reservas r WHERE r.pistas.id = p.id AND r.horarios.id = h.id AND r.dia = '"+dia+"')) ORDER BY h.horaComienzo ASC";
        try{
            listaHorariosConPistasDisponibles = (ArrayList<Horarios>) sesion.createQuery(queryHQL).list();
        }catch(Exception ex) {
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaHorariosConPistasDisponibles;
        
    }
    
    public ArrayList<Horarios> getHorariosQueTenganPistasDisponiblesHoy(String dia, String hora) {
        iniciarOperacion();
        ArrayList<Horarios> listaHorariosConPistasDisponibles = null;
        String queryHQL = "SELECT h FROM Horarios h WHERE EXISTS (SELECT p FROM Pistas p WHERE NOT EXISTS (SELECT r FROM Reservas r WHERE r.pistas.id = p.id AND r.horarios.id = h.id AND r.dia = '"+dia+"')) AND h.horaComienzo > '"+hora+"' ORDER BY h.horaComienzo ASC";
        try{
            listaHorariosConPistasDisponibles = (ArrayList<Horarios>) sesion.createQuery(queryHQL).list();
        }catch(Exception ex) {
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaHorariosConPistasDisponibles;
        
    }
    
    public int getNumeroReservasSimultaneasUsuario(long id, String dia, String hora){
        int contador = 0;
        iniciarOperacion();
        try{
            contador+= (long) sesion.createQuery("select count(r) from Reservas r where r.usuarios.id = "+id+" and r.dia > '"+dia+"'").uniqueResult();
            contador+= (long) sesion.createQuery("select count(r) from Reservas r inner join r.horarios h where r.usuarios.id = "+id+" and r.dia = '"+dia+"' and h.horaComienzo > '"+hora+"'").uniqueResult();
        }catch(Exception ex) {
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return contador;
    }
    
    public int getNumeroReservasSimultaneasUsuario(String email, String dia, String hora){
        int contador = 0;
        iniciarOperacion();
        try{
            contador+= (long) sesion.createQuery("select count(r) from Reservas r where r.usuarios.email = '"+email+"' and r.dia > '"+dia+"'").uniqueResult();
            contador+= (long) sesion.createQuery("select count(r) from Reservas r inner join r.horarios h where r.usuarios.email = '"+email+"' and r.dia = '"+dia+"' and h.horaComienzo > '"+hora+"'").uniqueResult();
        }catch(Exception ex) {
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return contador;
    }
}
