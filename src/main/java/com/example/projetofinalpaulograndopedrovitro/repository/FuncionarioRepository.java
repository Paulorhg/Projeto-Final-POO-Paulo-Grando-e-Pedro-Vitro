package com.example.projetofinalpaulograndopedrovitro.repository;

import com.example.projetofinalpaulograndopedrovitro.entity.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    
}