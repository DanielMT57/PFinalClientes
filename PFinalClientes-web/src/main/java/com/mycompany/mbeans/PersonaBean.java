/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mbeans;


import com.mycompany.Niveles;
import com.mycompany.Personas;
import com.mycompany.Afiliados;


import com.mycompany.sessionbeans.PersonaEJB;
import com.mycompany.sessionbeans.NivelesEJB;
import com.mycompany.sessionbeans.AfiliadosEJB;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author german
 */
@ManagedBean
@Named(value = "personaBean")
@ViewScoped

public class PersonaBean implements Serializable {

    private int cedula;
    private int idCiudades;
    private long telefono;
    private String nombre;
    private String apellido;
    private String direccion;
    private String email;
    private String ciudad;
    private List<Niveles> niveles;
    private List<Afiliados> afiliados;
    private int personaId;

    public List<Niveles> getNiveles() {
        return niveles;
    }
    

    @EJB
    private PersonaEJB personasEJB;
 

    @EJB
    private NivelesEJB nivelesEJB;

    @EJB
    private AfiliadosEJB afiliadosEJB;
    


    private Date fechaAfiliacion;

    private int idNiveles;

    /**
     * Creates a new instance of PersonaManagedBean
     */
    @PostConstruct
    public void postConstruct() {
        personas=personasEJB.listarTodos();     
        niveles=nivelesEJB.listarTodos();
        ciudades=afiliadosEJB.getCiudades();

    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getIdCiudades() {
        return idCiudades;
    }

    public void setIdCiudades(int idCiudades) {
        this.idCiudades = idCiudades;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

  



  
  


 

    public Date getFechaAfiliacion() {
        return fechaAfiliacion;
    }

    public void setFechaAfiliacion(Date fechaAfiliacion) {
        this.fechaAfiliacion = fechaAfiliacion;
    }

    public int getIdNiveles() {
        return idNiveles;
    }

    public void setIdNiveles(int idNiveles) {
        this.idNiveles = idNiveles;
    }

    public void crearPersonas() {

        Personas pe = new Personas();
        pe.setCedula(cedula);
        pe.setTelefono(telefono);
        pe.setNombre(nombre);
        pe.setApellidos(apellido);
        pe.setDireccion(direccion);
        pe.setEmail(email);
        pe.setCiudadesId(ciudad);
        
//        personasEJB.crear(pe);
        Afiliados a= afiliadosEJB.buscar(personaId);
        //pe=personasEJB.buscar(pe.getCedula());
        Afiliados af = new Afiliados(nivelesEJB.buscar(idNiveles), fechaAfiliacion, '0', null, null, cedula, telefono, nombre, apellido, direccion, email, ciudad, a);
    

//        af.setCedula(pe.getCedula());
//        af.setNivel();

        afiliadosEJB.crear(af);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Ha insertado correctamente "));
        System.out.println("ha insertado correctamente");
        limpiar();

    }

    public void buscarPersona() {
        Personas p = personasEJB.buscar(cedula);
        Afiliados af = afiliadosEJB.buscar(cedula);
        if (p != null) {

            telefono = p.getTelefono();
            direccion = p.getDireccion();
            email = p.getEmail();
            nombre = p.getNombre();
            apellido = p.getApellidos();
           ciudad=p.getCiudadesId();
            idNiveles = af.getNivel().getId();
            fechaAfiliacion = af.getFechaafiliacion();
            if(af.getAfiliadosCollection()!=null){
                personaId=af.getAfiliadosCollection().getCedula();
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Ha encontrado correctamente "));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informacion", "No se encontro nada "));
        }

        System.out.println("ha encontrado  correctamente");
        //   limpiar ();

    }
     private List<Personas> personas;
          private List<String> ciudades;

    public List<String> getCiudades() {
        return ciudades;
    }
          
          

    public List<Personas> getPersonas() {
       personas= personasEJB.listarTodos();
        return personas;
    }
//     
//     
//
    private void limpiar() {

        this.setCedula(0);
        this.setApellido(null);
        this.setEmail(null);
        this.setNombre(null);
        this.setTelefono(0);
        this.setDireccion(null);

        this.setFechaAfiliacion(null);
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public List<Afiliados> getAfiliados() {
        afiliados=afiliadosEJB.listarTodos();
        return afiliados;
    }
    
    
        public void editarPersonas() {

        Personas pe = new Personas();
        pe.setCedula(cedula);
        pe.setTelefono(telefono);
        pe.setNombre(nombre);
        pe.setApellidos(apellido);
        pe.setDireccion(direccion);
        pe.setEmail(email);
        pe.setCiudadesId(ciudad);
        
//        personasEJB.crear(pe);
        Afiliados a= afiliadosEJB.buscar(personaId);
        //pe=personasEJB.buscar(pe.getCedula());
        Afiliados af = new Afiliados(nivelesEJB.buscar(idNiveles), fechaAfiliacion, '0', null, null, cedula, telefono, nombre, apellido, direccion, email, ciudad, a);
    

//        af.setCedula(pe.getCedula());
//        af.setNivel();

        afiliadosEJB.editar(af);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Ha insertado correctamente "));
        System.out.println("ha insertado correctamente");
        limpiar();

    }
    
    

}
