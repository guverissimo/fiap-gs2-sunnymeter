package com.sunnymeter.api.core.registro.consumo;

import java.util.UUID;

public record DadosDetalhamentoConsumo(
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
	
	public DadosDetalhamentoConsumo(Consumo consumo) {
		this(
			consumo.getInstalacao_uuid(),
			consumo.getTimestamp_calculo(),
			consumo.getDia_referencia(),
			consumo.getMes_referencia(),
			consumo.getAno_referencia(),
			consumo.getDias_para_acabar_o_mes(),
			consumo.getConsumo_mensal_medio_kwh(),
			consumo.getConsumo_diario_medio_kwh(),
			consumo.getConsumo_mensal_estimado_kwh() );
	}
}
