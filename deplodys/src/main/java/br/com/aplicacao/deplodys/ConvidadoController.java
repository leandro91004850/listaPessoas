package br.com.aplicacao.deplodys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.aplicacao.deplodys.model.Convidado;
import br.com.aplicacao.deplodys.service.ConvidadoService;



@Controller// COM A TAG CONTROLLER NAO PRECISO ME PREOCUPA EM FICA CONFIGURANDO ARQUIVO XML --- MAPEANDO
public class ConvidadoController {
	
	@Autowired
	private ConvidadoService service;
	
	@RequestMapping("/") // MAPEAMENTO PARA RETORNA O INDEX.HTML NO BROWSER
	public String index() {
		return "index";
	}
	
	@RequestMapping("listaconvidados")// URL QUE IREMOS CHAMA NOSSO TEMPLATE
	public String ListaConvidados(Model model) {// MAPEAMENTO PARA MINHA LISTA DE CONVIDADOS 
		
		// LISTA DE CONVIDADO
	    Iterable<Convidado> convidados = service.obterTodos();// INDO NO BANCO E PEGANDO ESSA TABELA e RETORNANDO TODOS ESSES RESULTADOS --- AULA 2 VIDEO 2
		model.addAttribute("convidados", convidados); // PARA A VISUALIZAÇÃO --AULA 2 VIDEO 2
	 	
		return "listaconvidados";
	}
	

	// MÉTODO QUE IRA SALVAR OS DADOS RECEBIDO NO FORM DO HTML AULA 3 VIDEO 1--->
	@RequestMapping(value="salvar", method = RequestMethod.POST)// GRAVANDO OS PRODUTOS CADASTRADOS CAPITURADOS EM NOSSO FORM DE LISTACONVIDADOS.HTML
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model) {//	SALVANDO NO BANCO DE DADOS
		
		Convidado novoConvidado = new Convidado(nome, email, telefone);// ENTENDIDA QUE VAI RECEBER OS 3 PARAMETROS
	
		service.salvar(novoConvidado);//OPERAÇÃO PARA REALIZAR O SALVAMENTO DO DADOS 
	
		//new EmailService().enviar(nome, email);
		
		Iterable<Convidado> convidados = service.obterTodos();// CRIANDO UMA VARIAVEL PARA QUANDO SALVAMOS OS DADOS NO BANCO VOLTAR LISTANDO TODO OS DADOS NOVAMENTE CHAMANDO O MODEL NO METODO SALVAR
		
		model.addAttribute("convidados", convidados);
		
		return "listaconvidados"; // SOMENTE PARA TESTAMOS SE ESTA FUNCIONANDO 
		
	}
	
}