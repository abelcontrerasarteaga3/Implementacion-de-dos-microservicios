package com.facturacion.start.mappers;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.facturacion.start.entity.TbCliente;

public class TbClienteRepMappers implements RowMapper<TbCliente> {

	@Override
	public TbCliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		TbCliente cliente = new TbCliente();
		cliente.setIdcliente(rs.getInt("IDCLIENTE"));
		cliente.setNombres(rs.getString("NOMBRES"));
		cliente.setDireccion(rs.getString("DIRECCION"));
		cliente.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
		cliente.setFechaRegistro(rs.getDate("FECHA_REGISTRO"));
		cliente.setDni(rs.getString("DNI"));
		cliente.setTotal(rs.getInt("total"));
		return cliente;
	}


}
