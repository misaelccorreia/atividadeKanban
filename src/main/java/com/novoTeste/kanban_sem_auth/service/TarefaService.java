package com.novoTeste.kanban_sem_auth.service;

import com.novoTeste.kanban_sem_auth.model.Tarefa;
import com.novoTeste.kanban_sem_auth.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    //não estou utilizando
    public List<Tarefa> SellectAllTarefa() {
        return tarefaRepository.findAll();
    }

    //SALVAR = INSERT
    public Tarefa insertTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    //DELETE
    public void deletarTarefa(int id) {
        tarefaRepository.deleteById(id);
    }

    //select * from Tarefa where "status"=A fazer
    public List<Tarefa> selectTarefaByStatus(String status) {
        return tarefaRepository.findByStatus(status);
    }



    //select * from Tarefa where "id"=id
    public Tarefa selectTarefaById(int id) {
        Optional<Tarefa> task = tarefaRepository.findById(id);
        if(task.isPresent()) {
            return task.get();
        } else {
            throw new RuntimeException("O id inserido não corresponde a nenhuma tarefa!");
        }
    }

    public Tarefa avancarTarefa(int id) {
        Tarefa task = selectTarefaById(id);
        if(task.getStatus().equals("A Fazer")) {
            task.setStatus("Em Progresso");
        }else if(task.getStatus().equals("Em Progresso")) {
            task.setStatus("Concluido");
        }
        return task;
    }
    //por enquanto seguindo até aqui copiadinho para entender a estrutura de criação
}
