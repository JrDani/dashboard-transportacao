package com.example.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.api.model.Veiculo;
import com.example.api.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public Veiculo atualizar(Long id, Veiculo veiculo) {
		Veiculo veiculoOriginal = buscaPorId(id);
		BeanUtils.copyProperties(veiculo, veiculoOriginal, "id_veiculo");
		return veiculoRepository.save(veiculoOriginal);
	}
	
	public Veiculo buscaPorId(Long id) {
		Veiculo veiculo = veiculoRepository.findOne(id);
		if(veiculo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return veiculo;
	}
}
