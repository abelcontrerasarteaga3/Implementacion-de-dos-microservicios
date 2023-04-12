package com.facturacion.start.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.start.entity.Mensaje;

import com.facturacion.start.entity.Usuario;

import com.facturacion.start.repository.UsuarioRepImp;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@RestController
@RequestMapping("/usuario/")
public class UsuarioController {

	 @Autowired
	 private UsuarioRepImp impl;
	
	 @GetMapping("/listar/{paginado}/{limite}")
	 public List<Usuario> listar(@PathVariable int paginado, @PathVariable int limite){
		 return impl.findAll(paginado,limite);
	 }
 
	 @PostMapping("/guardar")
	 public Mensaje guardar( @RequestBody Usuario usuario ) {
		 return impl.save(usuario);
		 
	 }
	 
	 @GetMapping("/login")
	 public ResponseEntity<Usuario> buscar(@RequestParam(required = true) String correo, @RequestParam(required = true) String password){
		 Usuario usuario= impl.fandByBuscar(correo,password);
		 if(usuario!=null && usuario.getIdusuario()!=null && usuario.getIdusuario()>0) {
			 String token = getJWTToken(correo);
			 usuario.setToken(token);
			 usuario.setSuccess(true);
			 usuario.setMensaje("Autenticación correcta");
		 }else {
			 usuario= new Usuario();
			 usuario.setMensaje("Usuario y Contraseña incorrectas");
			 usuario.setSuccess(false);
		 }
		return ResponseEntity.ok(usuario);
		 
	 }
	 
	 private String getJWTToken(String username) {
			String secretKey = "mySecretKey";
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_USER");
			
			String token = Jwts
					.builder()
					.setId("softtekJWT")
					.setSubject(username)
					.claim("authorities",
							grantedAuthorities.stream()
									.map(GrantedAuthority::getAuthority)
									.collect(Collectors.toList()))
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 600000))
					.signWith(SignatureAlgorithm.HS512,
							secretKey.getBytes()).compact();

			return "Bearer " + token;
		}
	 
	
}
