package com.facturacion.start.mappers;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.facturacion.start.entity.TbCliente;
import com.facturacion.start.entity.TbFactura;
import com.facturacion.start.entity.TbFacturaDetalle;
import com.facturacion.start.entity.TbProducto;



public class TbFacturaRepMappers implements RowMapper<TbFactura> {

	@Override
	public TbFactura mapRow(ResultSet rs, int rowNum) throws SQLException {
		TbFactura factura = new TbFactura();
		TbCliente cliente=new TbCliente();
		
		cliente.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
		cliente.setDni(rs.getString("DNI"));
		cliente.setDireccion(rs.getString("DIRECCION"));
		cliente.setNombres(rs.getString("NOMBRES"));
		cliente.setIdcliente(rs.getInt("ID_CLIENTE"));
		
		factura.setIdfactura(rs.getInt("IDFACTURA"));
		factura.setCliente(cliente);
		factura.setNroFactura(rs.getString("NRO_FACTURA"));
		factura.setMonto(rs.getBigDecimal("MONTO"));
		
		factura.setTotal(rs.getInt("total"));
		
		return factura;
	}


}
