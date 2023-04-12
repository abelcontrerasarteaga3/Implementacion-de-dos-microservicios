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
import com.facturacion.start.entity.TbFactura;
import com.facturacion.start.entity.TbFacturaDetalle;
import com.facturacion.start.mappers.TbFacturaRepMappers;
import com.facturacion.start.service.TbFacturaRep;

@Repository
public class TbFacturaRepImpl implements TbFacturaRep {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional
	public Mensaje save(TbFactura object) {
		Mensaje mensaje= new Mensaje();
		try {
			int updatedCount=0;
		
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("addFactura");
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("_idCliente", object.getCliente().getIdcliente())
					.addValue("_nroFactura", object.getNroFactura())
					.addValue("_monto", object.getMonto());
			Map<String, Object> outParams = simpleJdbcCall.execute(in);
			int valorRetornado = (Integer) outParams.get("_idretorno");
			
			List<TbFacturaDetalle> listaDeta=object.getFacturaDetalles();	
			
			for(int i=0; i<listaDeta.size(); i++) {  
				simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("addDetalleFactura");
				SqlParameterSource inDetalle = new MapSqlParameterSource()
						.addValue("_idFactura", valorRetornado)
						.addValue("_idProducto", listaDeta.get(i).getProducto().getIdproducto()) 
						.addValue("_cantidad", listaDeta.get(i).getCantidad())
						.addValue("_precio", listaDeta.get(i).getPrecio())
						.addValue("_subTotal", listaDeta.get(i).getSubtotal());
				
				Map<String, Object> out = simpleJdbcCall.execute(inDetalle);
				updatedCount = (Integer) outParams.get("#update-count-1");
				
				//simpleJdbcCall.withProcedureName("addDetalleFactura").execute(inDetalle);
			}
			
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
	public boolean update(TbFactura object) {
		/*
		try {

			SimpleJdbcCall cliente = new SimpleJdbcCall(jdbcTemplate).withProcedureName("updateClinte");
			SqlParameterSource inParams = new MapSqlParameterSource().addValue("_id", object.getIdcliente())
					.addValue("_nombres", object.getNombres()).addValue("_direccion", object.getDireccion())
					.addValue("_fecha_nacimiento", object.getFechaNacimiento()).addValue("_dni", object.getDni());
			cliente.execute(inParams);
			return true;

		} catch (Exception e) {

			return false;
		}*/
		return false;
	}

	@Override
	public List<TbFactura> findAll(int pagina, int limite) {
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		SqlParameterSource in = new MapSqlParameterSource().addValue("pagina", pagina )
				.addValue("limite",limite);
		simpleJdbcCall.withProcedureName("listarFactura").returningResultSet("facturas", new TbFacturaRepMappers());
		Map<String, Object> out = simpleJdbcCall.execute(in);
		List<TbFactura> listFacturas = (List<TbFactura>) out.get("facturas");

		return listFacturas;
	}

	@Override
	public TbFactura fandById(Integer Id) {
		/*
		SimpleJdbcCall factura = new SimpleJdbcCall(jdbcTemplate).withProcedureName("buscarClienteId");
		SqlParameterSource inParams = new MapSqlParameterSource().addValue("_id", Id);
		Map<String, Object> outParams = factura.execute(inParams);
		TbFactura tbFactura = new TbFactura();
		tbCliente.setIdcliente((Integer) outParams.get("_idcliente"));
		tbCliente.setNombres((String) outParams.get("_nombres"));
		tbCliente.setDireccion((String) outParams.get("_direccion"));
		tbCliente.setFechaNacimiento((Date) outParams.get("_fecha_nacimiento"));
		tbCliente.setFechaRegistro((Date) outParams.get("_fecha_registro"));
		tbCliente.setDni((String) outParams.get("_dni"));
		tbCliente.setIdcliente(Id);
		return tbCliente;*/
		
		return null ;
	}

	@Override
	public Mensaje deleteById(int id) {
		
		Mensaje mensaje=new Mensaje();
		
		try {

			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("eliminarFactura");
			SqlParameterSource inParams = new MapSqlParameterSource().addValue("_id", id);
			Map<String, Object> out = simpleJdbcCall.execute(inParams);
			int updatedCount = (Integer) out.get("#update-count-1");
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
