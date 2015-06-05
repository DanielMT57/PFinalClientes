package com.mycompany;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
  * Entity implementation class for Entity: Agenda
  * @author  German Andres Velasco Ortiz -gersandres@gmail.com
 */
@Entity

public class Agenda implements Serializable {
    
    /*
    *Atributos que se requieren en esta clase
    *Entidades que se relacionan en enta clase
    */

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "personas_cedula", referencedColumnName = "cedula")
    private Personas persona;

    /*
     *Clase constructora con metodo super
     */
    public Agenda() {
        super();
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Personas getPersona() {
        return persona;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }

}
