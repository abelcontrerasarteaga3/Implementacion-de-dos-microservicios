package com.facturacion.start.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.facturacion.start.entity.Mensaje;
import com.facturacion.start.entity.TbProducto;
import com.facturacion.start.entity.Usuario;
import com.facturacion.start.mappers.TbProductoRepMappers;
import com.facturacion.start.service.UsuarioRep;

@Repository
public class UsuarioRepImp implements UsuarioRep {
     
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Mensaje save(Usuario object) {
		Mensaje mensaje= new Mensaje();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("_nombre", object.getNombre())
					.addValue("_apellidos", object.getApellidos()) 
					.addValue("_correo", object.getCorreo())
					.addValue("_password", object.getPassword());
			
			Map<String, Object> out=simpleJdbcCall.withProcedureName("addUsuario").execute(in);
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
	public Usuario fandByBuscar(String correo,String password) { 
		SimpleJdbcCall user = new SimpleJdbcCall(jdbcTemplate).withProcedureName("buscarUsuario");
	SqlParameterSource inParams = new MapSqlParameterSource().addValue("_usuario", correo).addValue("_pass", password);
	
	Map<String, Object> outParams = user.execute(inParams);
	Usuario usuario = new Usuario();
	usuario.setIdusuario((Integer) outParams.get("_idusuario"));
	usuario.setNombre((String) outParams.get("_nombre"));
	usuario.setApellidos((String) outParams.get("_apellidos"));
	usuario.setCorreo((String) outParams.get("_correo"));
	usuario.setPassword((String) outParams.get("_password"));
	
	return usuario;
	}

	@Override
	public List<Usuario> findAll(int pagina, int limite) {
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		SqlParameterSource in = new MapSqlParameterSource().addValue("pagina", pagina )
				.addValue("limite",limite);
		simpleJdbcCall.withProcedureName("listarUsuario").returningResultSet("usuarios", new TbProductoRepMappers());

		Map<String, Object> out = simpleJdbcCall.execute(in);
		List<Usuario> listUsuario = (List<Usuario>) out.get("usuarios");

		return listUsuario;
	}

}
