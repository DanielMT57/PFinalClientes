/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mbeans;

import com.mycompany.Afiliados;
import com.mycompany.DetalleVenta;

import com.mycompany.Productos;
import com.mycompany.VentasClientes;
import com.mycompany.sessionbeans.AfiliadosEJB;
import com.mycompany.sessionbeans.DetalleVentaEJB;
import com.mycompany.sessionbeans.ProductoClientesEJB;
import com.mycompany.sessionbeans.VentasClientesEJB;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
        
        

        

/**
 *
 * @author MAO
 */
@ManagedBean
@Named(value = "ventaManagedBean")
@ViewScoped
public class VentaManagedBean implements Serializable{

  
    
    @EJB
    private VentasClientesEJB ventasEJB;
    @EJB
    private  DetalleVentaEJB detalleEJB;
    @EJB
    private  ProductoClientesEJB productoEJB;
    @EJB
    private AfiliadosEJB afiliadosEJB;
    
    private int id;
    private int afiliadoCedula;
    private int cuota;
    private Date fecha;
    private double preciototal;
    private double saldo;
    
    private int productoId;  
    private int cantidad;
    private double preciounitario;
    
    private List<Productos>  productos;
     private List<Afiliados> afiliados;

    public AfiliadosEJB getAfiliadosEJB() {
        return afiliadosEJB;
    }

    public void setAfiliadosEJB(AfiliadosEJB afiliadosEJB) {
        this.afiliadosEJB = afiliadosEJB;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }
     
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAfiliadoCedula() {
        return afiliadoCedula;
    }

    public void setAfiliadoCedula(int afiliadoCedula) {
        this.afiliadoCedula = afiliadoCedula;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(double preciototal) {
        this.preciototal = preciototal;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
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
  
    
    @PostConstruct
    public void postConstruct() {

        afiliados = afiliadosEJB.listarTodos();     
        productos = productoEJB.listarTodos();

    }

    public List<Afiliados> getAfiliados() {
        return afiliados;
    }
    
    
    public void crearVenta(){
    VentasClientes v = new VentasClientes();
    v.setId(id);
    v.setPersonaCliente(afiliadosEJB.buscar(afiliadoCedula));
    v.setCuotas(cuota);             
    }
    
    
    
}
