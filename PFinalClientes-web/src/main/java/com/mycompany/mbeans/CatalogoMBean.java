/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mbeans;

import com.mycompany.sessionbeans.CatalogoClienteEJB;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;

/**
 *
 * @author german
 */
@ManagedBean
@Named(value = "catalogoMBean")
@ViewScoped
public class CatalogoMBean implements Serializable{
    private int id;
    private Date fechaInicio;
    private Date fechaFin;
    private int cantidadPaginas;
    private int cantidadProductos;

    @EJB
    private CatalogoClienteEJB catalogoejb;
  

    /**
     * Creates a new instance of CatalogoMBean
     */ 
}
