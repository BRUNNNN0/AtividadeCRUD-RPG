package com.example.RPG.service;

import com.example.RPG.dto.ItemMagicoDTO;
import com.example.RPG.dto.ResponseITEMDTO;
import com.example.RPG.dto.ResponsePersonagemDTO;
import com.example.RPG.exceptions.NaoEncontradoException;
import com.example.RPG.exceptions.RegraDeNegocioException;
import com.example.RPG.mapper.PersonagemMapper;
import com.example.RPG.model.Item;
import com.example.RPG.model.ItemMagico;
import com.example.RPG.mapper.ItemMapper;
import com.example.RPG.model.Personagem;
import com.example.RPG.repository.ItemMagicoRepository;
import com.example.RPG.repository.PersonagemRepository;
import com.example.RPG.util.RegraAddItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemMagicoService {

    @Autowired
    ItemMagicoRepository itemMagicoRepository;

    @Autowired
    PersonagemRepository personagemRepository;


    public ResponseITEMDTO criarItem(ItemMagicoDTO novoDTO) {
        ItemMagico novoItem = ItemMapper.toEntity(novoDTO);

        RegraAddItem.validar(novoItem);

        itemMagicoRepository.save(novoItem);
        ResponseITEMDTO responseDTO = ItemMapper.toDTO(novoItem);

        return responseDTO;
    }

    public ResponseITEMDTO buscarItemPorID(Long id) {
        ItemMagico itemMagico = itemMagicoRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Item não encontrado"));
        ResponseITEMDTO responseDTO = ItemMapper.toDTO(itemMagico);

        return responseDTO;
    }

    public List<ResponseITEMDTO> listarTodososItens() {
        List<ItemMagico> itens = itemMagicoRepository.findAll();

        List<ResponseITEMDTO> responseDTO = itens.stream()
                .map(ItemMapper::toDTO)
                .collect(Collectors.toList());

        return responseDTO;
    }

    public List<ResponseITEMDTO> listarItensdoPersonagem (Long personagemId){
        Personagem personagem = personagemRepository.findById(personagemId).orElseThrow(() -> new NaoEncontradoException("Personagem não encontrado"));

         List<ResponseITEMDTO> responseDTO = personagem.getListaItemMagico().stream()
                .map(ItemMapper::toDTO)
                .collect(Collectors.toList());

        return responseDTO;
    }

    public ResponseITEMDTO BuscarAmuletoPersonagem (Long personagemId){
        Personagem personagem = personagemRepository.findById(personagemId).orElseThrow(() -> new NaoEncontradoException("Personagem não encontrado"));

        ResponseITEMDTO Amuleto = personagem.getListaItemMagico().stream()
                .filter(item -> item.getTipoDoItem() == Item.Amuleto)
                .findFirst()
                .map(ItemMapper::toDTO)
                .orElseThrow(() -> new NaoEncontradoException("O personagem não tem um Amuleto."));

        return Amuleto;
    }

    public ResponsePersonagemDTO adicionarItemAoPersonagem(Long id, Long itemId) {
        Personagem personagem = personagemRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Personagem não encontrado"));
        ItemMagico itemMagico = itemMagicoRepository.findById(itemId).orElseThrow(() -> new NaoEncontradoException("Item não encontrado"));

        RegraAddItem.validarAmuletoExistente(personagem,itemMagico);

        personagem.adicionarItem(itemMagico);
        itemMagicoRepository.save(itemMagico);
        personagemRepository.save(personagem);

        ResponsePersonagemDTO personagemComitem = PersonagemMapper.toDTOpost(personagem);

        return personagemComitem;
    }

    public ResponsePersonagemDTO removerItemDoPersonagem(Long id, Long itemId) {
        Personagem personagem = personagemRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Personagem não encontrado"));
        ItemMagico itemMagico = itemMagicoRepository.findById(itemId).orElseThrow(() -> new NaoEncontradoException("Item não encontrado"));


        personagem.removerItem(itemMagico);
        personagemRepository.save(personagem);

        ResponsePersonagemDTO PersonagemAtualizado = PersonagemMapper.toDTOpost(personagem);

        return PersonagemAtualizado;
    }


}