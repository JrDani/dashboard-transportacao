package com.example.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.api.model.TipoVeiculo;
import com.example.api.repository.TipoVeiculoRepository;

@Service
public class TipoVeiculoService {

	@Autowired
	private TipoVeiculoRepository tipoVeiculoRepository;
	
	public TipoVeiculo atualiza(Long id, TipoVeiculo tipoVeiculo) {
		TipoVeiculo tipoVeiculoOriginal = buscaPorId(id);
		BeanUtils.copyProperties(tipoVeiculo, tipoVeiculoOriginal, "id_tipo_veiculo");
		
		return tipoVeiculoRepository.save(tipoVeiculoOriginal);
	}
	
	public TipoVeiculo buscaPorId(Long id) {
		TipoVeiculo tipoVeiculoEncontrado = tipoVeiculoRepository.findOne(id);
		
		if(tipoVeiculoRepository == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return tipoVeiculoEncontrado;
		
	}
	

}
