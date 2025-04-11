package com.example.RPG.mapper;

import com.example.RPG.dto.ItemMagicoDTO;

import com.example.RPG.dto.ResponseITEMDTO;
import com.example.RPG.model.ItemMagico;


public class ItemMapper {

    public static ItemMagico toEntity(ItemMagicoDTO dto) {
        ItemMagico item = new ItemMagico();
        item.setNome(dto.getNome());
        item.setTipoDoItem(dto.getTipoDoItem());
        item.setForca(dto.getForca());
        item.setDefesa(dto.getDefesa());
        return item;
    }

    public static ResponseITEMDTO toDTO(ItemMagico item) {
        ResponseITEMDTO itemDTO = new ResponseITEMDTO();
        itemDTO.setId(item.getId());
        itemDTO.setNome(item.getNome());
        itemDTO.setTipoDoItem(item.getTipoDoItem());
        itemDTO.setForca(item.getForca());
        itemDTO.setDefesa(item.getDefesa());
        return itemDTO;
    }

}
