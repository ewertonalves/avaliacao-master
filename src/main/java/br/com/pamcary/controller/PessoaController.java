package br.com.pamcary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pamcary.model.MessageResponse;
import br.com.pamcary.model.Pessoa;
import br.com.pamcary.service.PessoaService;

@RestController
@RequestMapping("api/v1/avaliacao-pamcary")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping(value = "/salvar", consumes = "application/json; charset=UTF-8")
	public ResponseEntity<MessageResponse> salvar(@RequestBody Pessoa pessoa){
		try {
			pessoaService.salvar(pessoa);
			return new ResponseEntity<MessageResponse>(new MessageResponse("Pessoa cadastrado com sucesso!"), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<MessageResponse>(new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/consultar")
	public ResponseEntity<List<Pessoa>> consultar(@RequestParam(value = "cpf", defaultValue = "") String cpf) {
		return new ResponseEntity<List<Pessoa>>(pessoaService.consultar(cpf), HttpStatus.OK);
	}
	
	@PutMapping(value="/alterar", produces="application/json; charset=UTF-8", consumes="application/json; charset=UTF-8")
	public ResponseEntity<MessageResponse> alterar(@RequestBody Pessoa pessoa){
		try {
			pessoaService.alterar(pessoa);
			return new ResponseEntity<MessageResponse>(new MessageResponse("Pessoa alterado com sucesso"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<MessageResponse>(new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/apagar", produces="application/json; charset=UTF-8")
	public ResponseEntity<MessageResponse> apagar(@RequestParam Long id){
		try {
			pessoaService.apagar(id);
			return new ResponseEntity<MessageResponse>(new MessageResponse("Pessoa deletado com sucesso!"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<MessageResponse>(new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR); 
		}

	}















} 
