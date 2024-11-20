package com.sunnymeter.api.core.instalacao;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
public class Instalacao {
	
	@Id
	@GeneratedValue(generator = "UUID")
	private UUID	instalacao_uuid;
	private String 	endereco;
	private String 	cep;
	private boolean	ativo;
	
	private long 	timestamp_calculo;
	private int  	dia_referencia;
	private String 	mes_referencia;
	private int 	ano_referencia;
	private int	dias_para_acabar_o_mes;
	private double	consumo_mensal_medio_kwh;
	private double	consumo_diario_medio_kwh;
	private double	consumo_mensal_estimado_kwh;
	private List<Double> registrosDoMes = new ArrayList<>();
	
	public Instalacao() {}

	public Instalacao(DadosCadastroInstalacao dados) {
		super();
		this.endereco = dados.endereco();
		this.cep = dados.cep();
		this.ativo = true;
	}
	
	public void adicionarConsumo(Double consumo) {
        registrosDoMes.add(consumo);
    }
	
	public void calculo() {	
		// "timestamp_calculo"
		Instant time = Instant.now();
		var timestamp = time.getEpochSecond();
		setTimestamp_calculo(timestamp);
		
		// Dia, mes e ano referencia
		Instant instant = Instant.ofEpochSecond(timestamp);
	    LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", Locale.forLanguageTag("pt-BR"));	     
	    setDia_referencia(localDate.getDayOfMonth());
	    setMes_referencia(localDate.format(formatter));
	    setAno_referencia(localDate.getYear());
		
	    // "dias_para_acabar_o_mes"
	    LocalDate ultimoDiaDoMes = localDate.with(TemporalAdjusters.lastDayOfMonth());
        int diasRestantes = (int) java.time.temporal.ChronoUnit.DAYS.between(localDate, ultimoDiaDoMes);
	    this.dias_para_acabar_o_mes = diasRestantes;
	    
	    // "consumo_mensal_medio_kwh"
	    if (registrosDoMes.isEmpty()) {
	    	registrosDoMes.add(0.0); // Adiciona 0.0 caso a lista esteja vazia (precaução)
	    }
	    double consumoMensal = registrosDoMes.get(registrosDoMes.size() - 1) - registrosDoMes.get(0);
	    this.consumo_mensal_estimado_kwh = consumoMensal;
	    System.out.println("Consumo Mensal Estimado: " + consumoMensal);
	    
	    // Calcular o número de dias do mês
	    LocalDate primeiroDiaDoMes = localDate.withDayOfMonth(1);
	    LocalDate ultimoDiaDoMesCalculado = localDate.with(TemporalAdjusters.lastDayOfMonth());
	    long diasNoMes = ChronoUnit.DAYS.between(primeiroDiaDoMes, ultimoDiaDoMesCalculado) + 1;
	    
	    // Calcular o consumo diário médio
	    if (diasNoMes > 0) {
	        this.consumo_diario_medio_kwh = consumoMensal / diasNoMes;
	    }
	    System.out.println("Consumo Diário Médio: " + this.consumo_diario_medio_kwh);
    }

	public UUID getInstalacao_uuid() {
		return instalacao_uuid;
	}

	public void setInstalacao_uuid(UUID instalacao_uuid) {
		this.instalacao_uuid = instalacao_uuid;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public void delete() {
		this.ativo = false;
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

	public void setDias_para_acabar_o_mes(long timestamp) {
		Instant instant = Instant.ofEpochSecond(timestamp);
        LocalDate dataAtual = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate primeiroDiaProximoMes = dataAtual.plusMonths(1).withDayOfMonth(1);
        int diasFaltantes = (int) ChronoUnit.DAYS.between(dataAtual, primeiroDiaProximoMes);
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

}
