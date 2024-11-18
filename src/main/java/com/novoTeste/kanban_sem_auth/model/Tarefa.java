package com.novoTeste.kanban_sem_auth.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String titulo;
    private String descricao;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCadastro;
    private String status; //Depois usaremos ENUM
    private String prioridade; //Depois usaremos ENUM
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataLimite;

    //Construtor vazio, obrigatório para o JPA
    public Tarefa() {
    }

    //GETS----------------------------------------
    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    //SETS------------------------------------------
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    @Override
    public String toString() {
        return "{\n" +
                "ID: " + id +
                "\nTitulo: " + titulo +
                "\nDescrição: " + descricao +
                "\nData de Cadastro: "+ dataCadastro +
                "\nPrioridade: " + prioridade +
                "\nData limite: " + dataLimite +
                "\n}\n";
    }
}
