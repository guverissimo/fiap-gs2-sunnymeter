package com.sunnymeter.api.core.cliente;

import java.util.UUID;


import jakarta.persistence.*;

@Entity
public class Cliente {
	
	@Id
    @GeneratedValue(generator = "UUID")
    private UUID 			id;
	private String 			nome;
	private String  		documento;
	private String 			endereco;
	private String 			cep;
	private Boolean 		ativo;
	
	@Enumerated(EnumType.STRING)
	private TipoDocumento  	tipo;
	
	public Cliente(DadosCadastroCliente dados) {
		super();
		this.nome 		= dados.nome();
		this.endereco 	= dados.endereco();
		this.cep 		= dados.cep();
		this.documento	= dados.documento();
		this.tipo		= dados.tipo();
		this.ativo 		= true;
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
