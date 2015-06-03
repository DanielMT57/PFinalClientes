/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sessionbeans;

import com.mycompany.Afiliados;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Daniel
 */
@Stateless
@LocalBean
public class AfiliadosEJB extends EJBGenericoCliente<Afiliados>{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    /**
     * Lista de ciudades de los afiliados
     * @return 
     */
    public List<String> getCiudades(){
        Query q= getEm().createNamedQuery(Afiliados.BUSCAR_CIUDADES);
        return q.getResultList();
    }
}
