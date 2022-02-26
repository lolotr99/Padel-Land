/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.Usuarios;
import org.hibernate.Session;
import utilidades.NewHibernateUtil;


/**
 *
 * @author Manolo
 */
public class UsuarioController {
    private Session sesion;
    
    private void iniciarOperacion(){
        sesion = NewHibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
    }
    private void terminarOperacion(){
        sesion.getTransaction().commit();
        sesion.close();
    }
    
    public long insertUsuario(Usuarios usuario){
        long id=0;
        iniciarOperacion();
        id = (long) sesion.save(usuario);
        terminarOperacion();
        return id;
    }
    public void updateUsuario(Usuarios usuario){
        iniciarOperacion();
        sesion.update(usuario);
        terminarOperacion();
    }
    public void deleteUsuario(Usuarios usuario){
        iniciarOperacion ();
        sesion.delete(usuario);
        terminarOperacion();
    }
    public Usuarios selectUsuario (long idUsuario){
        Usuarios usuario =null;
        iniciarOperacion();
        usuario = (Usuarios) sesion.get(Usuarios.class, idUsuario);
        terminarOperacion();
        return usuario;
    }
    public Usuarios obtenerUsuarioPorUsernameAndPassword(String username, String password){
        Usuarios usuario = null;
        iniciarOperacion();
        usuario = (Usuarios)sesion.createQuery("from Usuarios U WHERE U.username='"+username+"' and U.password='"+password+"'").uniqueResult();
        terminarOperacion();
        return usuario;
    }
    
    public Usuarios obtenerUsuarioPorUserName(String username){
        Usuarios usuario = null;
        iniciarOperacion();
        usuario = (Usuarios)sesion.createQuery("from Usuarios U WHERE U.username='"+username+"'").uniqueResult();
        terminarOperacion();
        return usuario;
    }
    
    public List<Usuarios> getListaUsuarios(){
        List<Usuarios> listaUsuarios = null;
        iniciarOperacion();
        listaUsuarios = sesion.createQuery("from Usuarios").list();
        terminarOperacion();
        return listaUsuarios;
    }
}
