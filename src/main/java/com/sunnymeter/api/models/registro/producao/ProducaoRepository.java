package com.sunnymeter.api.models.registro.producao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducaoRepository extends JpaRepository<Producao, UUID> {

}
