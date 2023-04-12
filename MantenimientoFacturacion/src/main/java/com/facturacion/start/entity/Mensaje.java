package com.facturacion.start.entity;

public class Mensaje {
	
 private String nombre;
 private boolean ok;

 
 
public Mensaje() {

}

public Mensaje(String nombre, boolean ok) {


	this.nombre = nombre;
	this.ok = ok;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public boolean isOk() {
	return ok;
}

public void setOk(boolean ok) {
	this.ok = ok;
}
 
 
 
 
}
