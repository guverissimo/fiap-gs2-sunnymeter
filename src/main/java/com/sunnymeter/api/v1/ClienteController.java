package com.sunnymeter.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sunnymeter.api.core.cliente.Cliente;
import com.sunnymeter.api.core.cliente.ClienteRepository;
import com.sunnymeter.api.core.cliente.DadosCadastroCliente;

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
		var cliente = new Cliente(dados);
		repository.save(cliente);
		
		 var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		
		return ResponseEntity.created(uri).body(cliente);
	}
}
