package com.algaworks.awpag.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.awpag.domain.model.Cliente;
import com.algaworks.awpag.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ClienteController {
		
	private final ClienteRepository clienteRepository;
			
	@GetMapping("/clientes")
	public List<Cliente> Listar() {
		return clienteRepository.findAll();
		
	}

}
