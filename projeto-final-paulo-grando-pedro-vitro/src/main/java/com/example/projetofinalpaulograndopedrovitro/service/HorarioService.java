package com.example.projetofinalpaulograndopedrovitro.service;

import java.util.List;

import com.example.projetofinalpaulograndopedrovitro.entity.Horario;
import com.example.projetofinalpaulograndopedrovitro.repository.HorarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioService {
    
    @Autowired
    private HorarioRepository repository;
    
    public List<Horario> getHorarios(){
        return repository.findAll();
    }

    public void salvar(Horario horario){
        repository.save(horario);
    }

	public Horario getAlunoById(Integer id) {
		return repository.findById(id).get();
	}
}