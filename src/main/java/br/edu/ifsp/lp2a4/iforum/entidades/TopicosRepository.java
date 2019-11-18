package br.edu.ifsp.lp2a4.iforum.entidades;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicosRepository extends CrudRepository<Topico, Long> {
	
//	private static List<Topico> _Topicos = new ArrayList<Topico>();
//			
//	
//	public void save(Topico topico) {
//		_Topicos.add(topico);
//	}
//	
//	public List<Topico> findAll(){
//		return _Topicos;
//	}

}
