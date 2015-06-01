/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author german
 */
@Entity
@Table(name = "Afiliados")
@PrimaryKeyJoinColumn(name = "cedula", referencedColumnName = "cedula")
public class Afiliados extends Personas  {
    
    @OneToOne
    @JoinColumn(name = "afiliados_cedula", referencedColumnName = "cedula")
    private Afiliados afiliadosCollection;
    
    @ManyToOne
    @JoinColumn(name = "nivel_id", referencedColumnName = "id")
    private Niveles nivel;
    
    @Column(name = "fechaafiliacion")
    @Temporal(TemporalType.DATE)
     private Date fechaafiliacion;

   
    @Column(name = "SINCRONIZADO")
    private Character sincronizado;
    
    @OneToMany(mappedBy = "afiliados_Cedula")
    private List<Pedidos> pedidosCollection;

    @OneToOne
    @JoinColumn(name = "personas_cedula", referencedColumnName = "cedula")
    private Personas personas;

    //    @OneToOne
//    @JoinColumn(name = "personas_cedula", referencedColumnName = "cedula")
//	private Personas personas;
    public Afiliados() {
    }

    public Afiliados(Niveles nivel, Date fechaafiliacion, Character sincronizado, List<Pedidos> pedidosCollection, Personas personas, Afiliados afiliadosCollection, int cedula, Long telefono, String nombre, String apellidos, String direccion, String email, String ciudadesId, Afiliados afiliados) {
        super();
        this.nivel = nivel;
        this.fechaafiliacion = fechaafiliacion;
        this.sincronizado = sincronizado;
        this.pedidosCollection = pedidosCollection;
        this.personas = personas;
        this.afiliadosCollection = afiliadosCollection;
    }
    
    

    public Niveles getNivel() {
        return nivel;
    }

    public void setNivel(Niveles nivel) {
        this.nivel = nivel;
    }

    public Date getFechaafiliacion() {
        return fechaafiliacion;
    }

    public void setFechaafiliacion(Date fechaafiliacion) {
        this.fechaafiliacion = fechaafiliacion;
    }

    public Character getSincronizado() {
        return sincronizado;
    }

    public void setSincronizado(Character sincronizado) {
        this.sincronizado = sincronizado;
    }

    public List<Pedidos> getPedidosCollection() {
        return pedidosCollection;
    }

    public void setPedidosCollection(List<Pedidos> pedidosCollection) {
        this.pedidosCollection = pedidosCollection;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    public Afiliados getAfiliadosCollection() {
        return afiliadosCollection;
    }

    public void setAfiliadosCollection(Afiliados afiliadosCollection) {
        this.afiliadosCollection = afiliadosCollection;
    }

}
