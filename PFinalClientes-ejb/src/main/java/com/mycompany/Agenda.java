package com.mycompany;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import static javax.persistence.TemporalType.TIME;

/**
 * Entity implementation class for Entity: Agenda
 *
 */
@Entity

public class Agenda implements Serializable {

    @Id
    private int id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Temporal(TIME)
    private Date hora;
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "persona_cedula", referencedColumnName = "cedula")
    private Personas persona;
    private static final long serialVersionUID = 1L;

	public Agenda() {
		super();
	}   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Personas getPersona() {
        return persona;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }

}
