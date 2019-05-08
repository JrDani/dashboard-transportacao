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

import com.example.api.model.Veiculo;
import com.example.api.repository.VeiculoRepository;
import com.example.api.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoResource {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	@Autowired
	private VeiculoService veiculoService;

	@GetMapping
	public ResponseEntity<?> lista(){
		List<Veiculo> veiculos = veiculoRepository.findAll();
		
		return !veiculos.isEmpty() ? ResponseEntity.ok(veiculos) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> buscaPorId(@PathVariable Long id){
		Veiculo veiculo = veiculoRepository.findOne(id);
		
		return veiculo != null ? ResponseEntity.ok(veiculo) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Veiculo> cria(@Valid @RequestBody Veiculo veiculo){
		Veiculo veiculoSalvo = veiculoRepository.save(veiculo);
				
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(veiculoSalvo.getId_veiculo()).toUri();
		
		return ResponseEntity.created(uri).body(veiculoSalvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> edita(@Valid @RequestBody Veiculo veiculo, @PathVariable Long id){
		Veiculo veiculoEditado = veiculoService.atualizar(id, veiculo);
		
		return ResponseEntity.ok(veiculoEditado);
	}
	/*
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleta(@PathVariable Long id) {
		veiculoRepository.delete(id);
	}
	*/
	
}
