package com.sunnymeter.api.core.registro.consumo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumoRepository extends JpaRepository<Consumo, UUID>{
	
}
