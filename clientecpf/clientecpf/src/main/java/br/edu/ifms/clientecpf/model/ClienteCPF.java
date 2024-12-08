package br.edu.ifms.clientecpf.model;

public class ClienteCPF {
	
	private Long id ;
	private String nome ;
	private String Cpf ;
	
	public ClienteCPF  () {
		
	}
	
	public ClienteCPF(Long id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		Cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}
	

}
