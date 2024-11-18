package com.novoTeste.kanban_sem_auth.controller;


import com.novoTeste.kanban_sem_auth.model.Tarefa;
import com.novoTeste.kanban_sem_auth.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    //POST cria a tarefa
    @PostMapping
    public String criarTarefa(@RequestBody Tarefa tarefa) {
        if (tarefa.getTitulo() == null || tarefa.getTitulo().isEmpty()) {
            return "Erro: O título da tarefa é obrigatório!";
        }

        if (tarefa.getDataCadastro() == null) {
            tarefa.setDataCadastro(LocalDate.now()); // DATANDO HOJE
        }

        if (tarefa.getStatus() == null) {
            tarefa.setStatus("A Fazer"); //SEMPRE COM A FAZER PRIMEIROW
        }

        tarefaService.insertTarefa(tarefa);
        return "Tarefa *"+tarefa.getTitulo()+"* adicionada com sucesso na coluna: "+tarefa.getStatus().toUpperCase();
    }
    @GetMapping
    public String listarTarefa() {
        return "-----------------A FAZER------------------------\n" + tarefaService.selectTarefaByStatus("A Fazer") +
                "\n-----------------------EM PROGRESSO----------------\n"+tarefaService.selectTarefaByStatus("Em progresso") +
                "\n-------------------CONCLUIDAS--------------------\n"+tarefaService.selectTarefaByStatus("Concluida");
    }
    //Prof, aqui estou retornando String, para que as tratativas da Regra de negócio fique por conta do FrontEnd



    @PutMapping("/{id}/move")
    public Tarefa avancarTarefa(@PathVariable int id) {
        return tarefaService.avancarTarefa(id);

    }

//    @PutMapping("/{id}/aprovar")
//    public Tarefa aprovarTarefa(@PathVariable int id) {
//        //vou fazer essa alteração para ser o que vai mudar as tabelas
//        return tarefaService.aprovarTarefa(id);
//    }

    @GetMapping("/{id}")
    public Tarefa buscarById(@PathVariable int id) {
        return tarefaService.selectTarefaById(id);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable int id) {
        tarefaService.deletarTarefa(id);
    }



}
