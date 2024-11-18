package com.novoTeste.kanban_sem_auth.repository;

import com.novoTeste.kanban_sem_auth.model.Kanban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KabanRepository extends JpaRepository<Kanban,Integer> {
}
