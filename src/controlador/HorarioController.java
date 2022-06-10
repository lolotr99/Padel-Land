/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Horarios;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utilidades.NewHibernateUtil;
import utilidades.RenderUtil;

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
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);

        }
    }
    private void terminarOperacion(){
        try{
            sesion.getTransaction().commit();
            sesion.close();
        }catch (HibernateException ex){
            Logger.getLogger(HorarioController.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public Horarios selectHorario(long idHorario){
        Horarios horario = null;
        iniciarOperacion();
        try{
            horario = (Horarios) sesion.get(Horarios.class, idHorario);
        }catch (Exception ex){
           Logger.getLogger(HorarioController.class.getName()).log(Level.SEVERE,null,ex);
           JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
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
           JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        terminarOperacion();
    }
     
    public Horarios getHorarioByHoraComienzo(String hora){
        Horarios horario = null;
        iniciarOperacion();
        try{
            horario = (Horarios)sesion.createQuery("from Horarios h where h.horaComienzo='"+hora+"'").uniqueResult();
        }catch(Exception ex){
            Logger.getLogger(HorarioController.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        terminarOperacion();
        return listaHorarios;
    }
     
    public void fillHorariosTable(JTable tablaHorarios){
        List<Horarios> listaHorarios = getListaHorarios();
        Object[] row;
        tablaHorarios.setDefaultRenderer(Object.class, new RenderUtil());
        DefaultTableModel model = new DefaultTableModel(null,new Object[]{"Id", "Turno", "Hora Comienzo", ""}){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }  
        };
        
        model.setRowCount(0);
        for(Horarios horario : listaHorarios){
            row = new Object[4];
            row[0] = horario.getId();
            row[1] = horario.getTurno();
            row[2] = new SimpleDateFormat("HH:mm").format(horario.getHoraComienzo());
            Image imgEliminar = null;
            try {
                imgEliminar = ImageIO.read(HorarioController.class.getClassLoader().getResource("resources/img/icono-borrar.png"));
            } catch (IOException ex) {
                Logger.getLogger(HorarioController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,ex,"ERROR",JOptionPane.ERROR_MESSAGE);
            }
            row[3] = new JButton(new ImageIcon(imgEliminar));            
            model.addRow(row);
        }
        
        tablaHorarios.setRowHeight(45);
        tablaHorarios.setGridColor(Color.green);
        tablaHorarios.setSelectionBackground(Color.cyan);
        
        tablaHorarios.setModel(model);
   } 
}
