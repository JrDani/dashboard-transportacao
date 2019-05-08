package com.example.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.api.model.Cliente;
import com.example.api.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente atualizar(Long id, Cliente cliente) {
		Cliente clienteSalvo = buscarClienteCodigo(id);
		BeanUtils.copyProperties(cliente, clienteSalvo, "id_cliente");
		
		return clienteRepository.save(clienteSalvo);
	}

	private Cliente buscarClienteCodigo(Long id) {
		Cliente clienteEncontrado = clienteRepository.findOne(id);
		if(clienteEncontrado == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return clienteEncontrado;
	}
	
}
