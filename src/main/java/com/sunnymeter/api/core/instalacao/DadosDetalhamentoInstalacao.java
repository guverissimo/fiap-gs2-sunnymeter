package com.sunnymeter.api.core.instalacao;

import java.util.UUID;

public record DadosDetalhamentoInstalacao(UUID instalacao_uuid, String endereco, String cep, Boolean ativo) {
	public DadosDetalhamentoInstalacao(Instalacao instalacao) {
		this(instalacao.getInstalacao_uuid(), instalacao.getEndereco(), instalacao.getCep(), instalacao.isAtivo());
	}
}
