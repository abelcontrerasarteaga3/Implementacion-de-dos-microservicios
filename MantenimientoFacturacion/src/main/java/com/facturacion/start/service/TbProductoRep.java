package com.facturacion.start.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facturacion.start.entity.Mensaje;
import com.facturacion.start.entity.TbCliente;
import com.facturacion.start.entity.TbProducto;



@Service
public interface TbProductoRep{

	public Mensaje save(TbProducto object);
	 public Mensaje update(TbProducto object);
	 public List<TbProducto> findAll(int pagina, int limite);
	 public TbProducto fandById(Integer Id);
	 public Mensaje deleteById(int id);

}
