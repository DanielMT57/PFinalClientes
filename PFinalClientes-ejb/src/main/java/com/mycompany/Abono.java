package com.mycompany;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
  * Entity implementation class for Entity: Abono
  * @author  German Andres Velasco Ortiz -gersandres@gmail.com
 */
@Entity

public class Abono implements Serializable {
    
    /*
    *Atributos que se requieren en esta clase
    *Entidades que se relacionan en enta clase
    */

    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "ventasClientes_Id", referencedColumnName = "Id")
    private VentasClientes venta;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "pago")
    private int pago;
    private static final long serialVersionUID = 1L;
    
    /*
    *Clase constructora con metodo super
    */

    public Abono() {
        super();
    }
    /*
    * Metodos getters y setters
    */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VentasClientes getVenta() {
        return venta;
    }

    public void setVenta(VentasClientes venta) {
        this.venta = venta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }   
}
