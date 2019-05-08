package com.example.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.api.model.Minerio;
import com.example.api.repository.MinerioRepository;

@Service
public class MinerioService {
	
	@Autowired
	private MinerioRepository minerioRepository;
	
	public Minerio atualizar(Long id, Minerio minerio) {
		Minerio minerioOriginal = buscaPorId(id);
		
		BeanUtils.copyProperties(minerio, minerioOriginal, "id_minerio");
		return minerioRepository.save(minerioOriginal);
	}

	private Minerio buscaPorId(Long id) {
		Minerio minerioEncontrado = minerioRepository.findOne(id);
		if(minerioEncontrado == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return minerioEncontrado;
	}
}
