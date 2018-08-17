package br.com.aplicacao.deplodys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aplicacao.deplodys.model.Convidado;
import br.com.aplicacao.deplodys.repository.ConvidadoRepository;

@Service
public class ConvidadoService {
	
	@Autowired
	private ConvidadoRepository repository; // CRIANDO UM OBJETO 
	
	public Iterable<Convidado> obterTodos(){
		
		// LISTA DE CONVIDADO
	    Iterable<Convidado> convidados = repository.findAll();// INDO NO BANCO E PEGANDO ESSA TABELA e RETORNANDO TODOS ESSES RESULTADOS --- AULA 2 VIDEO 2
		
	    return convidados;
	}

	//OPERAÇÃO PARA REALIZAR O SALVAMENTO DO DADOS 
	public void salvar(Convidado convidado) {
		repository.save(convidado);
		
	}



}

