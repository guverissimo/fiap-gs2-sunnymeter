package com.sunnymeter.api.models.cliente;

import java.util.UUID;

public record DadosDetalhamentoCliente (UUID client_uui, String nome,  String endereco, String documento,  String cep, Boolean ativo, TipoDocumento tipo) {
	 
	public DadosDetalhamentoCliente(Cliente cliente) {
		this(cliente.getId(), cliente.getNome(), cliente.getEndereco(),
				cliente.getDocumento(), cliente.getCep(), cliente.getAtivo(), cliente.getTipo());
	}

}	
