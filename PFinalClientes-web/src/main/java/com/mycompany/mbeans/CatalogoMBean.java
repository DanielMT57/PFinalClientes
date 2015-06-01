/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mbeans;

import com.mycompany.Catalogo;
import com.mycompany.sessionbeans.CatalogoClienteEJB;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author german
 */
@ManagedBean
@Named(value = "catalogoMBean")
@ViewScoped
public class CatalogoMBean implements Serializable {

    private int id;
    private Date fechaInicio;
    private Date fechaFin;
    private int cantidadPaginas;
    private int cantidadProductos;
    
    
    @EJB
    private CatalogoClienteEJB catalogClienteEJB;
 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public CatalogoClienteEJB getCatalogoejb() {
        return catalogClienteEJB;
    }

    public void setCatalogoejb(CatalogoClienteEJB catalogoejb) {
        this.catalogClienteEJB = catalogoejb;
    }

    private List<Catalogo> catalogos;

  
    public List<Catalogo> getCatalogos() {
        catalogos=catalogClienteEJB.listarTodos();
        return catalogos;
    }


    private void limpiar() {
        setId(0);
        setFechaInicio(null);
        setFechaFin(null);
        setCantidadPaginas(0);
        setCantidadProductos(0);
    }
}
