/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class para Entity: Areaspagina
 * @author  German Andres Velasco Ortiz -gersandres@gmail.com
 */
@Entity
@Table(name = "Areaspagina")
public class Areaspagina implements Serializable {
    
    /*
    *Atributos que se requieren en esta clase
    *Entidades que se relacionan en enta clase
    */

    @Id
    @Column(name = "Id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "paginas_Id", referencedColumnName = "Id")
    private Paginas paginasId;
    @ManyToOne
    @JoinColumn(name = "productos_Id", referencedColumnName = "Id")
    private Productos productosId;
    @ManyToOne
    @JoinColumn(name = "promociones_Id", referencedColumnName = "Id")
    private Promociones promocionesId;
    
    /*
    *Metodo constructor sin parametros
    */

    public Areaspagina() {
    }
    
    /*
    *Metodo constructor con parametros
    */
    
    public Areaspagina(int id, Promociones promocionesId, Productos productosId, Paginas paginasId) {
        this.id = id;
        this.promocionesId = promocionesId;
        this.productosId = productosId;
        this.paginasId = paginasId;
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

    public Promociones getPromocionesId() {
        return promocionesId;
    }

    public void setPromocionesId(Promociones promocionesId) {
        this.promocionesId = promocionesId;
    }

    public Productos getProductosId() {
        return productosId;
    }

    public void setProductosId(Productos productosId) {
        this.productosId = productosId;
    }

    public Paginas getPaginasId() {
        return paginasId;
    }

    public void setPaginasId(Paginas paginasId) {
        this.paginasId = paginasId;
    }

}
