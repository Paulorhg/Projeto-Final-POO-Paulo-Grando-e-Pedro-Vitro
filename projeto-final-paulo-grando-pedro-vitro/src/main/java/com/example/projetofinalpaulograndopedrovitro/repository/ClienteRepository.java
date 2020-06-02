package com.example.projetofinalpaulograndopedrovitro.repository;

import com.example.projetofinalpaulograndopedrovitro.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}