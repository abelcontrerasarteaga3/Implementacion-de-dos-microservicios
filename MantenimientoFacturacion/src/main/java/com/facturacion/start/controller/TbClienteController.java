package com.facturacion.start.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.start.entity.Mensaje;
import com.facturacion.start.entity.TbCliente;
import com.facturacion.start.repository.TbClienteRepImpl;
import com.facturacion.start.repository.TbFacturaRepImpl;



@RestController
@RequestMapping("/Tbclientes/")

public class TbClienteController {

	 @Autowired
	 private TbClienteRepImpl clienteRepImpl;
	
	 @GetMapping("/listar/{paginado}/{limite}")
	 public List<TbCliente> listar(@PathVariable int paginado, @PathVariable int limite){
		 return clienteRepImpl.findAll(paginado,limite);
	 }
 
	 @PostMapping("/guardar")
	 public Mensaje guardar(@RequestBody TbCliente cliente) {
		 return clienteRepImpl.save(cliente);
		 
	 }
	 
	 @GetMapping("/buscar/{id}")
	 public ResponseEntity<TbCliente> buscar(@PathVariable Integer id){
		 TbCliente tbCliente= clienteRepImpl.fandById(id);
		return ResponseEntity.ok(tbCliente);
		 
	 }
	 
	 @GetMapping("/buscardni/{dni}")
	 public ResponseEntity<TbCliente> buscar(@PathVariable String dni){
		 TbCliente tbCliente= clienteRepImpl.fandByDni(dni);
		return ResponseEntity.ok(tbCliente);
		 
	 }
	 
	 @PostMapping("/update")
	 public Mensaje update(@RequestBody TbCliente cliente) {
		 TbCliente tbCliente=clienteRepImpl.fandById(cliente.getIdcliente());
		 if(cliente.getIdcliente()!=0) {
			 tbCliente.setNombres(cliente.getNombres());
			 tbCliente.setDireccion(cliente.getDireccion());
			 tbCliente.setFechaNacimiento(cliente.getFechaNacimiento());
			 tbCliente.setDni(cliente.getDni());
			 tbCliente.setFechaRegistro(new Date()); 
		 }
		 
		 return clienteRepImpl.update(tbCliente);
		 
	 }
	 
	 
	 
	 @DeleteMapping("/eliminar/{id}")
	 public Mensaje eliminar(@PathVariable Integer id){ 
		return clienteRepImpl.deleteById(id);

	 }
	 
}
