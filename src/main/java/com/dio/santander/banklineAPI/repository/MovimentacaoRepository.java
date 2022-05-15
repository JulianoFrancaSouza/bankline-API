package com.dio.santander.banklineAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.santander.banklineAPI.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer>{

}
