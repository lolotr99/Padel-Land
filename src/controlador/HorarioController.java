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
import modelo.Horarios;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utilidades.NewHibernateUtil;

/**
 *
 * @author Manolo
 */
public class HorarioController {
    private Session sesion;
    
    private void iniciarOperacion(){
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
        }catch (HibernateException ex){
             Logger.getLogger(HorarioController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    private void terminarOperacion(){
        try{
            sesion.getTransaction().commit();
            sesion.close();
        }catch (HibernateException ex){
             Logger.getLogger(HorarioController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public Horarios selectHorario(long idHorario){
        Horarios horario = null;
        iniciarOperacion();
        try{
            horario = (Horarios) sesion.get(Horarios.class, idHorario);
        }catch (Exception ex){
           Logger.getLogger(HorarioController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return horario;
    }
    
    public long insertarHorario(Horarios horario) {
        long id = 0;
        iniciarOperacion();
        try{
            id = (long) sesion.save(horario);
       }catch (Exception ex){
           Logger.getLogger(HorarioController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return id;
    }
    
     public void deleteHorario(Horarios horario){
        iniciarOperacion();
        try{
            sesion.delete(horario);
        }catch (Exception ex){
           Logger.getLogger(HorarioController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
    }
     
    public Horarios getHorarioByHoraComienzo(Date hora){
        Horarios horario = null;
        iniciarOperacion();
        try{
            horario = (Horarios)sesion.createQuery("from Horarios h where h.horaComienzo='"+hora+"'").uniqueResult();
        }catch(Exception ex){
            Logger.getLogger(HorarioController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return horario;
    }
     
    public List<Horarios> getListaHorarios(){
        List<Horarios> listaHorarios = null;
        iniciarOperacion();
        try{
            listaHorarios = sesion.createQuery("from Horarios h ORDER BY h.turno ASC, h.horaComienzo ASC").list();
        }catch (Exception ex){
           Logger.getLogger(HorarioController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaHorarios;
    }
     
    public void fillHorariosTable(JTable tablaHorarios){
        List<Horarios> listaHorarios = getListaHorarios();
        Object[] row;
        DefaultTableModel model = (DefaultTableModel)tablaHorarios.getModel();
        model.setRowCount(0);
        for(Horarios horario : listaHorarios){
            row = new Object[4];
            row[0] = horario.getId();
            row[1] = horario.getTurno();
            row[2] = horario.getHoraComienzo();
            row[3] = new JButton("Eliminar");
            model.addRow(row);
        }
   } 
}
