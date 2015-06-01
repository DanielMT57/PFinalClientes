/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author german
 */
@Entity
@Table(name = "DetalleVenta")
public class DetalleVenta implements Serializable {
    
    @EmbeddedId
    protected DetalleVentaPK DetalleVentaPK;

    @MapsId("ventasClientesId")
    @ManyToOne
    @JoinColumn(name = "ventasclientes_id", referencedColumnName = "Id")
    private VentasClientes ventasClientes;
    
    @MapsId("productosId")
    @ManyToOne
    @JoinColumn(name = "Productos_id", referencedColumnName = "Id")
    private Productos productos;
    
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "preciounitario")
    private double preciounitario;

    public DetalleVenta() {
    }

    public DetalleVenta(DetalleVentaPK DetalleVentaPK, VentasClientes ventasClientes, Productos productos, int cantidad, double preciounitario) {
        this.DetalleVentaPK = DetalleVentaPK;
        this.ventasClientes = ventasClientes;
        this.productos = productos;
        this.cantidad = cantidad;
        this.preciounitario = preciounitario;
    }

    public DetalleVentaPK getDetalleVentaPK() {
        return DetalleVentaPK;
    }

    public void setDetalleVentaPK(DetalleVentaPK DetalleVentaPK) {
        this.DetalleVentaPK = DetalleVentaPK;
    }

    public VentasClientes getVentasClientes() {
        return ventasClientes;
    }

    public void setVentasClientes(VentasClientes ventasClientes) {
        this.ventasClientes = ventasClientes;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(double preciounitario) {
        this.preciounitario = preciounitario;
    }

   
   
}
