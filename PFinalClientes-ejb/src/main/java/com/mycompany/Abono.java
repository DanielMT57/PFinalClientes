package com.mycompany;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import static javax.persistence.TemporalType.DATE;

/**
 * Entity implementation class for Entity: Abono
 *
 */
@Entity

public class Abono implements Serializable {

	   
	@Id
	private int id;
	@Temporal(DATE)
	private Date fecha;
	private int pago;
	@ManyToOne
	@JoinColumn(name = "venta_Id", referencedColumnName = "Id")
	private VentasClientes venta;
	private static final long serialVersionUID = 1L;

	public Abono() {
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
	public int getPago() {
		return this.pago;
	}

	public void setPago(int pago) {
		this.pago = pago;
	}
   
}
