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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
  * Entity implementation class for Entity: Pedidos
  * @author  German Andres Velasco Ortiz -gersandres@gmail.com
 */

@Entity
@Table(name = "Pedidos")
//consulta que me permite optener una lista de pedidos por estado
@NamedQuery(name = Pedidos.CONSULTA_LISTARTODOS, query = "SELECT  p From Pedidos p where p.estadoId=:estado"    )
public class Pedidos implements Serializable {
  public static final String CONSULTA_LISTARTODOS = "Pedidos.listartodos"; 
  
    /*
    *Atributos que se requieren en esta clase
    *Entidades que se relacionan en enta clase
    */
    
    @Id
    @Column(name = "Id")
    private int id;
    @JoinColumn(name = "afiliados_cedula", referencedColumnName = "cedula")
    @ManyToOne
    private Afiliados afiliadosCedula;
    @Column(name = "Estado_id")
    private String estadoId;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "sincronizado")
    private Character sincronizado;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "pedidos")
    private List<Detallepedido> detallepedidoCollection;
    
    /*
    *Metodo constructor sin parametros
    */

    public Pedidos() {
    }
    
    /*
    *Metodo constructor con parametros
    */

    public Pedidos(int id, Date fecha, Character sincronizado,String descripcion, String estadoId, Afiliados afiliadosCedula, List<Detallepedido> detallepedidoCollection) {
        this.id = id;
        this.fecha = fecha;
        this.sincronizado = sincronizado;
        this.descripcion=descripcion;
        this.estadoId = estadoId;
        this.afiliadosCedula = afiliadosCedula;
        this.detallepedidoCollection = detallepedidoCollection;
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

    public Character getSincronizado() {
        return sincronizado;
    }

    public void setSincronizado(Character sincronizado) {
        this.sincronizado = sincronizado;
    }

    public String getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(String estadoId) {
        this.estadoId = estadoId;
    }

    public Afiliados getAfiliadosCedula() {
        return afiliadosCedula;
    }

    public void setAfiliadosCedula(Afiliados afiliadosCedula) {
        this.afiliadosCedula = afiliadosCedula;
    }

    public List<Detallepedido> getDetallepedidoCollection() {
        return detallepedidoCollection;
    }

    public void setDetallepedidoCollection(List<Detallepedido> detallepedidoCollection) {
        this.detallepedidoCollection = detallepedidoCollection;
    }

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}  
}
