package com.example.projetofinalpaulograndopedrovitro.service;

import java.util.List;

import com.example.projetofinalpaulograndopedrovitro.entity.Cliente;
import com.example.projetofinalpaulograndopedrovitro.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repository;

    public List<Cliente> getClientes(){
        return repository.findAll();
    }

    public void salvar(Cliente cliente){
        repository.save(cliente);
    }

	public Cliente getClienteById(Integer id) {
		return repository.findById(id).get();
    }
    
    public void remover(Cliente cliente) {
        repository.delete(cliente);
	}
}