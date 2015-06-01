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
import com.mycompany.Productos;
import com.mycompany.sessionbeans.ProductoClientesEJB;
        
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author german
 */
@ManagedBean
@Named(value = "ProductoBean")
@ViewScoped
public class ProductoBean implements Serializable {


    @EJB
    ProductoClientesEJB productosEJB;
    
    @EJB
    private CatalogoClienteEJB catalogClienteEJB;
 
    
   private List<Productos> productos;

    public List<Productos> getProductos() {
        productos=productosEJB.listarTodos();
        return productos;
    }
   

    
}

