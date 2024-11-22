package com.sunnymeter.api.models.registro.producao;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroProducao(
		@NotNull
		UUID instalacao_uuid,
		
		@NotNull
		double producao_kwh,
		
		@NotNull
		long medicao_timestamp
		) {

		
}
