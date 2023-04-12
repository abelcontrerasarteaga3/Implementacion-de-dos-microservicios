package com.facturacion.start.entity;

import java.util.Date;

import org.springframework.lang.NonNull;

public class Usuario {

	private Integer idusuario;
	@NonNull
	private String nombre;
	@NonNull
	private String apellidos;
	@NonNull
	private String correo;
	@NonNull
	private String password;

	private String token;
	private String mensaje;
	private boolean success;

	private Date fecharegistro = new Date();

	public Usuario() {

	}

	public Usuario(Integer idusuario, String nombre, String apellidos, String correo, String password,
			Date fecharegistro, String token) {

		this.idusuario = idusuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.password = password;
		this.fecharegistro = fecharegistro;
		this.token = token;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
