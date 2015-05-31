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
import javax.persistence.Table;

/**
 *
 * @author german
 */
@Entity
@Table(name = "DetalleVenta")
public class DetalleVenta implements Serializable {

    @ManyToOne
    @JoinColumn(name = "productos_id", referencedColumnName = "id")
    private Productos productos;
    @ManyToOne
    @JoinColumn(name = "venta_Id", referencedColumnName = "Id")
    private VentasClientes venta;
    @EmbeddedId
    protected DetallepedidoPK detallepedidoPK;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "preciounitario")
    private double preciounitario;

    public DetalleVenta() {
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public VentasClientes getVenta() {
        return venta;
    }

    public void setVenta(VentasClientes venta) {
        this.venta = venta;
    }

    public DetallepedidoPK getDetallepedidoPK() {
        return detallepedidoPK;
    }

    public void setDetallepedidoPK(DetallepedidoPK detallepedidoPK) {
        this.detallepedidoPK = detallepedidoPK;
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
