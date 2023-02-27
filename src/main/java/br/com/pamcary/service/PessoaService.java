package br.com.pamcary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pamcary.exceptions.BadRequestException;
import br.com.pamcary.model.Pessoa;
import br.com.pamcary.repository.PessoaReposiroty;

@Service
public class PessoaService {

	@Autowired
	private PessoaReposiroty pessoaReposiroty;

	public void salvar(Pessoa pessoa) {
		Boolean id = pessoaReposiroty.existsByCpf(pessoa.getCpf());
		if (id)
			throw new BadRequestException("Já existe uma Pessoa cadastrado com o CPF:" + pessoa.getCpf().toString());
		pessoaReposiroty.save(pessoa);
	}

	public List<Pessoa> consultar(String cpf) {
		if (cpf != "")
			return pessoaReposiroty.findByCpfContainingIgnoreCase(cpf);
		return pessoaReposiroty.buscarCpf(cpf);
	}

	public void alterar(Pessoa pessoa) {
		pessoaReposiroty.save(pessoa);
	}

	public void apagar(Long id) {
		pessoaReposiroty.deleteById(id);
	}

}
