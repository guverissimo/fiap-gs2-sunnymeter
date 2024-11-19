package com.sunnymeter.api.core.contrato;

import java.time.Instant;
import java.util.UUID;

public record DadosDetalhamentoContrato (UUID contrato_uuid, UUID cliente_uuid, UUID instalacao_uuid, int timeframe, boolean ativo, long contrato_inicio_timestamp  ) {
	public DadosDetalhamentoContrato(Contrato contrato) {
		this(
				contrato.getContrato_uuid(), 
				contrato.getCliente_uuid(), 
				contrato.getInstalacao_uuid(), 
				contrato.getTimeframe(), 
				contrato.getStatus(), 
				contrato.getContrato_inicio_timestamp());
	}
}
