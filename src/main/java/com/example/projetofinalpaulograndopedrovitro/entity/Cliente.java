package com.example.projetofinalpaulograndopedrovitro.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


/**
 * Cliente
 */

@Entity
public class Cliente implements Serializable{

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String nome;
private int telefone;

@OneToMany
@JoinColumn(name = "ID_CLIENTE")
private List<Horario> horarios;



public static long getSerialversionuid() {
    return serialVersionUID;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public int getTelefone() {
    return telefone;
}

public void setTelefone(int telefone) {
    this.telefone = telefone;
}

public List<Horario> getHorarios() {
    return horarios;
}

public void setHorarios(List<Horario> horarios) {
    this.horarios = horarios;
}

    
@Override
public String toString() {
    return nome;
}




    
}