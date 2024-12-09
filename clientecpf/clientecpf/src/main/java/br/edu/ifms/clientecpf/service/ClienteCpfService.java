package br.edu.ifms.clientecpf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.edu.ifms.clientecpf.model.ClienteCPF;

import reactor.core.publisher.Mono;

@Service
public class ClienteCpfService {

    @Autowired
    private WebClient webClientCliente;

    @Autowired
    private WebClient webClientCpf;

    // Alterado para retornar Mono<ClienteCPF>
    public Mono<ClienteCPF> buscarClienteComCPF(Long idCliente) {

        Mono<ClienteCPF> monoCliente = this.webClientCliente
            .method(HttpMethod.GET)
            .uri("/cliente/{codigo}", idCliente)
            .retrieve()
            .bodyToMono(ClienteCPF.class);

        Mono<ClienteCPF> monoCPF = this.webClientCpf
            .method(HttpMethod.GET)
            .uri("/cpf/{codigo}", idCliente)
            .retrieve()
            .bodyToMono(ClienteCPF.class);

        // Usando Mono.zip para combinar as respostas
        return Mono.zip(monoCliente, monoCPF)
            .map(tuple -> {
                tuple.getT1().setCpf(tuple.getT2().getCpf());
                return tuple.getT1(); // Retorna o cliente com CPF
            });
    }
}

