/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mbeans;

import com.mycompany.Afiliados;


import com.mycompany.Pedidos;
import com.mycompany.Detallepedido;
import com.mycompany.Productos;
import com.mycompany.sessionbeans.AfiliadosEJB;

import com.mycompany.sessionbeans.ProductoClientesEJB;
import com.mycompany.sessionbeans.PedidosClienteEJB;
import com.mycompany.sessionbeans.DetallePedidoEJB;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import javax.faces.view.ViewScoped;

/**
 *
 * @author MAO
 */
@ManagedBean
@Named(value = "pedidoManagedBean")
@ViewScoped
public class pedidoManagedBean implements Serializable {

    private int idPedido;
    private int idAfiliado;
    private int idestado;
    private List<Afiliados> afiliados;
//    private List<Estado> estados;
    private Date fecha;
    private String descripcion;

    private int ide;

    ////
    private int idProducto;
    private double precioUnitario;
    private int cantidad;
    private List<Productos> productos;

    @EJB
    private ProductoClientesEJB productoEJB;

    @EJB
    private AfiliadosEJB afiliadosEJB;


    @EJB
    private PedidosClienteEJB pedidoEJB;

    @EJB
    private DetallePedidoEJB detallepedidoEJB;

    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdAfiliado() {
        return idAfiliado;
    }

    public void setIdAfiliado(int idAfiliado) {
        this.idAfiliado = idAfiliado;
    }

    public List<Afiliados> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(List<Afiliados> afiliados) {
        this.afiliados = afiliados;
    }

   

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    @PostConstruct
    public void postConstruct() {

        afiliados = afiliadosEJB.listarTodos();
        productos = productoEJB.listarTodos();

    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {

        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }

    private List<Detallepedido> detalles;
     private List<Pedidos> pedidos;

    public List<Pedidos> getPedidos() {
        pedidos=pedidoEJB.listarTodos();
        return pedidos;
    }
     

    public List<Detallepedido> getDetalles() {
        detalles = detallepedidoEJB.listarTodos();
        return detalles;
    }

    public void cargar() {
        Productos p = productoEJB.buscar(idProducto);
        double precio = p.getPrecioVenta();
        this.setPrecioUnitario(precio);
    }

    public void actualizar() {
        Productos p = productoEJB.buscar(idProducto);
        precioUnitario = p.getPrecioVenta();
    }

    public void crearPedidos() {

        Pedidos pe = new Pedidos();
        pe.setId(idPedido);

        pe.setAfiliadosCedula(afiliadosEJB.buscar(idAfiliado));
       pe.setEstadoId("En proceso");
        pe.setFecha(fecha);
        pe.setSincronizado('0');
        pe.setDescripcion(descripcion);

        pedidoEJB.crear(pe);
        Detallepedido de = new Detallepedido();
        // de.setDetallepedidoPK(idPedido, idProducto);
        de.setPedidos(pedidoEJB.buscar(idPedido));
        de.setProductos(productoEJB.buscar(idProducto));
        de.setCantidad(cantidad);
        de.setPreciounitario(precioUnitario);
        de.setSincronizado('0');
        detallepedidoEJB.crear(de);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Ha insertado correctamente  "));
        System.out.println("ha insertado correctamente");
        limpiar();

    }

    public void buscarPedido() {
        Pedidos pe = pedidoEJB.buscar(idPedido);
        if (pe != null) {
            Detallepedido de = pe.getDetallepedidoCollection().get(0);
            if (de != null) {
                idProducto = de.getProductos().getId();
                cantidad = de.getCantidad();
                precioUnitario = de.getPreciounitario();
            }
            descripcion = pe.getDescripcion();
            idAfiliado = pe.getAfiliadosCedula().getCedula();
         //  idestado = pe.getEstadoId();
            fecha = pe.getFecha();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Ha encontrado correctamente "));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informacion", "No se encontro nada "));
        }
        System.out.println("ha encontrado  correctamente");
        //   limpiar ();

    }
    
    
      public void actualizarPedido() {
          
           Pedidos pe = new Pedidos();
        pe.setId(idPedido);

        pe.setAfiliadosCedula(afiliadosEJB.buscar(idAfiliado));
       pe.setEstadoId("En proceso");
        pe.setFecha(fecha);
        pe.setSincronizado('0');
        pe.setDescripcion(descripcion);

        pedidoEJB.editar(pe);
        Detallepedido de = new Detallepedido();
        // de.setDetallepedidoPK(idPedido, idProducto);
        de.setPedidos(pedidoEJB.buscar(idPedido));
        de.setProductos(productoEJB.buscar(idProducto));
        de.setCantidad(cantidad);
        de.setPreciounitario(precioUnitario);
        de.setSincronizado('0');
        detallepedidoEJB.editar(de);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Ha actualizado correctamente  "));
        System.out.println("ha actualizado correctamente");
        limpiar();
      
    }

    public void limpiar() {
        this.setIdPedido(0);
        this.setCantidad(0);
        this.setDescripcion(null);
        this.setFecha(null);
        this.setPrecioUnitario(0);
    }

}
