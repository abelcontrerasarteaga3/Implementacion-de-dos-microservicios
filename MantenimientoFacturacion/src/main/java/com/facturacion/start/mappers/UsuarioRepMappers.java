package com.facturacion.start.mappers;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.facturacion.start.entity.Usuario;



public class UsuarioRepMappers implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setIdusuario(rs.getInt("IDUSUARIO"));
		usuario.setNombre(rs.getString("NOMBRE"));
		usuario.setApellidos(rs.getString("APELLIDOS"));
		usuario.setCorreo(rs.getString("CORREO"));
		usuario.setPassword(rs.getString("PASSWORD"));
		return usuario;
	}


}
