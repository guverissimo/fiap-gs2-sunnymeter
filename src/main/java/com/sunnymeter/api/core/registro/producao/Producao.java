package com.sunnymeter.api.core.registro.producao;

import jakarta.persistence.Entity;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
public class Producao {
	
	@Id
	@GeneratedValue(generator = "UUID")
	private UUID 	registro_producao_uuid;
	private UUID 	instalacao_uuid;
	private double 	producao_kwh;
	private long	medicao_timestamp;
	private long	created_at;
	
	public Producao() {}
	
	public Producao(DadosCadastroProducao dados){
		this.instalacao_uuid 	= dados.instalacao_uuid();
		this.producao_kwh 		= dados.producao_kwh();
		this.medicao_timestamp 	= dados.medicao_timestamp();
		setCreated_at(created_at);
	}

	public UUID getRegistro_producao_uuid() {
		return registro_producao_uuid;
	}

	public void setRegistro_producao_uuid(UUID registro_producao_uuid) {
		this.registro_producao_uuid = registro_producao_uuid;
	}

	public UUID getInstalacao_uuid() {
		return instalacao_uuid;
	}

	public void setInstalacao_uuid(UUID instalacao_uuid) {
		this.instalacao_uuid = instalacao_uuid;
	}

	public double getProducao_kwh() {
		return producao_kwh;
	}

	public void setProducao_kwh(double producao_kwh) {
		this.producao_kwh = producao_kwh;
	}

	public long getMedicao_timestamp() {
		return medicao_timestamp;
	}

	public void setMedicao_timestamp(long medicao_timestamp) {
		this.medicao_timestamp = medicao_timestamp;
	}

	public long getCreated_at() {
		return created_at;
	}

	public void setCreated_at(long created_at) {
		Instant time = Instant.now();
		this.created_at = time.getEpochSecond();
	}
	
	
}
