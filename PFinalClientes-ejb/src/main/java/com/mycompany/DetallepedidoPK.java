/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author german
 */
@Embeddable
public class DetallepedidoPK implements Serializable {
    private int pedidosId;
    private int productosId;

    public DetallepedidoPK() {
    }

    public DetallepedidoPK(int pedidosId, int productosId) {
        this.pedidosId = pedidosId;
        this.productosId = productosId;
    }

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
