package com.sunnymeter.api.core.registro.consumo;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroConsumo(	
		@NotNull
		UUID instalacao_uuid,

		@NotNull
		double consumo_kwh,
		
		@NotNull
		long medicacao_timestamp) {	

}


//{
//    "instalacao_uuid": "7da41106-5109-45f4-8d09-9ca405c33e5c",
//    "consumo_kwh: 410.90,
//    "medicao_timestamp": 1731284100 // November 11, 2024 00:15:00 AM
//}