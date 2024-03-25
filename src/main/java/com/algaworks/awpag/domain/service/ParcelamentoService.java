package com.algaworks.awpag.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Cliente;
import com.algaworks.awpag.domain.model.Parcelamento;
import com.algaworks.awpag.domain.repository.ParcelamentoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ParcelamentoService {

	private final ParcelamentoRepository parcelamentoRepository;
	private final CadastroClienteService cadastroClienteService;
	
	@Transactional
	public Parcelamento cadastrar(Parcelamento novoParcelamento) {
		if(novoParcelamento.getId() != null) {
			throw new NegocioException("Parcelamento a ser criado deve posuir um codigo de cliente");
		}
		
		Cliente cliente = cadastroClienteService.buscar(novoParcelamento.getCliente().getId());
		
		novoParcelamento.setCliente(cliente);		
		novoParcelamento.setDataCriacao(LocalDateTime.now());
		
		return parcelamentoRepository.save(novoParcelamento);
	}
	
}
