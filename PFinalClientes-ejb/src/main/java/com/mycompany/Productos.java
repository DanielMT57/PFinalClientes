/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author german
 */

@Entity
@Table(name = "Productos")
public class Productos implements Serializable {
	@Id
	@Column(name = "id")
	private int id;       
        @Column(name = "color_id")
	private String color;
        @Column(name = "categoria_id")
	private String categoria;
        @Column(name = "marca_id")
	private String marca;
        @Column(name = "Cantidad")
	private int cantidad;       
	@Column(name = "peso")
	private int peso;
	@Column(name = "precioCompra")
	private double precioCompra;
	@Column(name = "precioVenta")
	private double precioVenta;
	@Column(name = "descripcion")
	private String descripcion;
	@OneToMany(mappedBy = "productos")
	private List<Detallepedido> detallepedidoProductos;
	@OneToMany(mappedBy = "productosId")
	private List<Promociones> promocionesProductos;
	@OneToMany(mappedBy = "productosId")
	private List<Areaspagina> areaspaginaProductos;
	@OneToMany(mappedBy = "productos")
	private List<DetalleVenta> detalleventaProductos;

    public Productos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Detallepedido> getDetallepedidoProductos() {
        return detallepedidoProductos;
    }

    public void setDetallepedidoProductos(List<Detallepedido> detallepedidoProductos) {
        this.detallepedidoProductos = detallepedidoProductos;
    }

    public List<Promociones> getPromocionesProductos() {
        return promocionesProductos;
    }

    public void setPromocionesProductos(List<Promociones> promocionesProductos) {
        this.promocionesProductos = promocionesProductos;
    }

    public List<Areaspagina> getAreaspaginaProductos() {
        return areaspaginaProductos;
    }

    public void setAreaspaginaProductos(List<Areaspagina> areaspaginaProductos) {
        this.areaspaginaProductos = areaspaginaProductos;
    }

    public List<DetalleVenta> getDetalleventaProductos() {
        return detalleventaProductos;
    }

    public void setDetalleventaProductos(List<DetalleVenta> detalleventaProductos) {
        this.detalleventaProductos = detalleventaProductos;
    }

	
}
