package com.sunnymeter.api.core.registro.consumo;

import java.util.UUID;

public record DadosDetalheCadastroConsumo(
		UUID 	registro_consumo_uuid,
		UUID 	instalacao_uuid,
		double	consumo_kwh,
		long	medicao_timestamp,
		long 	created_at
		) {
	public DadosDetalheCadastroConsumo(Consumo consumo) {
		this(
				consumo.getRegistro_consumo_uuid(),
				consumo.getInstalacao_uuid(),
				consumo.getConsumo_kwh(),
				consumo.getMedicao_timestamp(),
				consumo.getCreated_at()
				);
	}
}
