/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mbeans;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
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

public class AreasBean implements Serializable{

@EJB
private AreasEJB areasEJB;

private List<Areaspagina> areas;

    public List<Areaspagina> getAreas() {
        areas= areasEJB.listarTodos();
        return areas;
    }



   
}
