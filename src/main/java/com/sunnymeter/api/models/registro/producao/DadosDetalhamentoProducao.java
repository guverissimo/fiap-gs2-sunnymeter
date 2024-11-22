package com.sunnymeter.api.models.registro.producao;

import java.util.UUID;

public record DadosDetalhamentoProducao(
		UUID 	registro_producao_uuid,
		UUID 	instalacao_uuid,
		double 	producao_kwh,
		long	medicao_timestamp,
		long	created_at
		) {
	public DadosDetalhamentoProducao(Producao producao) {
		this(
			producao.getRegistro_producao_uuid(),
			producao.getInstalacao_uuid(),
			producao.getProducao_kwh(),
			producao.getMedicao_timestamp(),
			producao.getCreated_at()
				);
	}
}
