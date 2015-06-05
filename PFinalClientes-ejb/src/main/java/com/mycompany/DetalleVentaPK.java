/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
  * Entity implementation class for Entity: DetalleVentaPK
  * @author  German Andres Velasco Ortiz -gersandres@gmail.com
 */
@Embeddable
public class DetalleVentaPK implements Serializable {
    
    /*
    *Atributos que se requieren en esta clase
    *Entidades que se relacionan en enta clase
    */ 
    
    @Column(name = "productos_id")
    private int productosId;
    @Column(name = "ventasClientes_id")
    private int ventasClientesId;
    
    /*
    * Clase constructora sin parametros
    */

    public DetalleVentaPK() {
    }
    
    /*
    * Clase constructora con parametros
    */

    public DetalleVentaPK(int productosId, int ventasClientesId) {
        this.productosId = productosId;
        this.ventasClientesId = ventasClientesId;
    }
    
    /*
    * Metodos getters y setters
    */ 

    public int getProductosId() {
        return productosId;
    }

    public void setProductosId(int productosId) {
        this.productosId = productosId;
    }

    public int getVentasClientesId() {
        return ventasClientesId;
    }

    public void setVentasClientesId(int ventasClientesId) {
        this.ventasClientesId = ventasClientesId;
    }
}
