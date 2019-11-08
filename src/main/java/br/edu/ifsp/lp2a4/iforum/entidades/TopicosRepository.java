package br.edu.ifsp.lp2a4.iforum.entidades;

import java.util.ArrayList;
import java.util.List;

public class TopicosRepository {
	
	private static List<Topico> _Topicos = new ArrayList<>();
	
	public void save(Topico topico) {
		_Topicos.add(topico);
	}
	
	public List<Topico> findAll(){
		return _Topicos;
	}

}
