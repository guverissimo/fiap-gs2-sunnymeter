package com.sunnymeter.api.models.instalacao;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroInstalacao(
		@NotNull
		String endereco,
		
		@NotNull
		String 	cep) {
	
}
