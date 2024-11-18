package com.novoTeste.kanban_sem_auth.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Kanban {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        @OneToMany
        private List<Tarefa> aFazer;
        @OneToMany
        private List<Tarefa> emProgresso;
        @OneToMany
        private List<Tarefa> concluido;

        public Kanban() {
        }

        public List<Tarefa> getaFazer() {
                return aFazer;
        }

        public void setaFazer(List<Tarefa> aFazer) {
                this.aFazer = aFazer;
        }

        public List<Tarefa> getEmProgresso() {
                return emProgresso;
        }

        public void setEmProgresso(List<Tarefa> emProgresso) {
                this.emProgresso = emProgresso;
        }

        public List<Tarefa> getConcluido() {
                return concluido;
        }

        public void setConcluido(List<Tarefa> concluido) {
                this.concluido = concluido;
        }
}

