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
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private double preco;
    
    @ManyToMany
    @JoinTable(
        name="FuncionarioServico",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_funcionario","id_servico"}),
        joinColumns = @JoinColumn(name = "id_servico"),
        inverseJoinColumns = @JoinColumn(name = "id_funcionario")
    )
    private List<Funcionario> funcionarios;

    @OneToMany
    @JoinColumn(name = "ID_SERVICO")
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return nome;
    }

    
    
}