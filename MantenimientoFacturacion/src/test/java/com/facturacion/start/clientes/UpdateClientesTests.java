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

class UpdateClientesTests {

	@Autowired
	private TbClienteRepImpl impl;
	
	@Test
	void  update() {
		TbCliente cliente=new TbCliente();
		cliente.setIdcliente(81);
		cliente.setDni("34345410");
		cliente.setDireccion("La Esperanza");
		cliente.setFechaNacimiento( new Date());
		cliente.setNombres("Rolando Vela");
		impl.update(cliente);

	
	}

}
