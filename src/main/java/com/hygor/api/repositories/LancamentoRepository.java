package com.hygor.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hygor.api.entities.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
