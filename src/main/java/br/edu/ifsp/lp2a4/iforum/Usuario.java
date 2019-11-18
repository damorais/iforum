package br.edu.ifsp.lp2a4.iforum;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import br.edu.ifsp.lp2a4.iforum.entidades.Topico;


@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank()
	private String nome;
	@NotBlank()
	private String sobrenome;
	
	
	@OneToMany
	private List<Topico> topicos;
	
	
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public List<Topico> getTopicos() {
		return topicos;
	}

	public void setTopicos(List<Topico> topicos) {
		this.topicos = topicos;
	}
	
//	public void salvar() {
//		if(this.id == 0) {
//			_usuarioSeq++;
//			this.setId(_usuarioSeq);
//			_UsuariosDict.put(_usuarioSeq, this);
//		}else {
//			_UsuariosDict.replace(this.getId(), this);
//		}
//	}
//	
//	public void remover() {
//		_UsuariosDict.remove(this.id);
//	}
//	
//	public static List<Usuario> Todos(){
//		return new ArrayList<Usuario>(_UsuariosDict.values());
//	}
//	
//	public static Usuario GetById(int id) {
//		return _UsuariosDict.get(id);
//	}
//	
//	private static HashMap<Integer, Usuario> _UsuariosDict = new HashMap<>();
//	private static int _usuarioSeq = 0;


}
