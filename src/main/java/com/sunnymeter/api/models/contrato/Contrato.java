package com.sunnymeter.api.models.contrato;

import java.time.Instant;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
public class Contrato {

	@Id
	@GeneratedValue(generator = "UUID")
	private UUID 	contrato_uuid;
	private UUID 	instalacao_uuid;
	private UUID 	cliente_uuid;
	private long	contrato_inicio_timestamp;
	private int 	timeframe;
	private boolean status;
	
	public Contrato() {}
	
	public Contrato(DadosCadastroContrato dados) {
		this.cliente_uuid 	 = 	dados.cliente_uuid();
		this.instalacao_uuid = 	dados.instalacao_uuid();
		this.timeframe 		 = 	dados.timeframe();
		this.setContrato_inicio_timestamp();
		this.status = true;
		
	}

	public UUID getContrato_uuid() {
		return contrato_uuid;
	}

	public void setContrato_uuid(UUID contrato_uuid) {
		this.contrato_uuid = contrato_uuid;
	}

	public UUID getInstalacao_uuid() {
		return instalacao_uuid;
	}

	public void setInstalacao_uuid(UUID instalacao_uuid) {
		this.instalacao_uuid = instalacao_uuid;
	}

	public UUID getCliente_uuid() {
		return cliente_uuid;
	}

	public void setCliente_uuid(UUID cliente_uuid) {
		this.cliente_uuid = cliente_uuid;
	}

	public long getContrato_inicio_timestamp() {
		return contrato_inicio_timestamp;
	}

	public void setContrato_inicio_timestamp() {
		Instant time = Instant.now();
		this.contrato_inicio_timestamp = time.getEpochSecond();
	}

	public int getTimeframe() {
		return timeframe;
	}

	public void setTimeframe(int timeframe) {
		this.timeframe = timeframe;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean ativo) {
		this.status = ativo;
	}
	
	public void deletar() {
		this.status = false;
	}
	
}
