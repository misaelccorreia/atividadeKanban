package com.novoTeste.kanban_sem_auth.repository;

import com.novoTeste.kanban_sem_auth.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
    List<Tarefa> findByStatus(String status);
}
