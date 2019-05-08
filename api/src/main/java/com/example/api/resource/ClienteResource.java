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

import com.example.api.model.Cliente;
import com.example.api.repository.ClienteRepository;
import com.example.api.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<?> lista(){
		List<Cliente> clientes = clienteRepository.findAll();
		return !clientes.isEmpty() ? ResponseEntity.ok(clientes) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscaPorId(@PathVariable Long id){
		Cliente cliente = clienteRepository.findOne(id);
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Cliente> cria(@Valid @RequestBody Cliente cliente){
		Cliente clienteSalvo = clienteRepository.save(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(clienteSalvo.getId_cliente()).toUri();
		
		return ResponseEntity.created(uri).body(clienteSalvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> edita(@PathVariable Long id, @Valid @RequestBody Cliente cliente){
		Cliente clienteSalvo = clienteService.atualizar(id, cliente);
		return ResponseEntity.ok(clienteSalvo);
	}
	/*
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleta(@PathVariable Long id) {
		clienteRepository.delete(id);
	}
	*/
}
