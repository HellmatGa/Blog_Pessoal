package com.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;

@RestController // anotação que diz para string que essa é uma controladora de rotas e acesso aos metodos
@RequestMapping("/postagens") // rota para chegar nessa classe "insomnia"
@CrossOrigin(origins = "*", allowedHeaders = "*")// liberar acesso a outras maquinas
public class PostagemController {

	@Autowired //Injeção de dependencias - instanciar a classe PostagemRepository
	private PostagemRepository postagemRepository;
	
	@GetMapping //define o verbo http que atende esse metodo
	public ResponseEntity<List<Postagem>> getAll(){
		//reponseEntity - Classe 
		return ResponseEntity.ok(postagemRepository.findAll());
		//SELCET * FROM tb_postagens
	}
	
}
