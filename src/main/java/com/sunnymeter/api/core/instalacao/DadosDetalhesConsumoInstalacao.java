package com.sunnymeter.api.core.instalacao;

import java.util.UUID;

public record DadosDetalhesConsumoInstalacao (
		UUID 	instalacao_uuid,
		long 	timestamp_calculo, 
		int  	dia_referencia,
		String 	mes_referencia,
		int 	ano_referencia,
		long	dias_para_acabar_o_mes,
		double	consumo_mensal_medio_kwh,
		double	consumo_diario_medio_kwh,
		double	consumo_mensal_estimado_kwh
		) {
	public DadosDetalhesConsumoInstalacao(Instalacao instalacao) {
		this(
				instalacao.getInstalacao_uuid(),
				instalacao.getTimestamp_calculo(),
				instalacao.getDia_referencia(),
				instalacao.getMes_referencia(),
				instalacao.getAno_referencia(),
				instalacao.getDias_para_acabar_o_mes(),
				instalacao.getConsumo_mensal_medio_kwh(),
				instalacao.getConsumo_diario_medio_kwh(),
				instalacao.getConsumo_mensal_estimado_kwh() );
	}
}
