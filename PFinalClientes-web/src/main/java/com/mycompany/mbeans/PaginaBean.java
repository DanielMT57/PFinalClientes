/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mbeans;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import com.mycompany.Paginas;
import com.mycompany.sessionbeans.PaginaEJB;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author  German Andres Velasco Ortiz -gersandres@gmail.com
 */
@ManagedBean
@Named(value = "paginaBean")
@ViewScoped
public class PaginaBean implements Serializable {

    /*
     *atributos necesarios para la construccion de la pagina
     */
    private int idpagina;
    private int categoriaID;
    private int catalogoID;
    private BigInteger numero;
    
    /*
    *instancio los ejbs 
    */
    @EJB
    private PaginaEJB paginaEJB;

    private List<Paginas> paginas;
    
    /*
    *cargo la lista de paginas persistidas
    */

    public List<Paginas> getPaginas() {
        paginas = paginaEJB.listarTodos();
        return paginas;
    }
    
    /*
    * Metodos getters y setters
    */ 

    public int getIdpagina() {
        return idpagina;
    }

    public void setIdpagina(int idpagina) {
        this.idpagina = idpagina;
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public int getCatalogoID() {
        return catalogoID;
    }

    public void setCatalogoID(int catalogoID) {
        this.catalogoID = catalogoID;
    }

    public BigInteger getNumero() {
        return numero;
    }

    public void setNumero(BigInteger numero) {
        this.numero = numero;
    }

}
