package br.edu.ifsp.lp2a4.iforum.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.lp2a4.iforum.entidades.Usuario;
import br.edu.ifsp.lp2a4.iforum.entidades.UsuariosRepository;

@RestController
public class UsuariosController {
	
	private UsuariosRepository repository;
	
	public UsuariosController(UsuariosRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/usuarios")
	public ResponseEntity<Iterable<Usuario>> list(){

		Iterable<Usuario> usuarios = repository.findAll();
		
		ResponseEntity<Iterable<Usuario>> response = 
				new ResponseEntity<>(usuarios, HttpStatus.OK);
		
		return response;
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario get(@PathVariable long id) {
		
		//TODO: Melhorar (404?)
		Usuario usuario = repository.findById(id).orElseThrow();
		
		return usuario;	
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
		
		repository.save(usuario);
		
		ResponseEntity<Usuario> response = 
				new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
		
		return response;
	}
	
	@PutMapping("/usuarios/{id}")
	public Usuario update(@PathVariable long id, @RequestBody Usuario usuarioAtualizado) {
		
		//TODO: Melhorar (404?)
		Usuario usuario = repository.findById(id).orElseThrow();
		
		usuario.setNome(usuarioAtualizado.getNome());
		usuario.setSobrenome(usuarioAtualizado.getSobrenome());
		
		repository.save(usuario);
		
		return usuario;	
	}
	
	@DeleteMapping("/usuarios/{id}")
	public boolean delete(@PathVariable long id) {
		
		//TODO: Melhorar (404?)
		Usuario usuario = repository.findById(id).orElseThrow();
		
		repository.deleteById(usuario.getId());

		return true;
	}
}
