/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mbeans;

import com.mycompany.Afiliados;
import com.mycompany.Agenda;
import com.mycompany.Catalogo;
import com.mycompany.Personas;
import com.mycompany.Productos;
import com.mycompany.sessionbeans.AfiliadosEJB;
import com.mycompany.sessionbeans.AgendaEJB;
import com.mycompany.sessionbeans.CatalogoClienteEJB;
import com.mycompany.sessionbeans.PersonaEJB;

import com.mycompany.sessionbeans.ProductoClientesEJB;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author german
 */
@ManagedBean
@Named(value = "AgendaBean")
@ViewScoped
public class AgendaBean implements Serializable {

    @EJB
    ProductoClientesEJB productosEJB;

    @EJB
    private CatalogoClienteEJB catalogClienteEJB;

    @EJB
    private AfiliadosEJB afiliadoEJB;

    @EJB
    private AgendaEJB agendaEJB;

    private PersonaEJB personaEJB;

    private List<Afiliados> afiliados;

    private List<Agenda> agendas;

    private int id;
    private Date fecha;
    private Date hora;
    private int personaId;
    private String descripcion;

    public List<Afiliados> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(List<Afiliados> afiliados) {
        this.afiliados = afiliados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @PostConstruct
    public void postConstruct() {
        afiliados = afiliadoEJB.listarTodos();

    }

    public List<Agenda> getAgendas() {
        agendas = agendaEJB.listarTodos();
        return agendas;
    }

    public void crearAgenda() {
        try {
            Agenda a = new Agenda();
            a.setId(id);
            a.setFecha(fecha);
            a.setHora(hora);
            a.setDescripcion(descripcion);
            a.setPersona(afiliadoEJB.buscar(personaId));

            agendaEJB.crear(a);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Ha insertado correctamente "));
            System.out.println("ha insertado correctamente");
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "No se ha podido insertar "));

            e.getMessage();
        }

    }

    private void limpiar() {
        setDescripcion(null);
        setFecha(null);
        setHora(null);
        setId(0);

    }

    public void buscarAgenda() {
        Agenda a = agendaEJB.buscar(id);

        if (a != null) {

            fecha = a.getFecha();
            hora = a.getFecha();
            descripcion = a.getDescripcion();
            personaId = a.getPersona().getCedula();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Ha encontrado correctamente "));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informacion", "No se encontro nada "));
        }

        System.out.println("ha encontrado  correctamente");
    }

    public void editarAgenda() {
        try {
            Agenda a = new Agenda();
            a.setId(id);
            a.setFecha(fecha);
            a.setHora(hora);
            a.setDescripcion(descripcion);
            a.setPersona(afiliadoEJB.buscar(personaId));

            agendaEJB.editar(a);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Ha insertado correctamente "));
            System.out.println("ha insertado correctamente");
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "No se ha podido insertar "));

            e.getMessage();
        }

    }

    public void eliminarAgenda() {
        try {
            Agenda a = agendaEJB.buscar(id);

            agendaEJB.eliminar(a);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Ha eliminado correctamente "));
            System.out.println("ha eliminado  correctamente");
            limpiar();
        } catch (Exception e) {
            e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "no se ha podido eliminar  "));

        }

    }
}
