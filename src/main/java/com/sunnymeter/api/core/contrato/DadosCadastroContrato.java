package com.sunnymeter.api.core.contrato;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroContrato(
		@NotBlank
		UUID cliente_uuid,
		@NotBlank
		UUID instalacao_uuid,
		@NotBlank
		int  timeframe
		) {

}
