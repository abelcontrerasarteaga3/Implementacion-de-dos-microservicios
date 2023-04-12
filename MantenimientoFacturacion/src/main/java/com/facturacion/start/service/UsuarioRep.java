package com.facturacion.start.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facturacion.start.entity.Mensaje;

import com.facturacion.start.entity.Usuario;

@Service
public interface UsuarioRep {
	public Mensaje save(Usuario object);
	public Usuario fandByBuscar(String correo,String password);
	 public List<Usuario> findAll(int pagina, int limite);
}
