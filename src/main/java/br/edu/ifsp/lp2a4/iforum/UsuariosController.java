package br.edu.ifsp.lp2a4.iforum;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuariosController {
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> list(){
		
		ResponseEntity<List<Usuario>> response = 
				new ResponseEntity<>(Usuario.Todos(), HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario get(@PathVariable int id) {
		return Usuario.GetById(id);	
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
		usuario.salvar();
		
		ResponseEntity<Usuario> response = 
				new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
		
		return response;
	}
	
	@PutMapping("/usuarios/{id}")
	public Usuario update(@PathVariable int id, @RequestBody Usuario usuarioAtualizado) {
		Usuario usuario = Usuario.GetById(id);
		
		usuario.setNome(usuarioAtualizado.getNome());
		usuario.setSobrenome(usuarioAtualizado.getSobrenome());
		usuario.salvar();
		
		return usuario;	
	}
	
	@DeleteMapping("/usuarios/{id}")
	public boolean delete(@PathVariable int id) {
		Usuario usuario = Usuario.GetById(id);
		usuario.remover();

		return true;
	}
}
