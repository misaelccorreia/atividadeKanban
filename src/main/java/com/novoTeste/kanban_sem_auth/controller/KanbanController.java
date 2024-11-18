package com.novoTeste.kanban_sem_auth.controller;

import com.novoTeste.kanban_sem_auth.model.Kanban;
import com.novoTeste.kanban_sem_auth.model.Tarefa;
import com.novoTeste.kanban_sem_auth.service.KabanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kanban")
public class KanbanController {

    @Autowired
    private KabanService kabanService;

    //Criando o POST para criar o Kanban
    @PostMapping
    public ResponseEntity<Kanban> criarKanban(@RequestBody Kanban kanban) {
        Kanban novoKanban = kabanService.criarKanban(kanban);
        return ResponseEntity.ok(novoKanban);
    }

    // POST para adicionar uma tarefa a uma coluna específica do Kanban
    @PostMapping("/{id}/adicionar-tarefa/{coluna}")
    public ResponseEntity<?> adicionarTarefa(
            @PathVariable int id,
            @PathVariable String coluna,
            @RequestBody Tarefa tarefa) {
        try {
            kabanService.adicionarTarefa(tarefa, id, coluna);
            return ResponseEntity.ok("Tarefa adicionada com sucesso à coluna: " + coluna);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao adicionar tarefa: " + e.getMessage());
        }
    }
}