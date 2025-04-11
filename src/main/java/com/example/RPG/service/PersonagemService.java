package com.example.RPG.service;

import com.example.RPG.dto.*;
import com.example.RPG.exceptions.NaoEncontradoException;
import com.example.RPG.model.Personagem;
import com.example.RPG.repository.ItemMagicoRepository;
import com.example.RPG.repository.PersonagemRepository;
import com.example.RPG.util.RegraAddItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.RPG.mapper.PersonagemMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonagemService {


    @Autowired
    private PersonagemRepository personagemRepository;
    @Autowired
    private ItemMagicoRepository itemMagicoRepository;




    public ResponsePersonagemDTO criarPersonagem(PersonagemDTO dto) {
        Personagem novo = PersonagemMapper.toEntity(dto);

        int somaAtributos = novo.getForca() + novo.getDefesa();
        RegraAddItem.validarPontosInicial(somaAtributos);

        personagemRepository.save(novo);
        ResponsePersonagemDTO responseDTO = PersonagemMapper.toDTO(novo);

        return responseDTO;
    }

    public ResponsePersonagemDTO buscarPersonagemPorId(Long id) {
        Personagem personagem = personagemRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Personagem não encontrado"));
        ResponsePersonagemDTO responseDTO = PersonagemMapper.toDTO(personagem);

        return responseDTO;
    }

    public List<ResponsePersonagemDTO> listarTodos() {
        List<Personagem> personagens = personagemRepository.findAll();

        List<ResponsePersonagemDTO> responseDTO = personagens.stream()
                .map(PersonagemMapper::toDTO)
                .collect(Collectors.toList());

        return responseDTO;
    }

    public AtualizarPesonagemDTO atualizarNomePersonagem(Long id, AtualizarPesonagemDTO atualizarDto) {

        Personagem personagem = personagemRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Personagem não encontrado"));
        personagem.setNomeAventureiro(atualizarDto.getNomeAventureiro());
        personagemRepository.save(personagem);
        AtualizarPesonagemDTO responseDTO = PersonagemMapper.toDTOput(personagem);

        return responseDTO;
    }

    public ResponsePersonagemDTO deletarAutor(Long id) {
        if (!personagemRepository.existsById(id)) {
            throw new NaoEncontradoException("Personagem não encontrado");
        }
        Personagem personagem = personagemRepository.findById(id).get();
        ResponsePersonagemDTO PersonagemExluido = PersonagemMapper.toDTO(personagem);
        personagemRepository.deleteById(id);

        return PersonagemExluido;
    }

}

