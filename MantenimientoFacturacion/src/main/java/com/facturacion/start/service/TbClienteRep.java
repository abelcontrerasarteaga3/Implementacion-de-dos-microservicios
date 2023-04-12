package com.facturacion.start.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facturacion.start.entity.Mensaje;
import com.facturacion.start.entity.TbCliente;

@Service
public interface TbClienteRep{

	public Mensaje save(TbCliente object);
	 public Mensaje update(TbCliente object);
	 public List<TbCliente> findAll(int pagina, int limite);
	 public TbCliente fandById(Integer Id);
	 public TbCliente fandByDni(String dni);
	 public Mensaje deleteById(int id);

}
