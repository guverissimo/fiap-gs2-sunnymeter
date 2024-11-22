package com.sunnymeter.api.models.contrato;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, UUID>{
	Page<Contrato> findAll(Pageable paginacao);
}

