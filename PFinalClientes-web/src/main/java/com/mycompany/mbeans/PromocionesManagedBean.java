/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mbeans;

import java.util.Date;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import com.mycompany.sessionbeans.ProductoClientesEJB;
import com.mycompany.sessionbeans.PromocionesEJB;
import com.mycompany.Productos;
import com.mycompany.Promociones;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author German Andres Velasco Ortiz -gersandres@gmail.com
 */
@ManagedBean
@Named(value = "promocionesManagedBean")
@ViewScoped
public class PromocionesManagedBean implements Serializable {

    /**
     * atributos de la pagina promociones
     */
    private int id;
    private int productosId;
    private String descripcion;
    private Date fechafin;
    private short descuento;
    private double preciofinal;
    private int cantidad;
    
    /*
    * Instancio los ejbs necesarios 
    */
    @EJB
    private ProductoClientesEJB productosEJB; 
    @EJB
    private PromocionesEJB promocionesEJB;
    
    /*
    * listado de promociones
    */
    private List<Promociones> promociones;
    
    /*
    * Getters y setters de los atributos
    */
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductosId() {
        return productosId;
    }

    public void setProductosId(int productosId) {
        this.productosId = productosId;
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

    public short getDescuento() {
        return descuento;
    }

    public void setDescuento(short descuento) {
        this.descuento = descuento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /*
    * Metodo get de las promociones y las carga en la pagina
    */

    public List<Promociones> getPromociones() {
        promociones = promocionesEJB.listarTodos();
        return promociones;
    }

    public double getPreciofinal() {
        return preciofinal;
    }

    public void setPreciofinal(double preciofinal) {
        this.preciofinal = preciofinal;
    }
    private List<Productos> productos;

    @PostConstruct
    public void postConstruct() {
        productos = productosEJB.listarTodos();
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }

    /**
     * Metodo que me calcula el precio de venta de los productos en promocion
     */
    public void actualizar() {
        Productos p = productosEJB.buscar(productosId);
        preciofinal = p.getPrecioVenta();
    }

    /**
     * Metodo que crea las promociones
     */
    public void crearPromociones() {
        try {

            Promociones pe = new Promociones();
            pe.setId(id);
            pe.setDescripcion(descripcion);
            pe.setFechafin(fechafin);
            pe.setCantidad(cantidad);
            int precioTotal = (int) (preciofinal * cantidad);
            precioTotal = precioTotal - (precioTotal * descuento / 100);
            System.out.println(descuento);
            System.out.println(precioTotal);
            pe.setPreciofinal(precioTotal);
            pe.setProductosId(productosEJB.buscar(productosId));
            pe.setDescuento(descuento);
            promocionesEJB.crear(pe);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Ha insertado correctamente  "));
            System.out.println("ha insertado correctamente");
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Error-----  "));

            e.getMessage();
        }

    }
    
    /**
     * Metodo que elimina la promocion
     */
    public void eliminarPromo() {
        try {
            Promociones p = promocionesEJB.buscar(id);

            promocionesEJB.eliminar(p);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Ha eliminado correctamente  "));
            System.out.println("ha eliminado  correctamente");
            limpiar();
        } catch (Exception e) {
            e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "no se ha podido eliminar el producto por que esta asignado a un registro  "));

        }

    }
    
     /**
     * Metodo que busca las promociones que han sido insertadas
     */

    public void buscarPromociones() {
        Promociones p = promocionesEJB.buscar(id);
        if (p != null) {
            preciofinal = p.getPreciofinal();
            descuento = p.getDescuento();
            fechafin = p.getFechafin();
            descripcion = p.getDescripcion();
            cantidad = p.getCantidad();
            productosId = p.getProductosId().getId();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Ha encontrado correctamente "));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informacion", "No se encontro nada "));
        }

        System.out.println("ha encontrado  correctamente");

    }
    
    /*
    * Metodo que limpia los campos de texto
    */

    private void limpiar() {
        setDescripcion(null);
        setDescuento(Short.MAX_VALUE);
        setFechafin(null);
        setPreciofinal(0);
        setId(0);

    }

}
