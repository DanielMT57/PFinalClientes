/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sessionbeans;

import com.mycompany.Pedidos;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author  German Andres Velasco Ortiz -gersandres@gmail.com
 */
@Stateless
@LocalBean
public class PedidosClienteEJB extends EJBGenericoCliente<Pedidos>{

    
    /*
    * Metodo que me muestra una lista de pedidos 
     *@return listado con todos los pedidos
    */
    
     public List<Pedidos> listarPedidos(){
        Query q=super.getEm().createNamedQuery(Pedidos.CONSULTA_LISTARTODOS).setParameter("estado", "En proceso");
        return q.getResultList();
    }
}
