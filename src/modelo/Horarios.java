package modelo;
// Generated 27-may-2022 20:07:28 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Horarios generated by hbm2java
 */
public class Horarios  implements java.io.Serializable {
    
     private Long id;
     private String turno;
     private Date horaComienzo;
     private Set reservases = new HashSet(0);

    public Horarios() {
    }
    
    public Horarios(String turno, Date horaComienzo) {
        this.turno = turno;
        this.horaComienzo = horaComienzo;
    }
    public Horarios(String turno, Date horaComienzo, Set reservases) {
       this.turno = turno;
       this.horaComienzo = horaComienzo;
       this.reservases = reservases;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getTurno() {
        return this.turno;
    }
    
    public void setTurno(String turno) {
        this.turno = turno;
    }
    public Date getHoraComienzo() {
        return this.horaComienzo;
    }
    
    public void setHoraComienzo(Date horaComienzo) {
        this.horaComienzo = horaComienzo;
    }
    public Set getReservases() {
        return this.reservases;
    }
    
    public void setReservases(Set reservases) {
        this.reservases = reservases;
    }




}


