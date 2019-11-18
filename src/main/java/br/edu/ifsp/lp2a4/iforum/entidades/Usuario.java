package br.edu.ifsp.lp2a4.iforum.entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Usuario {
	
	private int id;
	private String nome;
	private String sobrenome;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
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
	
	public void salvar() {
		if(this.id == 0) {
			_usuarioSeq++;
			this.setId(_usuarioSeq);
			_UsuariosDict.put(_usuarioSeq, this);
		}else {
			_UsuariosDict.replace(this.getId(), this);
		}
	}
	
	public void remover() {
		_UsuariosDict.remove(this.id);
	}
	
	public static List<Usuario> Todos(){
		return new ArrayList<Usuario>(_UsuariosDict.values());
	}
	
	public static Usuario GetById(int id) {
		return _UsuariosDict.get(id);
	}
	
	private static HashMap<Integer, Usuario> _UsuariosDict = new HashMap<>();
	private static int _usuarioSeq = 0;


}
