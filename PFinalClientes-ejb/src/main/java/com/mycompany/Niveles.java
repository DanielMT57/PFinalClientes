/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
  * Entity implementation class for Entity: Niveles
  * @author  German Andres Velasco Ortiz -gersandres@gmail.com
 */

@Entity
@Table(name="niveles")
public class Niveles implements Serializable{
    
    /*
    *Atributos que se requieren en esta clase
    *Entidades que se relacionan en enta clase
    */
    
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "NumVentas")
    private int numVentas;
    @Column(name = "NumAfiliados")
    private int numAfiliados;
    @Column(name = "descuento")
    private int descuento;
    @OneToMany(mappedBy = "nivel")
    private List<Afiliados> afiliados;
    
    /*
    *Metodo constructor sin parametros
    */

    public Niveles() {
    }
    
    /*
    *Metodo constructor conparametros
    */

    public Niveles(int id, String descripcion, int numVentas, int numAfiliados, int descuento, List<Afiliados> afiliados) {
        this.id = id;
        this.descripcion = descripcion;
        this.numVentas = numVentas;
        this.numAfiliados = numAfiliados;
        this.descuento = descuento;
        this.afiliados = afiliados;
    }

    /*
    * Metodos getters y setters
    */ 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }

    public int getNumAfiliados() {
        return numAfiliados;
    }

    public void setNumAfiliados(int numAfiliados) {
        this.numAfiliados = numAfiliados;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public List<Afiliados> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(List<Afiliados> afiliados) {
        this.afiliados = afiliados;
    }  
}
