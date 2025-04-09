package com.example.RPG.service;

import com.example.RPG.model.Personagem;
import com.example.RPG.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {
    @Autowired
    private PersonagemRepository personagemRepository;

    public Personagem criarPersonagem(Personagem novo) {
        return personagemRepository.save(novo);
    }

    public Personagem buscarPersonagemPorId(Long id) {
        Personagem personagem = personagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));

        return personagem;
    }

    public List<Personagem> listarTodos() {
        List<Personagem> personagems = personagemRepository.findAll();
        return personagems;
    }


    public Personagem atualizarPersonagem(Long id, Personagem atualizar) {
        Personagem personagem = personagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
        return personagemRepository.save(atualizar);
    }

    public void deletarAutor(Long id) {
        if (!personagemRepository.existsById(id)) {
            throw new RuntimeException("Personagem não encontrado");
        }
        personagemRepository.deleteById(id);
    }
}

