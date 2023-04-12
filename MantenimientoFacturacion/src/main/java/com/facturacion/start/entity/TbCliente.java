/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.facturacion.start.entity;


import java.util.Date;
import java.util.List;

import org.springframework.lang.NonNull;


public class TbCliente{

    private Integer idcliente;
    @NonNull
    private String nombres;
    @NonNull
    private String direccion;
    @NonNull
    private Date fechaNacimiento;
 
    private Date fechaRegistro = new Date();
    @NonNull 
    private String dni;
    private int total;

public TbCliente(int idcliente) {
		this.idcliente=idcliente;
	}
    
	public TbCliente() {
		
	}

	public TbCliente(Integer idcliente, String nombres, String direccion, Date fechaNacimiento, Date fechaRegistro,
			String dni) {

		this.idcliente = idcliente;
		this.nombres = nombres;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaRegistro = fechaRegistro;
		this.dni = dni;
	}

	

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	 
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "TbCliente [idcliente=" + idcliente + ", nombres=" + nombres + ", direccion=" + direccion
				+ ", fechaNacimiento=" + fechaNacimiento + ", fechaRegistro=" + fechaRegistro + ", dni=" + dni + "]";
	}


    


   
    
    
}
