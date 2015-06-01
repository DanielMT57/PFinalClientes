/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author german
 */
@Entity
@Table(name = "Despachos")
@PrimaryKeyJoinColumn(name = "Id", referencedColumnName = "Id")
public class Despachos extends Pedidos implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "pedidos_id", referencedColumnName = "id")
    private Pedidos pedidos;    
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "valor")
    private double valor;
    @Column(name = "sincronizado")
    private Character sincronizado;

    public Despachos() {
    }

    public Despachos(Pedidos pedidos, Date fecha, double valor, Character sincronizado) {
        this.pedidos = pedidos;
        this.fecha = fecha;
        this.valor = valor;
        this.sincronizado = sincronizado;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    } 
}
