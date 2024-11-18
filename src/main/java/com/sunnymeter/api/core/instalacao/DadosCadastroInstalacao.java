package com.sunnymeter.api.core.instalacao;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroInstalacao(
		@NotNull
		String endereco,
		
		@NotNull
		String 	cep) {
	
}
