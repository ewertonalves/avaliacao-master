package br.com.pamcary.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Entity
@Table(name = "T_PESSOA")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PESSOA_CODIGO")
	private Long codigo;

	@Column(name = "T_PESSOA_NOME", columnDefinition = "VARCHAR(60)")
	private String nome;

	@Column(name = "T_PESSOA_CPF", columnDefinition = "VARCHAR(11")
	private String cpf;

	@Column(name = "T_PESSOA_DATA_NASCIMENTO", columnDefinition = "DATETIME")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDate dataNascimento;

	public Pessoa(Long codigo ,String nome, String cpf, LocalDate dataNascimento) {
		this.codigo = getCodigo();
		this.nome = getNome();
		this.cpf = getCpf();
		this.dataNascimento = getDataNascimento();
	}

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public LocalDate setDataNascimento(LocalDate dataNascimento) {
		return this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento
				+ "]";
	}

}
