package com.example.projetofinalpaulograndopedrovitro.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Horario implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate hora;
    private Servico servico;

    @ManyToOne
    @JoinColumn(name = "ID_FUNCIONARIO")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getHora() {
        return hora;
    }

    public void setHora(LocalDate hora) {
        this.hora = hora;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Horario [hora=" + hora + ", id=" + id + "]";
    }

    

    
}