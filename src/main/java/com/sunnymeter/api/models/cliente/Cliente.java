package com.sunnymeter.api.models.cliente;

import java.util.UUID;


import jakarta.persistence.*;

@Entity
public class Cliente {
	
	@Id
    @GeneratedValue(generator = "UUID")
    private UUID 			client_uuid;
	private String 			nome;
	private String  		documento;
	private String 			endereco;
	private String 			cep;
	private boolean 		ativo;
	
	@Enumerated(EnumType.STRING)
	private TipoDocumento  	tipo;
	
    public Cliente() {
    }
	
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
		return client_uuid;
	}
	public void setId(UUID id) {
		this.client_uuid = id;
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
	public boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public TipoDocumento getTipo() {
		return tipo;
	}

	public void setTipo(TipoDocumento tipo) {
		this.tipo = tipo;
	}
	
	public void delete() {
		this.ativo = false;
	}
	
	public void ativar() {
		this.ativo = true;
	}

}
