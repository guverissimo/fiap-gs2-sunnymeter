package com.sunnymeter.api.core.registro.consumo;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroConsumo(	
		@NotNull
		UUID instalacao_uuid,

		@NotNull
		double consumo_kwh,
		
		@NotNull
		long medicao_timestamp) {	

}
