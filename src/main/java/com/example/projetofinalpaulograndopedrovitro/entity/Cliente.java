package com.example.projetofinalpaulograndopedrovitro.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

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

@ManyToMany
@JoinTable(
    name="FuncionariosClientes",
uniqueConstraints = @UniqueConstraint(columnNames = {"id_funcionario", "id_cliente"}),
joinColumns = @JoinColumn(name = "id_cliente"),
inverseJoinColumns = @JoinColumn(name = "id_funcionario")
)
private List<Funcionario> funcionarios;

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

public List<Funcionario> getFuncionarios() {
    return funcionarios;
}

public void setFuncionarios(List<Funcionario> funcionarios) {
    this.funcionarios = funcionarios;
}
    
@Override
public String toString() {
    return "Cliente [id=" + id + ", nome=" + nome + "]";
}




    
}