package com.example.api.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.api.model.Minerio;
import com.example.api.repository.MinerioRepository;
import com.example.api.service.MinerioService;

@RestController
@RequestMapping("/minerios")
public class MinerioResource {

	@Autowired
	private MinerioRepository minerioRepository;
	@Autowired
	private MinerioService minerioService;
	
	@GetMapping
	public ResponseEntity<?> lista(){
		List<Minerio> minerios = minerioRepository.findAll();
		
		return !minerios.isEmpty() ? ResponseEntity.ok(minerios) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Minerio> buscaPorId(@PathVariable Long id){
		Minerio minerio = minerioRepository.findOne(id);
		
		return minerio != null ? ResponseEntity.ok(minerio) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Minerio> cria(@Valid @RequestBody Minerio minerio){
		Minerio minerioCriado = minerioRepository.save(minerio);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/{id}").buildAndExpand(minerioCriado.getId_minerio()).toUri();
		
		return ResponseEntity.created(uri).body(minerioCriado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Minerio> edita(@PathVariable Long id, @Valid @RequestBody Minerio minerio){
		Minerio minerioSalvo = minerioService.atualizar(id, minerio);
		
		return ResponseEntity.ok(minerioSalvo);
	}
	
}
