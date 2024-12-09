package br.edu.ifms.cliente.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.cliente.modelo.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long codigo) {
        Cliente cliente = null;

        if (codigo == 1) {
            cliente = new Cliente(codigo, "chaulin");
        } else if (codigo == 2) {
            cliente = new Cliente(codigo, "flavindo do pneu pneu");
        }

        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(null);  // Ou uma mensagem personalizada
        }
    }
}
