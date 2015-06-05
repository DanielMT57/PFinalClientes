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
import javax.persistence.Table;
import org.eclipse.persistence.annotations.ClassExtractor;

/**
  * Entity implementation class for Entity: Personas
  * @author  German Andres Velasco Ortiz -gersandres@gmail.com
 */

@Entity
@Table(name = "PERSONAS")
@Inheritance(strategy = InheritanceType.JOINED)
@ClassExtractor(PersonasExtractor.class)
public class Personas implements Serializable {
    
    /*
    *Atributos que se requieren en esta clase
    *Entidades que se relacionan en enta clase
    */

    @Id
    @Column(name = "cedula")
    private int cedula;
    @Column(name = "Ciudades_Id")
    private String ciudadesId;
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
    @OneToMany(mappedBy = "persona")
    private List<Agenda> agendas;
    @OneToMany(mappedBy = "personaCliente")
    private List<VentasClientes> ventaClientes;
    
    /*
    *Metodo constructor sin parametros
    */

    public Personas() {
    }
    
    /*
    *Metodo constructor con parametros
    */

    public Personas(int cedula, String ciudadesId, Long telefono, String nombre, String apellidos, String direccion, String email, List<Agenda> agendas, List<VentasClientes> ventaClientes) {
        this.cedula = cedula;
        this.ciudadesId = ciudadesId;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
        this.agendas = agendas;
        this.ventaClientes = ventaClientes;
    }
    
    /*
    * Metodos getters y setters
    */     

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCiudadesId() {
        return ciudadesId;
    }

    public void setCiudadesId(String ciudadesId) {
        this.ciudadesId = ciudadesId;
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

    public List<Agenda> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }

    public List<VentasClientes> getVentaClientes() {
        return ventaClientes;
    }

    public void setVentaClientes(List<VentasClientes> ventaClientes) {
        this.ventaClientes = ventaClientes;
    }

    
   
}
