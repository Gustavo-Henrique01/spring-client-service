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
	
	public ClienteCPF buscarClienteComCPF(Long idCliente) {

		Mono< ClienteCPF> monoCliente = this.webClientCliente
			.method(HttpMethod.GET)
			.uri("/clientes/{codigo}", idCliente)
			.retrieve()
			.bodyToMono( ClienteCPF.class);
	
		Mono< ClienteCPF> monoCpf = this.webClientCpf
				.method(HttpMethod.GET)
				.uri("/cpf/{codigo}", idCliente)
				.retrieve()
				.bodyToMono( ClienteCPF.class);

		 ClienteCPF clientecpf = Mono.zip(monoCliente, monoCpf).map(tuple -> {
			tuple.getT1().setCpf(tuple.getT2().getCpf());
			return tuple.getT1();
		}).block();

		return clientecpf;
	}
	
	public  ClienteCPF ObterClienteComCPFassic(Long idCliente) {

		Mono< ClienteCPF> monoCliente = this.webClientCliente
			.method(HttpMethod.GET)
			.uri("/clientes/{codigo}", idCliente)
			.retrieve()
			.bodyToMono( ClienteCPF.class);
	
		Mono< ClienteCPF> monoCpf = this.webClientCpf
				.method(HttpMethod.GET)
				.uri("/cpf/{codigo}", idCliente)
				.retrieve()
				.bodyToMono( ClienteCPF.class);

		
		ClienteCPF cliente = monoCliente.block();
		ClienteCPF cpf = monoCpf.block();

		cliente.setCpf(cpf.getCpf());

		return cliente;
	}
	
	
}