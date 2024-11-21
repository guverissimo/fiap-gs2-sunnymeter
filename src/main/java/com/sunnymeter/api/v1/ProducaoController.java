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

import com.sunnymeter.api.core.instalacao.InstalacaoRepository;
import com.sunnymeter.api.core.registro.producao.DadosCadastroProducao;
import com.sunnymeter.api.core.registro.producao.DadosDetalhamentoProducao;
import com.sunnymeter.api.core.registro.producao.Producao;
import com.sunnymeter.api.core.registro.producao.ProducaoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("producao")
public class ProducaoController {

	@Autowired
	private ProducaoRepository repository;
	
	@Autowired
	private InstalacaoRepository instalacaoRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity create(@RequestBody @Valid DadosCadastroProducao dados, UriComponentsBuilder uriBuilder) {
		var producao = new Producao(dados);
		var instalacao = instalacaoRepository.findById(dados.instalacao_uuid())
				.orElseThrow(() -> new IllegalArgumentException("Instalação não encontrada: " + dados.instalacao_uuid()));
		repository.save(producao);
		var uri = uriBuilder.path("producao/{instalacao_uuid}").buildAndExpand(producao.getInstalacao_uuid()).toUri(); 
		return ResponseEntity.created(uri).body(new DadosDetalhamentoProducao(producao));
	}
	
	@GetMapping("{registro_producao_uuid}")
	public ResponseEntity find(@PathVariable UUID registro_producao_uuid) {
		var producao = repository.getReferenceById(registro_producao_uuid);
		return ResponseEntity.ok(new DadosDetalhamentoProducao(producao));
	}
}
