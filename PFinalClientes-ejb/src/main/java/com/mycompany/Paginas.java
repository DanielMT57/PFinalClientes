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
import javax.persistence.JoinTable;

/**
 *
 * @author german
 */
@Entity
@Table(name = "Paginas")
public class Paginas implements Serializable {

    @Id
    @Column(name = "Id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "categoriaId_id", referencedColumnName = "id")
    private String categoriaId;
    @ManyToOne
    @JoinColumn(name = "catalogoId_Id", referencedColumnName = "Id")
    private Catalogo catalogoId;
    @Column(name = "numero")
    private BigInteger numero;
    @OneToMany(mappedBy = "paginasId")
    private List<Areaspagina> areaspaginaCollection;

    public Paginas() {
    }

    public Paginas(int id, BigInteger numero, String categoriaId, Catalogo catalogoId, List<Areaspagina> areaspaginaCollection) {
        this.id = id;
        this.numero = numero;
        this.categoriaId = categoriaId;
        this.catalogoId = catalogoId;
        this.areaspaginaCollection = areaspaginaCollection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigInteger getNumero() {
        return numero;
    }

    public void setNumero(BigInteger numero) {
        this.numero = numero;
    }

    public String getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(String categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Catalogo getCatalogoId() {
        return catalogoId;
    }

    public void setCatalogoId(Catalogo catalogoId) {
        this.catalogoId = catalogoId;
    }

    public List<Areaspagina> getAreaspaginaCollection() {
        return areaspaginaCollection;
    }

    public void setAreaspaginaCollection(List<Areaspagina> areaspaginaCollection) {
        this.areaspaginaCollection = areaspaginaCollection;
    }    
}
