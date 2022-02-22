package modelo;
// Generated 12-feb-2022 12:26:16 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuarios generated by hbm2java
 */
public class Usuarios  implements java.io.Serializable {


     private Long id;
     private String nombreCompleto;
     private String username;
     private String password;
     private String telefono;
     private String imagenUsuario;
     private String rol;
     private Set reservases = new HashSet(0);

    public Usuarios() {
    }

	
    public Usuarios(String nombreCompleto, String username, String password, String telefono, String rol) {
        this.nombreCompleto = nombreCompleto;
        this.username = username;
        this.password = password;
        this.telefono = telefono;
        this.rol = rol;
    }
    public Usuarios(String nombreCompleto, String username, String password, String telefono, String imagenUsuario, String rol, Set reservases) {
       this.nombreCompleto = nombreCompleto;
       this.username = username;
       this.password = password;
       this.telefono = telefono;
       this.imagenUsuario = imagenUsuario;
       this.rol = rol;
       this.reservases = reservases;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombreCompleto() {
        return this.nombreCompleto;
    }
    
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getImagenUsuario() {
        return this.imagenUsuario;
    }
    
    public void setImagenUsuario(String imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
    }
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    public Set getReservases() {
        return this.reservases;
    }
    
    public void setReservases(Set reservases) {
        this.reservases = reservases;
    }




}


