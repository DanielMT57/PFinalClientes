/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
  * Entity implementation class for Entity: Paginas
  * @author  German Andres Velasco Ortiz -gersandres@gmail.com
 */

@Entity
@Table(name = "Paginas")
public class Paginas implements Serializable {

    /*
    *Atributos que se requieren en esta clase
    *Entidades que se relacionan en enta clase
    */
    
    @Id
    @Column(name = "Id")
    private int id;
    private String categoria_Id;
    @ManyToOne
    @JoinColumn(name = "catalogo_Id", referencedColumnName = "Id")
    private Catalogo catalogoId;
    @Column(name = "numero")
    private BigInteger numero;
    @OneToMany(mappedBy = "paginasId")
    private List<Areaspagina> areaspaginaCollection;
    
    /*
    *Metodo constructor sin parametros
    */

    public Paginas() {
    }
    
    /*
    *Metodo constructor con parametros
    */

    public Paginas(int id, String categoria_Id, Catalogo catalogoId, BigInteger numero, List<Areaspagina> areaspaginaCollection) {
        this.id = id;
        this.categoria_Id = categoria_Id;
        this.catalogoId = catalogoId;
        this.numero = numero;
        this.areaspaginaCollection = areaspaginaCollection;
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

    public String getCategoria_Id() {
        return categoria_Id;
    }

    public void setCategoria_Id(String categoria_Id) {
        this.categoria_Id = categoria_Id;
    }

    public Catalogo getCatalogoId() {
        return catalogoId;
    }

    public void setCatalogoId(Catalogo catalogoId) {
        this.catalogoId = catalogoId;
    }

    public BigInteger getNumero() {
        return numero;
    }

    public void setNumero(BigInteger numero) {
        this.numero = numero;
    }

    public List<Areaspagina> getAreaspaginaCollection() {
        return areaspaginaCollection;
    }

    public void setAreaspaginaCollection(List<Areaspagina> areaspaginaCollection) {
        this.areaspaginaCollection = areaspaginaCollection;
    }
  
}
