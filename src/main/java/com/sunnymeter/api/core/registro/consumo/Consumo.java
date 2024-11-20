package com.sunnymeter.api.core.registro.consumo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
public class Consumo {
	
	@Id
	@GeneratedValue(generator = "UUID")
	private UUID	registro_consumo_uuid;
	private UUID 	instalacao_uuid;
	private long 	timestamp_calculo;
	private long	medicao_timestamp;
	private int  	dia_referencia;
	private String 	mes_referencia;
	private int 	ano_referencia;
	private long	dias_para_acabar_o_mes;
	private double	consumo_kwh;
	private double	consumo_mensal_medio_kwh;
	private double	consumo_diario_medio_kwh;
	private double	consumo_mensal_estimado_kwh;
	private long	created_at;
	
	public Consumo() {}
	
	public Consumo(DadosCadastroConsumo dados) {
		this.instalacao_uuid 	= dados.instalacao_uuid();
		this.consumo_kwh 	 	= dados.consumo_kwh();
		this.medicao_timestamp	= dados.medicao_timestamp();
		this.setCreated_at();
	}
	

	public UUID getRegistro_consumo_uuid() {
		return registro_consumo_uuid;
	}

	public void setRegistro_consumo_uuid(UUID consumo_uuid) {
		this.registro_consumo_uuid = consumo_uuid;
	}

	public void setMedicao_timestamp(long medicao_timestamp) {
		this.medicao_timestamp = medicao_timestamp;
	}

	public UUID getInstalacao_uuid() {
		return instalacao_uuid;
	}

	public void setInstalacao_uuid(UUID instalacao_uuid) {
		this.instalacao_uuid = instalacao_uuid;
	}

	public long getTimestamp_calculo() {
		return timestamp_calculo;
	}

	public void setTimestamp_calculo(long timestamp_calculo) {
		this.timestamp_calculo = timestamp_calculo;
	}

	public int getDia_referencia() {
		return dia_referencia;
	}

	public void setDia_referencia(int dia_referencia) {
		this.dia_referencia = dia_referencia;
	}

	public String getMes_referencia() {
		return mes_referencia;
	}

	public void setMes_referencia(String mes_referencia) {
		this.mes_referencia = mes_referencia;
	}

	public int getAno_referencia() {
		return ano_referencia;
	}

	public void setAno_referencia(int ano_referencia) {
		this.ano_referencia = ano_referencia;
	}

	public long getDias_para_acabar_o_mes() {
		return dias_para_acabar_o_mes;
	}

	public void setDias_para_acabar_o_mes(long timestamp) {
		Instant instant = Instant.ofEpochSecond(timestamp);
        LocalDate dataAtual = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate primeiroDiaProximoMes = dataAtual.plusMonths(1).withDayOfMonth(1);
        long diasFaltantes = ChronoUnit.DAYS.between(dataAtual, primeiroDiaProximoMes);
        this.dias_para_acabar_o_mes = diasFaltantes;
	}

	public double getConsumo_mensal_medio_kwh() {
		return consumo_mensal_medio_kwh;
	}

	public void setConsumo_mensal_medio_kwh(double consumo_mensal_medio_kwh) {
		this.consumo_mensal_medio_kwh = consumo_mensal_medio_kwh;
	}

	public double getConsumo_diario_medio_kwh() {
		return consumo_diario_medio_kwh;
	}

	public void setConsumo_diario_medio_kwh(double consumo_diario_medio_kwh) {
		this.consumo_diario_medio_kwh = consumo_diario_medio_kwh;
	}

	public double getConsumo_mensal_estimado_kwh() {
		return consumo_mensal_estimado_kwh;
	}

	public void setConsumo_mensal_estimado_kwh(double consumo_mensal_estimado_kwh) {
		this.consumo_mensal_estimado_kwh = consumo_mensal_estimado_kwh;
	}

	public long getMedicao_timestamp() {
		return medicao_timestamp;
	}


	public double getConsumo_kwh() {
		return consumo_kwh;
	}

	public void setConsumo_kwh(double consumo_kwh) {
		this.consumo_kwh = consumo_kwh;
	}
	
	public void setCreated_at() {
		Instant time = Instant.now();
		this.created_at = time.getEpochSecond();
	}
	
	public long getCreated_at() {
		return created_at;
	}
	
}
