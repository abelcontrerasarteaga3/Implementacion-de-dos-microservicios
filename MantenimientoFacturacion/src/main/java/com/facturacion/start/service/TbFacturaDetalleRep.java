package com.facturacion.start.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facturacion.start.entity.TbCliente;
import com.facturacion.start.entity.TbFacturaDetalle;



@Service
public interface TbFacturaDetalleRep {

	
	 public List<TbFacturaDetalle> findAll(int pagina, int limite);
}
