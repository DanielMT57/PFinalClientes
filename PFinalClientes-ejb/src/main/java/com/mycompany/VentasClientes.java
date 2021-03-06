/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
  * Entity implementation class for Entity: VentasClientes
  * @author  German Andres Velasco Ortiz -gersandres@gmail.com
 */

@Entity
@Table(name = "VentasClientes")
public class VentasClientes implements Serializable {
    private static final long serialVersionUID = 1L;
       
    /*
    *Atributos que se requieren en esta clase
    *Entidades que se relacionan en enta clase
    */ 
    @Id
    @Column(name = "Id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "afiliados_cedula", referencedColumnName = "cedula")   
    private Personas personaCliente;
    @Column(name = "cuotas")
    private int cuotas;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "precioTotal")
    private double precioTotal;
    @Column(name = "saldo")
    private double saldo;    
    @OneToMany(mappedBy = "VentasClientes")
    private List<DetalleVenta> detalleventaCollection;   
    @OneToMany(mappedBy = "Venta")
    private List<Abono> abonos;
    
    /*
    *Metodo constructor sin parametros
    */     

    public VentasClientes() {
    }
    
    /*
    *Metodo constructor con parametros
    */

    public VentasClientes(int id, Personas personaCliente, int cuotas, Date fecha, double precioTotal, double saldo, List<DetalleVenta> detalleventaCollection, List<Abono> abonos) {
        this.id = id;
        this.personaCliente = personaCliente;
        this.cuotas = cuotas;
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.saldo = saldo;
        this.detalleventaCollection = detalleventaCollection;
        this.abonos = abonos;
    }
    
    /*
    * Metodos getters y setters
    */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Personas getPersonaCliente() {
        return personaCliente;
    }

    public void setPersonaCliente(Personas personaCliente) {
        this.personaCliente = personaCliente;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<DetalleVenta> getDetalleventaCollection() {
        return detalleventaCollection;
    }

    public void setDetalleventaCollection(List<DetalleVenta> detalleventaCollection) {
        this.detalleventaCollection = detalleventaCollection;
    }

    public List<Abono> getAbonos() {
        return abonos;
    }

    public void setAbonos(List<Abono> abonos) {
        this.abonos = abonos;
    }
}
