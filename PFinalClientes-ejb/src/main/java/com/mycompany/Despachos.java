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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
  * Entity implementation class for Entity: Despachos
  * @author  German Andres Velasco Ortiz -gersandres@gmail.com
 */
@Entity
@Table(name = "Despachos")
public class Despachos implements Serializable  {
    
    /*
    *Atributos que se requieren en esta clase
    *Entidades que se relacionan en enta clase
    */    
    
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
    
    /*
    *Clase constructora sin parametros
    */

    public Despachos() {
    }
    
    /*
    * Clase constructora con parametros
    */
    
    public Despachos(Date fecha, double valor, Character sincronizado,int id) {
        this.id=id;
        this.fecha = fecha;
        this.valor = valor;
        this.sincronizado = sincronizado;
    }

    /*
    * Metodos getters y setters
    */
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Character getSincronizado() {
        return sincronizado;
    }

    public void setSincronizado(Character sincronizado) {
        this.sincronizado = sincronizado;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
