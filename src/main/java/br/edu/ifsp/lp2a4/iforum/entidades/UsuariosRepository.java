package br.edu.ifsp.lp2a4.iforum.entidades;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends CrudRepository<Usuario, Long> {

}
