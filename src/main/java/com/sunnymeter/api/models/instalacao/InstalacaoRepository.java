package com.sunnymeter.api.models.instalacao;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstalacaoRepository extends JpaRepository<Instalacao, UUID>{
	Page<Instalacao> findAll(Pageable paginacao);
}
