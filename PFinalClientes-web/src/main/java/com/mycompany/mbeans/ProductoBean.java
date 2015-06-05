/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mbeans;

import com.mycompany.sessionbeans.CatalogoClienteEJB;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import com.mycompany.Productos;
import com.mycompany.sessionbeans.ProductoClientesEJB;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author German Andres Velasco Ortiz -gersandres@gmail.com
 */
@ManagedBean
@Named(value = "ProductoBean")
@ViewScoped

/*
 * Controlador de la pagina productos
 */
public class ProductoBean implements Serializable {

    /*
     * Instancio los ejbs necesarios en este caso de prodcutos
     */
    @EJB
    ProductoClientesEJB productosEJB;  
    @EJB
    private CatalogoClienteEJB catalogClienteEJB;
    
    /*
    * Lista de productos
    */
    private List<Productos> productos;

    /*
     * Cargo los productos persistidos en la base de datos
     */
    public List<Productos> getProductos() {
        productos = productosEJB.listarTodos();
        return productos;
    }
}
