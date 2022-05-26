package com.dio.santander.banklineAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.santander.banklineAPI.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer>{
    public List<Movimentacao>findByIdConta(Integer idConta);

}
