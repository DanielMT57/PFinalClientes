/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mbeans;

import com.mycompany.Pedidos;
import javax.ejb.EJB;
import com.mycompany.sessionbeans.PedidosClienteEJB;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;

/**
 * REST Web Service
 *
 * @author german
 */
@Path("pedidosGeneric")
@RequestScoped
public class PedidosGenericResource {
    
    @EJB
    PedidosClienteEJB pc;
    

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PedidosGenericResource
     */
    public PedidosGenericResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.mbeans.PedidosGenericResource
     * @return an instance of java.lang.String
     */
    
    @GET
   @Produces("application/json")
    public List<Pedidos> listarPedidos(){
       
       return pc.listarTodos();
       
    }


    /**
     * PUT method for updating or creating an instance of PedidosGenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
