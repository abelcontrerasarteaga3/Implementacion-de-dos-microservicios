package com.facturacion.start.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.start.entity.Mensaje;
import com.facturacion.start.entity.TbCliente;
import com.facturacion.start.entity.TbFacturaDetalle;
import com.facturacion.start.entity.TbProducto;
import com.facturacion.start.mappers.TbClienteRepMappers;
import com.facturacion.start.mappers.TbFacturaDetalleRepMappers;
import com.facturacion.start.mappers.TbProductoRepMappers;
import com.facturacion.start.service.TbClienteRep;
import com.facturacion.start.service.TbFacturaDetalleRep;

@Repository
public class TbDetalleFacturaRepImpl implements TbFacturaDetalleRep {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<TbFacturaDetalle> findAll(int pagina, int limite) {
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		SqlParameterSource in = new MapSqlParameterSource().addValue("pagina", pagina )
				.addValue("limite",limite);
		simpleJdbcCall.withProcedureName("listaDetalleFactura").returningResultSet("detalles", new TbFacturaDetalleRepMappers());


		Map<String, Object> out = simpleJdbcCall.execute(in);
		List<TbFacturaDetalle> listdeDetalles = (List<TbFacturaDetalle>) out.get("detalles");

		return listdeDetalles;
	}

	

}
