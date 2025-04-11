package com.example.RPG.dto;

import com.example.RPG.model.Item;

public class ResponseITEMDTO {
    private long id;
    private String nome;
    private Item tipoDoItem;
    private Integer Forca;
    private Integer Defesa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Item getTipoDoItem() {
        return tipoDoItem;
    }

    public void setTipoDoItem(Item tipoDoItem) {
        this.tipoDoItem = tipoDoItem;
    }

    public Integer getForca() {
        return Forca;
    }

    public void setForca(Integer forca) {
        Forca = forca;
    }

    public Integer getDefesa() {
        return Defesa;
    }

    public void setDefesa(Integer defesa) {
        Defesa = defesa;
    }
}
