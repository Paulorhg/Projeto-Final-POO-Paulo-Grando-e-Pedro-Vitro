package com.example.projetofinalpaulograndopedrovitro.service;

import java.util.List;

import com.example.projetofinalpaulograndopedrovitro.entity.Servico;
import com.example.projetofinalpaulograndopedrovitro.repository.ServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {
    
    @Autowired
    private ServicoRepository repository;

    public List<Servico> getServicos(){
        return repository.findAll();
    }

    public void salvar(Servico servico){
        repository.save(servico);
    }

	public Servico getAlunoById(Integer id) {
		return repository.findById(id).get();
	}
    
}