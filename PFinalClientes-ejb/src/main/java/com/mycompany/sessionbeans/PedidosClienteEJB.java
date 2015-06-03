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
 * @author german
 */
@Stateless
@LocalBean
public class PedidosClienteEJB extends EJBGenericoCliente<Pedidos>{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
     public List<Pedidos> listarPedidos(){
        Query q=super.getEm().createNamedQuery(Pedidos.CONSULTA_LISTARTODOS).setParameter("estado", "En proceso");
        
       // Query q=super.getEm().createNativeQuery("Select fecha from Pedidos");
        return q.getResultList();
    }
}
