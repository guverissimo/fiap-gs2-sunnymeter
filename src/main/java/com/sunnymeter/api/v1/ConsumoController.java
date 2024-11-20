package com.sunnymeter.api.v1;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sunnymeter.api.core.instalacao.DadosDetalhesConsumoInstalacao;
import com.sunnymeter.api.core.instalacao.Instalacao;
import com.sunnymeter.api.core.instalacao.InstalacaoRepository;
import com.sunnymeter.api.core.registro.consumo.Consumo;
import com.sunnymeter.api.core.registro.consumo.ConsumoRepository;
import com.sunnymeter.api.core.registro.consumo.DadosCadastroConsumo;
import com.sunnymeter.api.core.registro.consumo.DadosDetalhamentoConsumo;
import com.sunnymeter.api.core.registro.consumo.DadosDetalheCadastroConsumo;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("consumo")
public class ConsumoController {
	
	@Autowired
	private ConsumoRepository repository;
	
	@Autowired
	private InstalacaoRepository instalacaoRepository;

	@PostMapping
	@Transactional
	public ResponseEntity create(@RequestBody @Valid DadosCadastroConsumo dados, UriComponentsBuilder uriBuilder) {
		var consumo = new Consumo(dados);
		var instalacao = instalacaoRepository.findById(dados.instalacao_uuid())
                 .orElseThrow(() -> new IllegalArgumentException("Instalação não encontrada: " + dados.instalacao_uuid()));
		instalacao.adicionarConsumo(dados.consumo_kwh());
		System.out.println("adicionarConsumo: " + dados.consumo_kwh());
		repository.save(consumo);
		var uri = uriBuilder.path("consumo/{instalacao_uuid}").buildAndExpand(consumo.getInstalacao_uuid()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalheCadastroConsumo(consumo));
	}
	
	@GetMapping("{instalacao_uuid}")
	public ResponseEntity find(@PathVariable UUID instalacao_uuid) {
		var instalacao = instalacaoRepository.findById(instalacao_uuid)
                .orElseThrow(() -> new IllegalArgumentException("Instalação não encontrada: " + instalacao_uuid));
		instalacao.calculo();
		return ResponseEntity.ok(new DadosDetalhesConsumoInstalacao(instalacao));
	}
}
