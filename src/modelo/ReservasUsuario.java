/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Manolo
 */
public class ReservasUsuario {
    private String nombrePista;
    private Date horaComienzo;
    private Date dia;

    public ReservasUsuario(String nombrePista, Date horaComienzo, Date dia) {
        this.nombrePista = nombrePista;
        this.horaComienzo = horaComienzo;
        this.dia = dia;
    }

    public String getNombrePista() {
        return nombrePista;
    }

    public void setNombrePista(String nombrePista) {
        this.nombrePista = nombrePista;
    }

    public Date getHoraComienzo() {
        return horaComienzo;
    }

    public void setHoraComienzo(Date horaComienzo) {
        this.horaComienzo = horaComienzo;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }
    
    
    
}
