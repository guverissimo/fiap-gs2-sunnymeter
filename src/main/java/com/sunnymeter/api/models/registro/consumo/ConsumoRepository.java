package com.sunnymeter.api.models.registro.consumo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumoRepository extends JpaRepository<Consumo, UUID>{
	
}
