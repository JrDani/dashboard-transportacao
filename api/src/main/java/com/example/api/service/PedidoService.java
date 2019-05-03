package com.example.api.service;

import java.net.URI;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.api.model.Minerio;
import com.example.api.model.Pedido;
import com.example.api.repository.MinerioRepository;
import com.example.api.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private MinerioRepository minerioRepository;
	
	
	public Pedido atualiza(Long id, Pedido pedido) {
		Pedido pedidoOriginal = buscaPorId(id);
		
		BeanUtils.copyProperties(pedido, pedidoOriginal, "id_pedido");
		
		return pedidoRepository.save(pedidoOriginal);
	}
	
	public Pedido buscaPorId(Long id) {
		Pedido pedidoEncontrado = pedidoRepository.findOne(id);
		if(pedidoEncontrado == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return pedidoEncontrado;
	}
	
	public ResponseEntity<Pedido> insereERecuperaTotal(Pedido pedido) {
		
		if(pedido.getMinerio().getValor_grama() == null) {
			Minerio minerio = minerioRepository.findOne(pedido.getMinerio().getId_minerio());
			pedido.setMinerio(minerio);
		}
		Pedido pedidoCriado = pedidoRepository.save(pedido);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(pedido.getId_pedido()).toUri();
		
		return ResponseEntity.created(uri).body(pedidoCriado);
	}
}
