package com.sunnymeter.api.v1;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.sunnymeter.api.core.contrato.Contrato;
import com.sunnymeter.api.core.contrato.ContratoRepository;
import com.sunnymeter.api.core.contrato.DadosCadastroContrato;
import com.sunnymeter.api.core.contrato.DadosDetalhamentoContrato;

import jakarta.validation.Valid;

@RestController
@RequestMapping("contratos")
public class ContratoController {

	@Autowired
	private ContratoRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity create(@RequestBody @Valid DadosCadastroContrato dados, UriComponentsBuilder uriBuilder ) {
		if (dados.timeframe() % 90 != 0 || dados.timeframe() > 810 || dados.timeframe() < 90 ) {
			return ResponseEntity.badRequest().body("A vigência de um contrato deverá ser um múltiplo de 90, podendo ir de 90 dias a 810 dias.");
		}
		
		var contrato = new Contrato(dados);
		repository.save(contrato);
		var uri = uriBuilder.path("/contrato/{contrato_uuid}").buildAndExpand(contrato.getContrato_uuid()).toUri();	
		return ResponseEntity.created(uri).body(new DadosDetalhamentoContrato(contrato));
	}
	
	@GetMapping
	public ResponseEntity<Page<DadosDetalhamentoContrato>> findAll(@PageableDefault() Pageable paginacao) {
		var page = repository.findAll(paginacao).map(DadosDetalhamentoContrato::new);
		return ResponseEntity.ok(page);	
	}
	
	@GetMapping("{contrato_uuid}")
	public ResponseEntity findById(@PathVariable UUID contrato_uuid) {
		var contrato = repository.getReferenceById(contrato_uuid);
		return ResponseEntity.ok(new DadosDetalhamentoContrato(contrato));
	}
	
	@DeleteMapping("{contrato_uuid}")
	@Transactional
	public ResponseEntity delete(@PathVariable UUID contrato_uuid) {
		var contrato = repository.getReferenceById(contrato_uuid);
		contrato.deletar();
		
		return ResponseEntity.ok(new DadosDetalhamentoContrato(contrato));
	}
}
