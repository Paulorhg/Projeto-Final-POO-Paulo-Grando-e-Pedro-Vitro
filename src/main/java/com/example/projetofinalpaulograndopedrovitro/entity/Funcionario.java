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

@Entity
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;


    @OneToMany
    @JoinColumn(name = "ID_FUNCIONARIO")
    private List<Horario> horarios;

    @ManyToMany
    @JoinTable(
    name="FuncionariosClientes",
    uniqueConstraints = @UniqueConstraint(columnNames = {"id_funcionario", "id_cliente"}),
    joinColumns = @JoinColumn(name = "id_funcionario"),
    inverseJoinColumns = @JoinColumn(name = "id_cliente")
    )
    private List<Cliente> clientes;
    
    @ManyToMany
    @JoinTable(
        name="FuncionarioServico",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_funcionario","id_servico"}),
        joinColumns = @JoinColumn(name = "id_funcionario"),
        inverseJoinColumns = @JoinColumn(name = "id_servico")
    )
    private List<Servico> funcionarios;

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

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Servico> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Servico> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "Funcionario [id=" + id + ", nome=" + nome + "]";
    }

    

}