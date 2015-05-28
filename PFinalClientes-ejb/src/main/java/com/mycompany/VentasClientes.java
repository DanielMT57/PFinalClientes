/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author german
 */
@Entity
@Table(name = "VentasClientes")
public class VentasClientes implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "Id")
    private int id;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "sincronizado")
    private Character sincronizado;
    private String descripcion;
    private String estadoId;
    private int saldo;
    @JoinColumn(name = "afiliados_cedula", referencedColumnName = "cedula")
    @ManyToOne
    private Afiliados afiliadosCedula;
    @OneToMany(mappedBy = "pedidos")
    private List<DetalleVenta> detalleventaCollection;

    @OneToMany(mappedBy = "venta")
	private List<Abono> abonos;
    public VentasClientes() {
    }

    
    
    
    public VentasClientes(int id, Date fecha, Character sincronizado,
			String descripcion, String estadoId, int saldo,
			Afiliados afiliadosCedula,
			List<DetalleVenta> detalleventaCollection) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.sincronizado = sincronizado;
		this.descripcion = descripcion;
		this.estadoId = estadoId;
		this.saldo = saldo;
		this.afiliadosCedula = afiliadosCedula;
		this.detalleventaCollection = detalleventaCollection;
	}




	public int getSaldo() {
		return saldo;
	}



	public void setSaldo(int saldo) {
		this.saldo = saldo;
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

    public Character getSincronizado() {
        return sincronizado;
    }

    public void setSincronizado(Character sincronizado) {
        this.sincronizado = sincronizado;
    }

    public String getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(String estadoId) {
        this.estadoId = estadoId;
    }

    public Afiliados getAfiliadosCedula() {
        return afiliadosCedula;
    }

    public void setAfiliadosCedula(Afiliados afiliadosCedula) {
        this.afiliadosCedula = afiliadosCedula;
    }

     
	public List<DetalleVenta> getDetalleventaCollection() {
		return detalleventaCollection;
	}




	public void setDetalleventaCollection(List<DetalleVenta> detalleventaCollection) {
		this.detalleventaCollection = detalleventaCollection;
	}




	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
    
   
}
