package modelo;
// Generated 27-may-2022 20:07:28 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * DiasNoDisponibles generated by hbm2java
 */
public class DiasNoDisponibles  implements java.io.Serializable {
    
     private Long id;
     private Date dia;

    public DiasNoDisponibles() {
    }

    public DiasNoDisponibles(Date dia) {
       this.dia = dia;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDia() {
        return this.dia;
    }
    
    public void setDia(Date dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return "DiasNoDisponibles{" + "id=" + id + ", dia=" + dia + '}';
    }

}


