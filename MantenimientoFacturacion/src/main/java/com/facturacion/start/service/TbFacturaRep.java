package com.facturacion.start.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facturacion.start.entity.Mensaje;
import com.facturacion.start.entity.TbFactura;



@Service
public interface TbFacturaRep{

	 public Mensaje save(TbFactura object);
	 public boolean update(TbFactura object);
	 public List<TbFactura> findAll(int pagina, int limite);
	 public TbFactura fandById(Integer Id);
	 public Mensaje deleteById(int id);
}
