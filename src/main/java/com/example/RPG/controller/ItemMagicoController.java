package com.example.RPG.controller;

import com.example.RPG.dto.ItemMagicoDTO;
import com.example.RPG.dto.ResponseITEMDTO;
import com.example.RPG.dto.ResponsePersonagemDTO;
import com.example.RPG.mapper.ItemMapper;
import com.example.RPG.model.ItemMagico;
import com.example.RPG.model.Personagem;
import com.example.RPG.service.ItemMagicoService;
import com.example.RPG.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/item_magico")
public class ItemMagicoController {
    @Autowired
    private ItemMagicoService itemMagicoService;


    @PostMapping
    public ResponseEntity<ResponseITEMDTO> criarItem(@RequestBody ItemMagicoDTO novoDTO) {
        ResponseITEMDTO itemCriado = itemMagicoService.criarItem(novoDTO);

        return ResponseEntity.created(URI.create("/item/" + itemCriado.getId())).body(itemCriado);
    }

    @PostMapping("/{id}/AddItens/{iditem}")
    public ResponseEntity<ResponsePersonagemDTO> adicionarItem(@PathVariable Long id, Long idItem) {
        ResponsePersonagemDTO atualizado = itemMagicoService.adicionarItemAoPersonagem(id, idItem);

        return ResponseEntity.ok(atualizado);
    }

    @PostMapping("/{id}/RemoverItens/{iditem}")
    public ResponseEntity<ResponsePersonagemDTO> RemoverItem(@PathVariable Long id, Long idItem) {
        ResponsePersonagemDTO atualizado = itemMagicoService.removerItemDoPersonagem(id, idItem);

        return ResponseEntity.ok(atualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseITEMDTO> buscarPorId(@PathVariable Long id) {
        ResponseITEMDTO iten = itemMagicoService.buscarItemPorID(id);

        return ResponseEntity.ok(iten);
    }

    @GetMapping
    public ResponseEntity<List<ResponseITEMDTO>> listarTodos() {
        List<ResponseITEMDTO> itens = itemMagicoService.listarTodososItens();

        return ResponseEntity.ok(itens);
    }

    @GetMapping("/{PersonagemId}/Itens_do_personagem")
    public ResponseEntity<List<ResponseITEMDTO>> itensPorPersonagem(@PathVariable Long PersonagemId){
        List<ResponseITEMDTO> lista = itemMagicoService.listarItensdoPersonagem(PersonagemId);

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{PersonagemId}/Procurar_Amuleto")
    public ResponseEntity<ResponseITEMDTO> buscarPorAmuleto(@PathVariable Long PersonagemId){
        ResponseITEMDTO Amuleto = itemMagicoService.BuscarAmuletoPersonagem(PersonagemId);

        return ResponseEntity.ok(Amuleto);
    }

}
