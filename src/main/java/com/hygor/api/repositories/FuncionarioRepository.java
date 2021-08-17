package com.hygor.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hygor.api.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
