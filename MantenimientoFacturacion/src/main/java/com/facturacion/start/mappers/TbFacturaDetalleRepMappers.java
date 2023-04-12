package com.facturacion.start.mappers;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.facturacion.start.entity.TbFactura;
import com.facturacion.start.entity.TbFacturaDetalle;
import com.facturacion.start.entity.TbProducto;



public class TbFacturaDetalleRepMappers implements RowMapper<TbFacturaDetalle> {

	@Override
	public TbFacturaDetalle mapRow(ResultSet rs, int rowNum) throws SQLException {
		TbFacturaDetalle detalle = new TbFacturaDetalle();
		TbProducto producto=new TbProducto();
		TbFactura factura = new TbFactura();
		factura.setIdfactura(rs.getInt("ID_FACTURA"));
		producto.setIdproducto(rs.getInt("IDPRODUCTO"));
		producto.setNombre(rs.getString("NOMBRE"));
		detalle.setFactura(factura);
		detalle.setIddetallefactura(rs.getInt("IDDETALLEFACTURA"));
		detalle.setProducto(producto);
		detalle.setCantidad(rs.getInt("CANTIDAD"));
		detalle.setPrecio(rs.getBigDecimal("PRECIO"));
		detalle.setSubtotal(rs.getBigDecimal("SUBTOTAL"));
		detalle.setTotal(rs.getInt("total"));
		
		return detalle;
	}


}
