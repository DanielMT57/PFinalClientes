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
 *
 * @author german
 */
@Entity
@Table(name = "Promociones")
public class Promociones implements Serializable {

    @Id
    @Column(name = "Id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "productosId_id", referencedColumnName = "id")
    private Productos productosId;
    @Column(name = "cantidad")
    private int cantidad;   
    @Column(name = "descripcion")
    private String descripcion;   
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @Column(name = "descuento")
    private Short descuento;
    @Column(name = "preciofinal")
    private int preciofinal;
    @OneToMany(mappedBy = "promocionesId")
    private List<Areaspagina> areaspaginaCollection;

    public Promociones() {
    }

    public Promociones(int id, Productos productosId, int cantidad, String descripcion, Date fechafin, Short descuento, int preciofinal, List<Areaspagina> areaspaginaCollection) {
        this.id = id;
        this.productosId = productosId;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.fechafin = fechafin;
        this.descuento = descuento;
        this.preciofinal = preciofinal;
        this.areaspaginaCollection = areaspaginaCollection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Productos getProductosId() {
        return productosId;
    }

    public void setProductosId(Productos productosId) {
        this.productosId = productosId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Short getDescuento() {
        return descuento;
    }

    public void setDescuento(Short descuento) {
        this.descuento = descuento;
    }

    public int getPreciofinal() {
        return preciofinal;
    }

    public void setPreciofinal(int preciofinal) {
        this.preciofinal = preciofinal;
    }

    public List<Areaspagina> getAreaspaginaCollection() {
        return areaspaginaCollection;
    }

    public void setAreaspaginaCollection(List<Areaspagina> areaspaginaCollection) {
        this.areaspaginaCollection = areaspaginaCollection;
    }

   
}
