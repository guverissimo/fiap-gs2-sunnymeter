package com.sunnymeter.api.core.registro.consumo;

import java.util.UUID;

public record DadosDetalhamentoConsumo(
		UUID 	instalacao_uuid,
		long 	timestamp_calculo, 
		int  	dia_referencia,
		String 	mes_referencia,
		int 	ano_referencia,
		int		dias_para_acabar_o_mes,
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


//{
//"instalacao_uuid": "7da41106-5109-45f4-8d09-9ca405c33e5c",
//"timestamp_calculo": 1731445100 // November 12 2024 20:58:20 AM,
//"dia_referencia": "12",
//"mes_referencia": "Novembro",
//"ano_referencia": "2024",
//"dias_para_acabar_o_mes": "18",
//"consumo_mensal_medio_kwh: 44.4,
//"consumo_diario_medio_kwh: 3.7,
//"consumo_mensal_estimado_kwh: 111.0
//}

