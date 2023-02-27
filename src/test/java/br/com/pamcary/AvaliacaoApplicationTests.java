package br.com.pamcary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pamcary.model.Pessoa;
import br.com.pamcary.repository.PessoaReposiroty;
import br.com.pamcary.service.PessoaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AvaliacaoApplicationTests {

	@MockBean
	private PessoaReposiroty pessoaReposiroty;

	@Autowired
	private PessoaService pessoaService;

	@Test
	public void testSalvar() {
		Pessoa pessoa = new Pessoa(1L, "João da Silva", "38545517842", LocalDate.of(1996, 8, 8));
		when(pessoaReposiroty.existsByCpf(pessoa.getCpf())).thenReturn(false);
		pessoaService.salvar(pessoa);
		verify(pessoaReposiroty).save(pessoa);
	}

	@Test
	public void testConsultar() {
		// Cria a lista de pessoas
		List<Pessoa> listaPessoas = new ArrayList<>();
		listaPessoas.add(new Pessoa(1L, "João da Silva", "38545517842", LocalDate.of(1996, 8, 8)));
		listaPessoas.add(new Pessoa(2L, "Fernando Cardoso", "12354469875", LocalDate.of(1996, 8, 8)));

		// Quando o método consultar for chamado com o CPF 38545517842, espera-se que o
		// método retorne uma lista contendo apenas o João da Silva
		when(pessoaReposiroty.findByCpfContainingIgnoreCase("38545517842")).thenReturn(listaPessoas);
		List<Pessoa> resultado = pessoaService.consultar("38545517842");
		assertEquals(1, resultado.size());
		assertEquals("João da Silva", resultado.get(0).getNome());
	}

	@Test
	public void testAlterar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Teste");
		pessoa.setCpf("1234567890");
		pessoa.setDataNascimento(LocalDate.of(1999, 8, 8));

		when(pessoaReposiroty.save(pessoa)).thenReturn(pessoa);

		pessoaService.alterar(pessoa);
		verify(pessoaReposiroty, times(1)).save(pessoa);
		assertEquals("Teste", pessoa.getNome());
		assertEquals(LocalDate.of(1999, 8, 8), pessoa.getDataNascimento());
		assertEquals("1234567890", pessoa.getCpf());
	}

	@Test
	public void testApagar() {
		Long id = 1L;
		Pessoa pessoa = new Pessoa();
		pessoa.setCodigo(id);
		pessoaReposiroty.save(pessoa);
		pessoaReposiroty.deleteById(id);
		assertNull(pessoaReposiroty.findById(id));
	}

	@Test
	public void contextLoads() {
	}

}
