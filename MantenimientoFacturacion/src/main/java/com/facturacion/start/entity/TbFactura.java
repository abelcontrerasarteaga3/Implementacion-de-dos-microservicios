/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.facturacion.start.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class TbFactura{


    private Integer idfactura;

    private String nroFactura;

    private BigDecimal monto;

    private Date fechaRegistro;
  
    private TbCliente Cliente;
    
    private int total;
    
    private List<TbFacturaDetalle> facturaDetalles;


    public TbFactura() {
    }



	public TbFactura(Integer idfactura, String nroFactura, BigDecimal monto, Date fechaRegistro, TbCliente cliente,
			List<TbFacturaDetalle> facturaDetalles) {
		super();
		this.idfactura = idfactura;
		this.nroFactura = nroFactura;
		this.monto = monto;
		this.fechaRegistro = fechaRegistro;
		Cliente = cliente;
		this.facturaDetalles = facturaDetalles;
	}

	public TbCliente getCliente() {
		return Cliente;
	}

	public void setCliente(TbCliente cliente) {
		Cliente = cliente;
	}


	public Integer getIdfactura() {
		return idfactura;
	}


	public void setIdfactura(Integer idfactura) {
		this.idfactura = idfactura;
	}


	public String getNroFactura() {
		return nroFactura;
	}


	public void setNroFactura(String nroFactura) {
		this.nroFactura = nroFactura;
	}


	public BigDecimal getMonto() {
		return monto;
	}


	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}


	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}






	public List<TbFacturaDetalle> getFacturaDetalles() {
		return facturaDetalles;
	}




	public void setFacturaDetalles(List<TbFacturaDetalle> facturaDetalles) {
		this.facturaDetalles = facturaDetalles;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



    
}
