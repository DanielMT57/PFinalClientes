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
  * Entity implementation class for Entity: DetallepedidoPK
  * @author  German Andres Velasco Ortiz -gersandres@gmail.com
 */

@Embeddable
public class DetallepedidoPK implements Serializable {
    
    /*
    *Atributos que se requieren en esta clase
    *Entidades que se relacionan en enta clase
    */

    @Column(name = "pedidos_id")
    private int pedidosId;
    @Column(name = "productos_id")
    private int productosId;
    
    /*
    *Metodo constructor sin parametros
    */
    public DetallepedidoPK() {       
    }
    
    /*
    * Metodo constructor con parametros
    */

    public DetallepedidoPK(int pedidosId, int productosId) {
        this.pedidosId = pedidosId;
        this.productosId = productosId;
    }

    /*
    * Metodos getters y setters
    */     
    
    public int getPedidosId() {
        return pedidosId;
    }

    public void setPedidosId(int pedidosId) {
        this.pedidosId = pedidosId;
    }

    public int getProductosId() {
        return productosId;
    }

    public void setProductosId(int productosId) {
        this.productosId = productosId;
    }
}
