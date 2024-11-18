package com.sunnymeter.api.core.cliente;

import java.util.UUID;

public record DadosListagemCliente (UUID client_uui, String nome,  String endereco, String documento,  String cep, Boolean ativo, TipoDocumento tipo) {
	 public DadosListagemCliente(Cliente cliente) {
		this(cliente.getId(), cliente.getNome(), cliente.getEndereco(),
				cliente.getDocumento(), cliente.getCep(), cliente.getAtivo(), cliente.getTipo());
	}

}
