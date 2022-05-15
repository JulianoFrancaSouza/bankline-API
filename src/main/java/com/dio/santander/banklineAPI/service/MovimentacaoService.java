package com.dio.santander.banklineAPI.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.banklineAPI.dto.NovaMovimentacao;
import com.dio.santander.banklineAPI.model.Correntista;
import com.dio.santander.banklineAPI.model.Movimentacao;
import com.dio.santander.banklineAPI.model.MovimentacaoTipo;
import com.dio.santander.banklineAPI.repository.CorrentistaRepository;
import com.dio.santander.banklineAPI.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository repository;
	@Autowired
	private CorrentistaRepository correntistaRepository;
	public void save(NovaMovimentacao novaMovimentacao) {
		Movimentacao movimentacao = new Movimentacao();
		
//		Double valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
		
		Double valor = novaMovimentacao.getValor();
		if(novaMovimentacao.getTipo() == MovimentacaoTipo.DESPESA) {
			valor = valor * -1;
		}else if(novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA){
			valor = valor;
		}else {
			System.out.println("erro valor");
			System.err.println("erro valor");
		}
 		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setValor(valor);
		movimentacao.setTipo(novaMovimentacao.getTipo());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		if(correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		}else {
			System.out.println("erro correntista");
			System.err.println("erro correntista");
		}
		repository.save(movimentacao);
		
	}

}
