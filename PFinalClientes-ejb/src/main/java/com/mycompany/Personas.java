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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author german
 */
@Entity
@Table(name = "PERSONAS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Personas implements Serializable {

    @Id
    @Column(name = "cedula")
    private int cedula;
    @Column(name = "telefono")
    private Long telefono;
    @Column(name = "Ciudades_Id")
    private String ciudadesId;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "persona")
    private List<Agenda> agendas;
    @OneToOne(mappedBy = "personas")
    private Afiliados afiliados;
    //VentaClientes?

    public Personas() {
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

    public String getCiudadesId() {
        return ciudadesId;
    }

    public void setCiudadesId(String ciudadesId) {
        this.ciudadesId = ciudadesId;
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

    public List<Agenda> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }

    public Afiliados getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(Afiliados afiliados) {
        this.afiliados = afiliados;
    }

}
