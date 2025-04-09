package com.example.RPG.controller;

import com.example.RPG.model.Personagem;
import com.example.RPG.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {
    @Autowired
    private PersonagemService personagemService;


    @PostMapping
    public ResponseEntity<Personagem> criar(@RequestBody Personagem novo) {
        Personagem response = personagemService.criarPersonagem(novo);
        return ResponseEntity.created(URI.create("/autores/" + response.getId())).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personagem> buscarPorId(@PathVariable Long id) {
        Personagem personagem = personagemService.buscarPersonagemPorId(id);
        return ResponseEntity.ok(personagem);
    }

    @GetMapping
    public ResponseEntity<List<Personagem>> listarTodos() {
        List<Personagem> personagems = personagemService.listarTodos();
        return ResponseEntity.ok(personagems);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personagem> atualizar(@PathVariable Long id, @RequestBody Personagem atualizar) {
        Personagem atualizado = personagemService.atualizarPersonagem(id, atualizar);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        personagemService.deletarAutor(id);
        return ResponseEntity.noContent().build(); // HTTP 204 - No Content
    }



}
