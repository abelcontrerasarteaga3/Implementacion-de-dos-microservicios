package com.facturacion.start.clientes;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import com.facturacion.start.entity.TbCliente;
import com.facturacion.start.repository.TbClienteRepImpl;

@SpringBootTest

class ListarClientesTests {

	@Autowired
	private TbClienteRepImpl impl;
	
	@Test
	void  listar() {
	   
		int paginado=1;
		int limite=5;
		
		List<TbCliente> clientes=null;
		clientes=impl.findAll(paginado, limite);
		for (int i=0;i<clientes.size();i++) {
			System.out.println(clientes);
		}
		
		 
	   
	}

}
