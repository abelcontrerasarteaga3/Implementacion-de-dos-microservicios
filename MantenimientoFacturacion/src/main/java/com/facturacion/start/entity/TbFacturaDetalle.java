
package com.facturacion.start.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.facturacion.start.mappers.TbProductoRepMappers;



public class TbFacturaDetalle {

    private Integer iddetallefactura;

    private int cantidad;

    private BigDecimal precio;

    private BigDecimal subtotal;

    private Date fechaRegistro= new Date();

    private TbFactura factura;
    private TbProducto producto;
   private int total;
   
    public TbFacturaDetalle() {
    }

    public TbFacturaDetalle(Integer iddetallefactura) {
        this.iddetallefactura = iddetallefactura;
    }

  

    public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public TbFacturaDetalle(Integer iddetallefactura, int cantidad, BigDecimal precio, BigDecimal subtotal,
			Date fechaRegistro, TbFactura factura, TbProducto producto) {
	
		this.iddetallefactura = iddetallefactura;
		this.cantidad = cantidad;
		this.precio = precio;
		this.subtotal = subtotal;
		this.fechaRegistro = fechaRegistro;
		this.factura = factura;
		this.producto = producto;
	}

	public Integer getIddetallefactura() {
        return iddetallefactura;
    }

    public void setIddetallefactura(Integer iddetallefactura) {
        this.iddetallefactura = iddetallefactura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

	public TbFactura getFactura() {
		return factura;
	}

	public void setFactura(TbFactura factura) {
		this.factura = factura;
	}

	public TbProducto getProducto() {
		return producto;
	}

	public void setProducto(TbProducto producto) {
		this.producto = producto;
	}

   

   
    
}
