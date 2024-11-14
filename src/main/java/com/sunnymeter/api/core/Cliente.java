package com.sunnymeter.api.core;

public class Cliente {
	private String id;
	private String nome;
	private String endereco;
	private String cep;
	private Boolean ativo;
	
	public Cliente(String nome, String endereco, String cep) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.ativo = false;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
