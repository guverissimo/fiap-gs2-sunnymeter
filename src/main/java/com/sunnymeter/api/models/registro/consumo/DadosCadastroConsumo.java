package com.sunnymeter.api.models.registro.consumo;

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
