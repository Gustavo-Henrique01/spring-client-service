package br.edu.ifms.cpf.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.cpf.model.Cpf;

@RestController
@RequestMapping("/cpf")
public class CpfController {

    @GetMapping("/{id}")
    public ResponseEntity<Cpf> buscarClienteCPF(@PathVariable Long id) {
        if (id == 1) { 
            Cpf cpf = new Cpf(id, "chaulin", "000.000.000-02");
            return ResponseEntity.ok(cpf);
        } else if (id == 2) {
            Cpf cpf = new Cpf(id, "flavin do pneu", "000.000.000-03");
            return ResponseEntity.ok(cpf);
        } else {
           
            return ResponseEntity.notFound().build();
        }
    }
}
