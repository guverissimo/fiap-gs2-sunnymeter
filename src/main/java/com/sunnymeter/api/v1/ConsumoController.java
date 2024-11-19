package com.sunnymeter.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sunnymeter.api.core.registro.consumo.Consumo;
import com.sunnymeter.api.core.registro.consumo.ConsumoRepository;
import com.sunnymeter.api.core.registro.consumo.DadosCadastroConsumo;
import com.sunnymeter.api.core.registro.consumo.DadosDetalhamentoConsumo;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("consumo")
public class ConsumoController {
	
	@Autowired
	private ConsumoRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity create(@RequestBody @Valid DadosCadastroConsumo dados, UriComponentsBuilder uriBuilder) {
		var consumo = new Consumo(dados);
		repository.save(consumo);
		
		var uri = uriBuilder.path("consumo/{instalacao_uuid}").buildAndExpand(consumo.getInstalacao_uuid()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoConsumo(consumo));
		
	}
}
