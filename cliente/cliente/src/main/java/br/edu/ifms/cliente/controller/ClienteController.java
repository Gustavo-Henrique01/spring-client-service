package br.edu.ifms.cliente.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.cliente.modelo.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@GetMapping("/{codigo}")
	public ResponseEntity<Cliente>buscarCliente(@PathVariable Long codigo) throws Exception {

	Cliente cliente = new Cliente(codigo, "cliente1");
		
		

		return ResponseEntity.ok(cliente);
	}
	
}
	
