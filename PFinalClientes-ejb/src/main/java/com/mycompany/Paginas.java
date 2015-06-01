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
 *
 * @author german
 */
@Entity
@Table(name = "Paginas")
public class Paginas implements Serializable {

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

    public Paginas() {
    }

    public Paginas(int id, String categoria_Id, Catalogo catalogoId, BigInteger numero, List<Areaspagina> areaspaginaCollection) {
        this.id = id;
        this.categoria_Id = categoria_Id;
        this.catalogoId = catalogoId;
        this.numero = numero;
        this.areaspaginaCollection = areaspaginaCollection;
    }

   
}
