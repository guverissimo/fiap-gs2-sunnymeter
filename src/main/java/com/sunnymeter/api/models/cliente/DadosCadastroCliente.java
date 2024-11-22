package com.sunnymeter.api.models.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCliente (	
		@NotBlank
		String nome, 
		
		@NotBlank
		String documento,
		
		@NotNull
		TipoDocumento tipo,
		
		@NotBlank
		String endereco,
		
		@NotBlank
		String cep) {

}
