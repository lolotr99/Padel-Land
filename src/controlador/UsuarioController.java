/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javasql.Conexion;
import modelo.Usuario;
import javax.swing.JOptionPane;
import utilidades.CifradoUtils;

/**
 *
 * @author Manolo
 */
public class UsuarioController {
    private Conexion conector;
    private Usuario user;
    private Connection con;
    
    public UsuarioController(){
        conector = new Conexion();
        user = new Usuario();
    }
    
    public void insertarUsuario(String nombreCompleto, String username, String password, String telefono, String imagenUsuario, String rol){
        PreparedStatement ps;
        String sql;
        
        user.setNombreCompleto(nombreCompleto);
        user.setUsername(username);
        user.setPassword(CifradoUtils.getMD5(password));
        user.setTelefono(telefono);
        user.setImagenUsuario(imagenUsuario);
        user.setRol(rol);
        
        try {
            con = conector.getConnection();
            sql = "insert into usuarios(nombreCompleto, username, password, telefono, imagenUsuario, rol) values(?,?,?,?,?,?)";
            
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombreCompleto());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getTelefono());
            ps.setString(5, user.getImagenUsuario());
            ps.setString(6, user.getRol());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han insertado los datos");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }
    
    public ResultSet buscarUsuarioPorUserNameAndPassword(String username, String password) {
        PreparedStatement ps;
        String sql;
        ResultSet rs = null;
        user.setUsername(username);
        user.setPassword(CifradoUtils.getMD5(password));
        
        try {
            con = conector.getConnection();
            sql = "select * from usuarios where username = ? and password = ? ";
            
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
        return rs;
    }
}
