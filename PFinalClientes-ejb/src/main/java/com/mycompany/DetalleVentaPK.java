/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author german
 */
@Embeddable
public class DetalleVentaPK implements Serializable {
    
    
    @Column(name = "productos_id")
    private int productosId;
    @Column(name = "ventasClientes_id")
    private int ventasClientesId;

    public DetalleVentaPK() {
    }

    public DetalleVentaPK(int productosId, int ventasClientesId) {
        this.productosId = productosId;
        this.ventasClientesId = ventasClientesId;
    }

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
