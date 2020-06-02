package com.example.projetofinalpaulograndopedrovitro.service;

import java.util.List;

import com.example.projetofinalpaulograndopedrovitro.entity.Funcionario;
import com.example.projetofinalpaulograndopedrovitro.repository.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository repository;
    
    public List<Funcionario> getFuncionarios(){
        return repository.findAll();
    }

    public void salvar(Funcionario funcionario){
        repository.save(funcionario);
    }

	public Funcionario getAlunoById(Integer id) {
		return repository.findById(id).get();
	}
}