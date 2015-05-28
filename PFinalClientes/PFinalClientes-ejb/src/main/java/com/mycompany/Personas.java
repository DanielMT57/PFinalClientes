/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author german
 */
@Entity
@Table(name = "PERSONAS")
@Inheritance(strategy=InheritanceType.JOINED)
public class Personas implements Serializable {
    @Id
    @Column(name = "cedula")
    private int cedula;
    @Column(name = "telefono")
    private Long telefono;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "email")
    private String email;
    @ManyToOne
    @JoinColumn(name = "ciudadesId_id", referencedColumnName = "id")
	private String ciudadesId;
    @OneToMany(mappedBy = "persona")
	private List<Agenda> agendas;
    @OneToOne(mappedBy = "personas")
    private Afiliados afiliados;

    public Personas() {
    }

    public Personas(int cedula, Long telefono, String nombre, String apellidos, String direccion, String email, String ciudadesId, Afiliados afiliados) {
        this.cedula = cedula;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
        this.ciudadesId = ciudadesId;
        this.afiliados = afiliados;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudadesId() {
        return ciudadesId;
    }

    public void setCiudadesId(String ciudadesId) {
        this.ciudadesId = ciudadesId;
    }

    public Afiliados getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(Afiliados afiliados) {
        this.afiliados = afiliados;
    }

    
}
