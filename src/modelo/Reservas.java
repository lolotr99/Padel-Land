package modelo;
// Generated 27-may-2022 20:07:28 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Reservas generated by hbm2java
 */
public class Reservas  implements java.io.Serializable {


     private Long id;
     private Horarios horarios;
     private Pistas pistas;
     private Usuarios usuarios;
     private Date dia;

    public Reservas() {
    }

    public Reservas(Horarios horarios, Pistas pistas, Usuarios usuarios, Date dia) {
       this.horarios = horarios;
       this.pistas = pistas;
       this.usuarios = usuarios;
       this.dia = dia;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Horarios getHorarios() {
        return this.horarios;
    }
    
    public void setHorarios(Horarios horarios) {
        this.horarios = horarios;
    }
    public Pistas getPistas() {
        return this.pistas;
    }
    
    public void setPistas(Pistas pistas) {
        this.pistas = pistas;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    public Date getDia() {
        return this.dia;
    }
    
    public void setDia(Date dia) {
        this.dia = dia;
    }




}


