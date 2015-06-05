/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import org.eclipse.persistence.descriptors.ClassExtractor;
import org.eclipse.persistence.sessions.Record;
import org.eclipse.persistence.sessions.Session;

/**
 *
 * @author German Andres Velasco Ortiz -gersandres@gmail.com
 */
class PedidosExtractor extends ClassExtractor {

    /*
     *Clase contructora
     */
    @Override
    public Class extractClassFromRow(Record record, Session sn) {
        if (record.containsKey("valor")) {
            return Despachos.class;
        } else {
            return Pedidos.class;
        }
    }
}
