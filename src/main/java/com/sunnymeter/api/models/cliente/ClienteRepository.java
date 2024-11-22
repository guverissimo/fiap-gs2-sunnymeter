package com.sunnymeter.api.models.cliente;


import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
	Page<Cliente> findAllByAtivoTrue(Pageable paginacao);
	boolean existsByDocumento(String documento);
}
