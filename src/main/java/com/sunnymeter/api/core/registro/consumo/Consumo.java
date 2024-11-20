package com.sunnymeter.api.core.registro.consumo;

import java.time.Instant;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
public class Consumo {
	
	@Id
	@GeneratedValue(generator = "UUID")
	private UUID	consumo_uuid;
	
	private UUID 	instalacao_uuid;
	private long 	timestamp_calculo;
	private long	medicao_timestamp;
	private int  	dia_referencia;
	private String 	mes_referencia;
	private int 	ano_referencia;
	private int		dias_para_acabar_o_mes;
	private double	consumo_kwh;
	private double	consumo_mensal_medio_kwh;
	private double	consumo_diario_medio_kwh;
	private double	consumo_mensal_estimado_kwh;
	
	public Consumo() {}
	
	public Consumo(DadosCadastroConsumo dados) {
		this.instalacao_uuid 	= dados.instalacao_uuid();
		this.consumo_kwh 	 	= dados.consumo_kwh();
		this.medicao_timestamp	= dados.medicacao_timestamp();
	}
	

	public UUID getConsumo_uuid() {
		return consumo_uuid;
	}

	public void setConsumo_uuid(UUID consumo_uuid) {
		this.consumo_uuid = consumo_uuid;
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

	public int getDias_para_acabar_o_mes() {
		return dias_para_acabar_o_mes;
	}

	public void setDias_para_acabar_o_mes(int dias_para_acabar_o_mes) {
		this.dias_para_acabar_o_mes = dias_para_acabar_o_mes;
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

	public void setMedicao_timestamp() {
		Instant time = Instant.now();
		this.medicao_timestamp = time.getEpochSecond();
	}

	public double getConsumo_kwh() {
		return consumo_kwh;
	}

	public void setConsumo_kwh(double consumo_kwh) {
		this.consumo_kwh = consumo_kwh;
	}
	
}

//{
//    "instalacao_uuid": "7da41106-5109-45f4-8d09-9ca405c33e5c",
//    "timestamp_calculo": 1731445100 // November 12 2024 20:58:20 AM,
//    "dia_referencia": "12",
//    "mes_referencia": "Novembro",
//    "ano_referencia": "2024",
//    "dias_para_acabar_o_mes": "18",
//    "consumo_mensal_medio_kwh: 44.4,
//    "consumo_diario_medio_kwh: 3.7,
//    "consumo_mensal_estimado_kwh: 111.0
//}
