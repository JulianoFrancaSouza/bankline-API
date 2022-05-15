package com.dio.santander.banklineAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.banklineAPI.dto.NovaMovimentacao;
import com.dio.santander.banklineAPI.model.Movimentacao;
import com.dio.santander.banklineAPI.repository.MovimentacaoRepository;
import com.dio.santander.banklineAPI.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
	
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private MovimentacaoService service;
	
	@GetMapping
	public List<Movimentacao> findAll(){
		return repository.findAll();
	}
	
	@PostMapping 
	public void save (@RequestBody NovaMovimentacao movimentacao) {
		service.save(movimentacao);
	}

}
