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
import javax.persistence.Id;
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
    
     @Id
    @Column(name = "Pedidos_id")
    private int id;  
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "valor")
    private double valor;
    @Column(name = "sincronizado")
    private Character sincronizado;

    public Despachos() {
    }

    public Despachos( Date fecha, double valor, Character sincronizado, int id) {
        this.fecha = fecha;
        this.valor = valor;
        this.sincronizado = sincronizado;
        this.id=id;
    }

    

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    } 
}
