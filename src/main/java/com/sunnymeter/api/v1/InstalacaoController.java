package com.sunnymeter.api.v1;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sunnymeter.api.core.instalacao.DadosCadastroInstalacao;
import com.sunnymeter.api.core.instalacao.DadosDetalhamentoInstalacao;
import com.sunnymeter.api.core.instalacao.Instalacao;
import com.sunnymeter.api.core.instalacao.InstalacaoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("instalacoes")
public class InstalacaoController {

	@Autowired
	private InstalacaoRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity create(@RequestBody @Valid DadosCadastroInstalacao dados, UriComponentsBuilder uriBuilder) {
		var instalacao = new Instalacao(dados);
		repository.save(instalacao);
		var uri = uriBuilder.path("/instalacoes/{instalacao_uuid}").buildAndExpand(instalacao.getInstalacao_uuid()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoInstalacao(instalacao));
	}
	
	@GetMapping("/{instalacao_uuid}")
	public ResponseEntity findById(@PathVariable UUID instalacao_uuid) {
		var instalacao = repository.getReferenceById(instalacao_uuid);
		return ResponseEntity.ok(new DadosDetalhamentoInstalacao(instalacao));
	}
	
	@GetMapping
	public ResponseEntity<Page<DadosDetalhamentoInstalacao>> findAll(@PageableDefault(size = 10, sort = {"endereco"}) Pageable paginacao) {
		var page = repository.findAll(paginacao).map(DadosDetalhamentoInstalacao::new);
		return ResponseEntity.ok(page);
	}
	
	
}
