package com.sunnymeter.api.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sunnymeter.api.models.cliente.Cliente;
import com.sunnymeter.api.models.cliente.ClienteRepository;
import com.sunnymeter.api.models.cliente.DadosCadastroCliente;
import com.sunnymeter.api.models.cliente.DadosDetalhamentoCliente;
import com.sunnymeter.api.models.cliente.DadosListagemCliente;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;

	
	@PostMapping
	@Transactional
	public ResponseEntity create(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriBuilder ) {
		 if (repository.existsByDocumento(dados.documento())) {
		        return ResponseEntity.badRequest().body("Já existe um cliente com este documento.");
		    }
		var cliente = new Cliente(dados);
		repository.save(cliente);
		var uri = uriBuilder.path("/clientes/{cliente_uuid}").buildAndExpand(cliente.getId()).toUri();	
		return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
	}
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemCliente>> findAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
		var page = repository.findAll(paginacao).map(DadosListagemCliente::new);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{cliente_uuid}")
	public ResponseEntity findById(@PathVariable UUID cliente_uuid) {
	    var cliente = repository.findById(cliente_uuid)
	    		.orElseThrow(() -> new IllegalArgumentException("Instalação não encontrada: " + cliente_uuid));
	    return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
	}
	
	@DeleteMapping("{cliente_uuid}")
	@Transactional
	public ResponseEntity delete(@PathVariable UUID cliente_uuid) {
		var cliente = repository.findById(cliente_uuid)
	    		.orElseThrow(() -> new IllegalArgumentException("Instalação não encontrada: " + cliente_uuid));
		cliente.delete();
		
		return ResponseEntity.ok().body("Cliente desativado");
	}

}
