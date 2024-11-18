package com.novoTeste.kanban_sem_auth.service;

import com.novoTeste.kanban_sem_auth.model.Kanban;
import com.novoTeste.kanban_sem_auth.model.Tarefa;
import com.novoTeste.kanban_sem_auth.repository.KabanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KabanService {

    @Autowired
    private KabanRepository kabanRepository;

    //criando KANBAN
    public Kanban criarKanban(Kanban kanban) {
        return kabanRepository.save(kanban);
    }


    //CRIANDO O MEU INSERT
    public void adicionarTarefa(Tarefa tarefa, int kanbanId, String coluna) {
        // Buscar o Kanban pelo ID
        Optional<Kanban> optionalKanban = kabanRepository.findById(kanbanId);

        if (optionalKanban.isPresent()) {
            Kanban kanban = optionalKanban.get();

            // Adicionar a tarefa na coluna correspondente
            switch (coluna.toLowerCase()) {
                case "afazer":
                    kanban.getaFazer().add(tarefa);
                    break;
                case "emprogresso":
                    kanban.getEmProgresso().add(tarefa);
                    break;
                case "concluido":
                    kanban.getConcluido().add(tarefa);
                    break;
                default:
                    throw new IllegalArgumentException("Coluna inválida: " + coluna);
            }

            // Salvar o Kanban atualizado
            kabanRepository.save(kanban);
        } else {
            throw new RuntimeException("Kanban não encontrado com ID: " + kanbanId);
        }
    }
}

