package br.com.aplicacao.deplodys.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


//CRIANDO UM METODO PARA IR BUSCAR TODOS ESSES CONVIDADOS. INDO NO BANCO E MOSTRANDO ESSES DADOS

@Entity(name="convidado") // NOME DA MINHA TABELA NO BANCO DE DADOS-- AULA 2 VIDEO 2
public class Convidado {
	
	// CONFIGURAÇÕES DA MINHA TABELA
	
	@Id
	@GeneratedValue
	private Integer id;	// Integer== int
	
	
	private String nome;
	private String email;
	private String telefone;
	
	// CONSTRUCTOR QUE SERÁ ASSOCIADO AO SALVAR NOSSO DADOS --- AULA 3 VIDEO 1
	public Convidado() {
		
	}
		
	public Convidado(String nome, String email, String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
	
	
	
	// ggas
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
	
}
