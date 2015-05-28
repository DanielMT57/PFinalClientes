/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author german
 */
@Embeddable
public class DetalleVentaPK implements Serializable {
    private int ventasId;
    private int productosId;

    public DetalleVentaPK() {
    }

    public DetalleVentaPK(int ventasId, int productosId) {
        this.ventasId = ventasId;
        this.productosId = productosId;
    }

    public int getventasId() {
        return ventasId;
    }

    public void setventasId(int ventasId) {
        this.ventasId = ventasId;
    }

    public int getProductosId() {
        return productosId;
    }

    public void setProductosId(int productosId) {
        this.productosId = productosId;
    }

}
