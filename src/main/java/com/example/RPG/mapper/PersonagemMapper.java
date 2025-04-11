package com.example.RPG.mapper;

import com.example.RPG.dto.*;
import com.example.RPG.model.ClassePerso;
import com.example.RPG.model.Personagem;
import com.example.RPG.util.SomarAtributos;

import java.util.List;
import java.util.stream.Collectors;

public class PersonagemMapper {

    public static Personagem toEntity(PersonagemDTO dto) {
        Personagem personagem = new Personagem();
        personagem.setNome(dto.getNome());
        personagem.setNomeAventureiro(dto.getNomeAventureiro());
        personagem.setClasse(dto.getClassePerso());
        personagem.setLevel(dto.getLevel());
        personagem.setForca(dto.getForca());
        personagem.setDefesa(dto.getDefesa());
           return personagem;
    }

    public static ResponsePersonagemDTO toDTO(Personagem personagem) {
        ResponsePersonagemDTO dto = new ResponsePersonagemDTO();
        dto.setId(personagem.getId());
        dto.setNomeAventureiro(personagem.getNomeAventureiro());
        dto.setNome(personagem.getNome());
        dto.setClassePerso(personagem.getClasse());
        dto.setLevel(personagem.getLevel());

        dto.setDefesa(personagem.getDefesa()+SomarAtributos.calcularDefesaTotal(personagem));
        dto.setForca(personagem.getForca()+SomarAtributos.calcularForcaTotal(personagem));

        List<ResponseITEMDTO> itensDTO = personagem.getListaItemMagico()
                .stream()
                .map(ItemMapper::toDTO)
                .collect(Collectors.toList());
        dto.setListaItemMagico(itensDTO);

        return dto;
    }

    public static ResponsePersonagemDTO toDTOpost(Personagem personagem) {
        ResponsePersonagemDTO dto = new ResponsePersonagemDTO();
        dto.setId(personagem.getId());
        dto.setNomeAventureiro(personagem.getNomeAventureiro());
        dto.setNome(personagem.getNome());
        dto.setClassePerso(personagem.getClasse());
        dto.setLevel(personagem.getLevel());
        dto.setDefesa(personagem.getDefesa());
        dto.setForca(personagem.getForca());

        List<ResponseITEMDTO> itensDTO = personagem.getListaItemMagico()
                .stream()
                .map(ItemMapper::toDTO)
                .collect(Collectors.toList());
        dto.setListaItemMagico(itensDTO);

        return dto;
    }

    public static AtualizarPesonagemDTO toDTOput(Personagem personagem) {
        AtualizarPesonagemDTO dto = new AtualizarPesonagemDTO();
        dto.setNomeAventureiro(personagem.getNomeAventureiro());

        return dto;
    }


}
