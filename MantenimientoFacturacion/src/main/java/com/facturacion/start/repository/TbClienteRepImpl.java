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
import com.facturacion.start.mappers.TbClienteRepMappers;
import com.facturacion.start.service.TbClienteRep;

@Repository
public class TbClienteRepImpl implements TbClienteRep {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional
	public Mensaje save(TbCliente object) {

		Mensaje mensaje= new Mensaje();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
			SqlParameterSource in = new MapSqlParameterSource().addValue("_nombres", object.getNombres())
					.addValue("_direccion", object.getDireccion())
					.addValue("_fecha_nacimiento", object.getFechaNacimiento()).addValue("_dni", object.getDni());
		
			Map<String, Object> out=simpleJdbcCall.withProcedureName("addCliente").execute(in);
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
	public Mensaje update(TbCliente object) {
		Mensaje mensaje= new Mensaje();
		try {
			
			SimpleJdbcCall cliente = new SimpleJdbcCall(jdbcTemplate);
			SqlParameterSource inParams = new MapSqlParameterSource().addValue("_id", object.getIdcliente())
					.addValue("_nombres", object.getNombres()).addValue("_direccion", object.getDireccion())
					.addValue("_fecha_nacimiento", object.getFechaNacimiento()).addValue("_dni", object.getDni());

			Map<String, Object> out=cliente.withProcedureName("updateClinte").execute(inParams);
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
	public List<TbCliente> findAll(int pagina,int limite) {

		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		SqlParameterSource in = new MapSqlParameterSource().addValue("pagina", pagina )
				.addValue("limite",limite);
		
		simpleJdbcCall.withProcedureName("listarCliente").returningResultSet("clientes", new TbClienteRepMappers());

		Map<String, Object> out = simpleJdbcCall.execute(in);
		List<TbCliente> listClientes = (List<TbCliente>) out.get("clientes");

		return listClientes;
	}

	@Override
	public TbCliente fandById(Integer Id) {
		SimpleJdbcCall cliente = new SimpleJdbcCall(jdbcTemplate).withProcedureName("buscarClienteId");
		SqlParameterSource inParams = new MapSqlParameterSource().addValue("_id", Id);
		Map<String, Object> outParams = cliente.execute(inParams);
		TbCliente tbCliente = new TbCliente();
		tbCliente.setIdcliente((Integer) outParams.get("_idcliente"));
		tbCliente.setNombres((String) outParams.get("_nombres"));
		tbCliente.setDireccion((String) outParams.get("_direccion"));
		tbCliente.setFechaNacimiento((Date) outParams.get("_fecha_nacimiento"));
		tbCliente.setFechaRegistro((Date) outParams.get("_fecha_registro"));
		tbCliente.setDni((String) outParams.get("_dni"));
		tbCliente.setIdcliente(Id);
		return tbCliente;
	}
	@Override
	public TbCliente fandByDni(String dni) {
		SimpleJdbcCall cliente = new SimpleJdbcCall(jdbcTemplate).withProcedureName("buscarClienteDni");
		SqlParameterSource inParams = new MapSqlParameterSource().addValue("dni_", dni);
		Map<String, Object> outParams = cliente.execute(inParams);
		TbCliente tbCliente = new TbCliente();
		tbCliente.setIdcliente((Integer) outParams.get("_idcliente"));
		tbCliente.setNombres((String) outParams.get("_nombres"));
		tbCliente.setDireccion((String) outParams.get("_direccion"));
		tbCliente.setFechaNacimiento((Date) outParams.get("_fecha_nacimiento"));
		tbCliente.setFechaRegistro((Date) outParams.get("_fecha_registro"));
		tbCliente.setDni((String) outParams.get("_dni"));
		tbCliente.setDni(dni);
		return tbCliente;
	}
	
	@Override
	public Mensaje deleteById(int id) {
		Mensaje mensaje= new Mensaje();
		try {

			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
			SqlParameterSource inParams = new MapSqlParameterSource().addValue("_id", id);
			Map<String, Object> out=simpleJdbcCall.withProcedureName("eliminarCliente").execute(inParams);
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
