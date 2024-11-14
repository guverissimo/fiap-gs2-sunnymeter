package com.sunnymeter.api.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {

	
	@GetMapping()
	public String hello() {
		return "Hello";
	}
}
