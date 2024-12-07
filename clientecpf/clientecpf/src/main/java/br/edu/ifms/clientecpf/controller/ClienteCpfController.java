package br.edu.ifms.clientecpf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.clientecpf.model.ClienteCPF;
import br.edu.ifms.clientecpf.service.ClienteCpfService;

@RestController
public class ClienteCpfController {
	
	
	@Autowired
	private ClienteCpfService clienteCpfService;
	
	 
    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<ClienteCPF> buscarClienteComCPF(@PathVariable Long idCliente) {
        
        ClienteCPF clienteCpf = clienteCpfService.buscarClienteComCPF(idCliente);

      
        if (clienteCpf != null) {
            
            return ResponseEntity.ok(clienteCpf);
        } else {
          
            return ResponseEntity.notFound().build();
        }
    }
}
