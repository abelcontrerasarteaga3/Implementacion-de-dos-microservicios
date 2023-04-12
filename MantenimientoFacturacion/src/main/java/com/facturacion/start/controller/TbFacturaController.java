package com.facturacion.start.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.start.entity.Mensaje;
import com.facturacion.start.entity.TbCliente;
import com.facturacion.start.entity.TbFactura;
import com.facturacion.start.entity.TbProducto;
import com.facturacion.start.repository.TbClienteRepImpl;
import com.facturacion.start.repository.TbFacturaRepImpl;
import com.facturacion.start.repository.TbProductoRepImpl;



@RestController
@RequestMapping("/TbFacturas/")
//@CrossOrigin(origins = "http://localhost:4200/")
public class TbFacturaController {

	 @Autowired
	 private TbFacturaRepImpl impl;
	
	 @GetMapping("/listar/{paginado}/{limite}")
	 public List<TbFactura> listar(@PathVariable int paginado, @PathVariable int limite){
		 return impl.findAll(paginado,limite);
	 }
 
	 @PostMapping("/guardar")
	 public Mensaje guardar(@RequestBody TbFactura factura) {
		 return impl.save(factura);
		 
	 }
	 /*
	 @GetMapping("/buscar/{id}")
	 public ResponseEntity<TbProducto> buscar(@PathVariable Integer id){
		 TbFactura factura= impl.fandById(id);
		return ResponseEntity.ok(factura);
		 
	 }
	 */
	 /*
	 @PostMapping("/update")
	 public Mensaje update(@RequestBody TbProducto producto) {
		 
		 TbProducto tbProducto=impl.fandById(producto.getIdproducto());
		 tbProducto.setNombre(producto.getNombre());
		 tbProducto.setPrecio(producto.getPrecio());
		 tbProducto.setStock(producto.getStock());
		 tbProducto.setFechaRegistro(new Date()); 
		
		 
		 return impl.update(tbProducto);
		 
	 }*/
	 
	 @GetMapping("/eliminar/{id}")
	 public Mensaje eliminar(@PathVariable Integer id){ 
		return impl.deleteById(id);

	 }
}
