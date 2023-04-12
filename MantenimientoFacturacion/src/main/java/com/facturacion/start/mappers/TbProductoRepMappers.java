package com.facturacion.start.mappers;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.facturacion.start.entity.TbProducto;



public class TbProductoRepMappers implements RowMapper<TbProducto> {

	@Override
	public TbProducto mapRow(ResultSet rs, int rowNum) throws SQLException {
		TbProducto producto = new TbProducto();
		producto.setIdproducto(rs.getInt("IDPRODUCTO"));
		producto.setNombre(rs.getString("NOMBRE"));
		producto.setPrecio(rs.getBigDecimal("PRECIO"));
		producto.setStock(rs.getInt("STOCK"));
		producto.setTotal(rs.getInt("total"));
		return producto;
	}


}
