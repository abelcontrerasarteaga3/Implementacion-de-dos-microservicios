package com.facturacion.start.clientes;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.facturacion.start.entity.Mensaje;
import com.facturacion.start.entity.TbCliente;
import com.facturacion.start.repository.TbClienteRepImpl;

@SpringBootTest

class RegistarClientesTests {

	@Autowired
	private TbClienteRepImpl impl;
	
	@Test
	void  registar() {
		TbCliente cliente=new TbCliente();
		cliente.setDni("34345450");
		cliente.setDireccion("Ejemplos");
		cliente.setFechaNacimiento( new Date());
		cliente.setNombres("Cualquier nombre");
		impl.save(cliente);

	
	}

}
