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

import com.example.api.model.TipoVeiculo;
import com.example.api.repository.TipoVeiculoRepository;
import com.example.api.service.TipoVeiculoService;

@RestController
@RequestMapping("/tipo-veiculos")
public class TipoVeiculoResource {
	
	@Autowired
	private TipoVeiculoRepository tipoVeiculoRepository;
	@Autowired
	private TipoVeiculoService tipoVeiculoService;
	
	@GetMapping
	public ResponseEntity<?> lista(){
		List<TipoVeiculo> tipoVeiculos = tipoVeiculoRepository.findAll();
		
		return !tipoVeiculos.isEmpty() ? ResponseEntity.ok(tipoVeiculos) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoVeiculo> buscaPorId(@PathVariable Long id) {
		TipoVeiculo tipoVeiculo = tipoVeiculoRepository.findOne(id);
		
		return tipoVeiculo != null ? ResponseEntity.ok(tipoVeiculo) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<TipoVeiculo> cria(@Valid @RequestBody TipoVeiculo tipoVeiculo){
		TipoVeiculo tipoVeiculoSalvo = tipoVeiculoRepository.save(tipoVeiculo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(tipoVeiculo.getId_tipo_veiculo()).toUri();
		
		return ResponseEntity.created(uri).body(tipoVeiculoSalvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TipoVeiculo> edita(@PathVariable Long id, @Valid @RequestBody TipoVeiculo tipoVeiculo) {
		
		TipoVeiculo tipoVeiculoEditado = tipoVeiculoService.atualiza(id, tipoVeiculo);
		
		return ResponseEntity.ok(tipoVeiculoEditado);
	}
	
	/*
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleta(@PathVariable Long id) {
		tipoVeiculoRepository.delete(id);
	}
	*/
	
}
