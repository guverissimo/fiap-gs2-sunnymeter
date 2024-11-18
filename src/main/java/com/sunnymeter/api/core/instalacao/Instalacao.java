package com.sunnymeter.api.core.instalacao;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
public class Instalacao {
	
	@Id
	@GeneratedValue(generator = "UUID")
	private UUID	instalacao_uuid;
	private String 	endereco;
	private String 	cep;
	private boolean	ativo;
	
	public Instalacao() {}

	public Instalacao(DadosCadastroInstalacao dados) {
		super();
		this.endereco = dados.endereco();
		this.cep = dados.cep();
		this.ativo = true;
	}

	public UUID getInstalacao_uuid() {
		return instalacao_uuid;
	}

	public void setInstalacao_uuid(UUID instalacao_uuid) {
		this.instalacao_uuid = instalacao_uuid;
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public void delete() {
		this.ativo = false;
	}

}
