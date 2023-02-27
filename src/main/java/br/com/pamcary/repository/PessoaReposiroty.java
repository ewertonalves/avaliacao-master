package br.com.pamcary.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.pamcary.model.Pessoa;

public interface PessoaReposiroty extends CrudRepository<Pessoa, Long>{
	
	boolean existsByCpf(String cpf);
	
	@Transactional
	@Query("SELECT p FROM Pessoa p where p.cpf LIKE %:cpf%")
	List<Pessoa> buscarCpf(@Param("cpf") String cpf);
	
	List<Pessoa> findByCpfContainingIgnoreCase(String cpf);
	
	List<Pessoa> findAll();

}
