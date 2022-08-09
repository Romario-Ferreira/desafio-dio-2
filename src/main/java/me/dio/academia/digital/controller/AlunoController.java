package me.dio.academia.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoServiceImpl service;
	
	@GetMapping
	public List<Aluno> getAll(){
		return service.getAll();
	}
	
	@PostMapping(value = "/save")
	public Aluno create(@RequestBody AlunoForm form) {
		return service.create(form);
	}
	
	@GetMapping(value = "/avaliacoes")
	public List<AvaliacaoFisica> getAllAvaliacoesById(@RequestParam(name = "id", defaultValue = "0") Long id){
		return service.getAllAvaliacoesById(id);
	}
}
