package com.facturacion.start.repository;

import java.math.BigDecimal;
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
import com.facturacion.start.entity.TbProducto;
import com.facturacion.start.mappers.TbClienteRepMappers;
import com.facturacion.start.mappers.TbProductoRepMappers;
import com.facturacion.start.service.TbProductoRep;



@Repository
public class TbProductoRepImpl implements TbProductoRep {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional
	public Mensaje save(TbProducto object) {
		Mensaje mensaje= new Mensaje();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("_nombre", object.getNombre())
					.addValue("_precio", object.getPrecio()) 
					.addValue("_stock", object.getStock());
			
			Map<String, Object> out=simpleJdbcCall.withProcedureName("addProducto").execute(in);
			int updatedCount = (Integer) out.get("#update-count-1");
			System.out.println("SAVE:"+updatedCount);
			if(updatedCount>=1) {
				mensaje.setOk(true);
				mensaje.setNombre("Se grabó correctamente");
			}else {
				mensaje.setOk(false);
				mensaje.setNombre("No se grabó los datos");
			}
			return mensaje;

		} catch (Exception e) {
 mensaje.setNombre(e.getMessage());
			 
			 return mensaje;
		}

	}

	@Override
	public Mensaje update(TbProducto object) {
		Mensaje mensaje= new Mensaje();
		
		try {

			SimpleJdbcCall producto = new SimpleJdbcCall(jdbcTemplate);
			SqlParameterSource inParams = new MapSqlParameterSource().addValue("_idProducto", object.getIdproducto())
					.addValue("_nombre", object.getNombre()).addValue("_precio", object.getPrecio())
					.addValue("_stock", object.getStock());
			
			Map<String, Object> out=producto.withProcedureName("updateProducto").execute(inParams);
			int updatedCount = (Integer) out.get("#update-count-1");
			System.out.println("SAVE:"+updatedCount);
			if(updatedCount>=1) {
				mensaje.setOk(true);
				mensaje.setNombre("Se actualizo correctamente");
			}else {
				mensaje.setOk(false);
				mensaje.setNombre("No se actualizo los datos");
			}
			return mensaje;

		} catch (Exception e) {
 mensaje.setNombre(e.getMessage());
			 
			 return mensaje;
		}
	}

	@Override
	public List<TbProducto> findAll(int pagina, int limite) {

		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		SqlParameterSource in = new MapSqlParameterSource().addValue("pagina", pagina )
				.addValue("limite",limite);
		simpleJdbcCall.withProcedureName("listarProducto").returningResultSet("productos", new TbProductoRepMappers());


		Map<String, Object> out = simpleJdbcCall.execute(in);
		List<TbProducto> listProductos = (List<TbProducto>) out.get("productos");

		return listProductos;
	}

	@Override
	public TbProducto fandById(Integer Id) {
		SimpleJdbcCall producto = new SimpleJdbcCall(jdbcTemplate).withProcedureName("buscarProducto");
		SqlParameterSource inParams = new MapSqlParameterSource().addValue("_id", Id);
		Map<String, Object> outParams = producto.execute(inParams);
		TbProducto tbProducto = new TbProducto();
		tbProducto.setIdproducto((Integer) outParams.get("_idProducto"));
		tbProducto.setNombre((String) outParams.get("_nombre"));
		tbProducto.setPrecio((BigDecimal) outParams.get("_precio"));
		tbProducto.setStock((Integer) outParams.get("_stock"));
		
		tbProducto.setIdproducto(Id);;
		return tbProducto;
	}



	@Override
	public Mensaje deleteById(int id) {
	
		Mensaje mensaje= new Mensaje();
		try {

			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
			SqlParameterSource inParams = new MapSqlParameterSource().addValue("_id", id);
			Map<String, Object> out=simpleJdbcCall.withProcedureName("eliminarProducto").execute(inParams);
			int updatedCount = (Integer) out.get("#update-count-1");
			System.out.println("SAVE:"+updatedCount);
			if(updatedCount>=1) {
				mensaje.setOk(true);
				mensaje.setNombre("Se elimino correctamente");
			}else {
				mensaje.setOk(false);
				mensaje.setNombre("No se elimino los datos");
			}
			return mensaje;
			


		} catch (Exception e) {
			mensaje.setNombre(e.getMessage());
			return mensaje;
		}
	}



}
