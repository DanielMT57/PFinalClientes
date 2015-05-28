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
	@ManyToOne
	@JoinColumn(name = "persona_cedula", referencedColumnName = "cedula")
	private Personas persona;
	private static final long serialVersionUID = 1L;

	public Agenda() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}   
	public Date getHora() {
		return this.hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}
   
}
