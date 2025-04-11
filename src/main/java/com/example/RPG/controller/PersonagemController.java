package com.example.RPG.controller;

import com.example.RPG.dto.*;
import com.example.RPG.mapper.ItemMapper;
import com.example.RPG.mapper.PersonagemMapper;
import com.example.RPG.model.ItemMagico;
import com.example.RPG.model.Personagem;
import com.example.RPG.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {
    @Autowired
    private PersonagemService personagemService;


    @PostMapping
    public ResponseEntity<ResponsePersonagemDTO> criar(@RequestBody PersonagemDTO novoDTO) {
        ResponsePersonagemDTO personagemCriado = personagemService.criarPersonagem(novoDTO);

        return ResponseEntity.created(URI.create("/personagens/" + personagemCriado.getId())).body(personagemCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsePersonagemDTO> buscarPorId(@PathVariable Long id) {
        ResponsePersonagemDTO personagemEncontrado = personagemService.buscarPersonagemPorId(id);

        return ResponseEntity.ok(personagemEncontrado);
    }

    @GetMapping
    public ResponseEntity<List<ResponsePersonagemDTO>> listarTodos() {
        List<ResponsePersonagemDTO> personagensEncontrado = personagemService.listarTodos();

        return ResponseEntity.ok(personagensEncontrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtualizarPesonagemDTO> atualizar(@PathVariable Long id, @RequestBody AtualizarPesonagemDTO atualizarDTO) {
        AtualizarPesonagemDTO atualizado = personagemService.atualizarNomePersonagem(id, atualizarDTO);

        return ResponseEntity.ok(atualizarDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponsePersonagemDTO> deletar(@PathVariable Long id) {
        ResponsePersonagemDTO personagem = personagemService.deletarAutor(id);

        return ResponseEntity.ok(personagem);
    }

}
