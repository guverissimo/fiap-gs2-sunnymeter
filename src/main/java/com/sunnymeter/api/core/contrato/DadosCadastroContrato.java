package com.sunnymeter.api.core.contrato;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroContrato(
		@NotNull
		UUID cliente_uuid,
		@NotNull
		UUID instalacao_uuid,
		@NotNull
		int  timeframe
		) {

}
