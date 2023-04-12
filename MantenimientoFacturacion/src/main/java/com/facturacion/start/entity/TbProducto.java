/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.facturacion.start.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



public class TbProducto  {


    private Integer idproducto;

    private String nombre;

    private BigDecimal precio;

    private int stock;
    
    private int total;

    private Date fechaRegistro=new Date();
   

    public TbProducto() {
    }

    public TbProducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public TbProducto(Integer idproducto, String nombre, BigDecimal precio, int stock, Date fechaRegistro) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}



 

   
    
}
