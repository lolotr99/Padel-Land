/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class UsuarioController {
    private Session sesion;
    
    private void iniciarOperacion(){
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
        }catch(HibernateException ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    private void terminarOperacion(){
        try{
            sesion.getTransaction().commit();
            sesion.close();
        }catch(HibernateException ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public long insertUsuario(Usuarios usuario){
        long id=0;
        iniciarOperacion();
        try{
            id = (long) sesion.save(usuario);
        }catch(Exception ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return id;
    }
    public void updateUsuario(Usuarios usuario){
        iniciarOperacion();
        try{
            sesion.update(usuario);
        }catch(Exception ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
    }
    public void deleteUsuario(Usuarios usuario){
        iniciarOperacion ();
        try{
            sesion.delete(usuario);
        }catch(Exception ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
    }
    public Usuarios selectUsuario (long idUsuario){
        Usuarios usuario =null;
        iniciarOperacion();
        try{
            usuario = (Usuarios) sesion.get(Usuarios.class, idUsuario);
        }catch(Exception ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return usuario;
    }
    public Usuarios obtenerUsuarioPorUsernameAndPassword(String username, String password){
        Usuarios usuario = null;
        iniciarOperacion();
        try{
            usuario = (Usuarios)sesion.createQuery("from Usuarios U WHERE U.username='"+username+"' and U.password='"+password+"'").uniqueResult();
        }catch(Exception ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return usuario;
    }
    
    public Usuarios obtenerUsuarioPorUserName(String username){
        Usuarios usuario = null;
        iniciarOperacion();
        try{
            usuario = (Usuarios)sesion.createQuery("from Usuarios U WHERE U.username='"+username+"'").uniqueResult();
        }catch(Exception ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return usuario;
    }
    
    public List<Usuarios> getListaUsuarios(){
        List<Usuarios> listaUsuarios = null;
        iniciarOperacion();
        try{
            listaUsuarios = sesion.createQuery("from Usuarios").list();
        }catch(Exception ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,ex);
        }
        terminarOperacion();
        return listaUsuarios;
    }
    
    public Blob obtenerBlob(FileInputStream inputStream, File file) throws IOException{
        return Hibernate.getLobCreator(sesion).createBlob(new SelfClosingInputStream(inputStream), file.length());
    }
}
