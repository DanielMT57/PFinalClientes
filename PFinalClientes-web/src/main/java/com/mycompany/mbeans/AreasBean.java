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
import com.mycompany.Areaspagina;
import com.mycompany.sessionbeans.AreasEJB;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author MAO
 */
@ManagedBean
@Named(value = "areasBean")
@ViewScoped

public class AreasBean implements Serializable {
    /*
    *Controlador de la pagina Areas
    */
    @EJB
    private AreasEJB areasEJB;
    /*
    *instancio un objeto del ejb de areas  y cargo una lista de paginas
    */
    private List<Areaspagina> areas;

    public List<Areaspagina> getAreas() {
        areas = areasEJB.listarTodos();
        return areas;
    }
}
