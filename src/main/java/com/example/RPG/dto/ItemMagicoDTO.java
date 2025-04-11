package com.example.RPG.dto;

import com.example.RPG.model.Item;


public class ItemMagicoDTO {
    private String nome;
    private Item tipoDoItem;
    private Integer Forca;
    private Integer Defesa;





    public ItemMagicoDTO() {
        this.nome = nome;
        this.tipoDoItem = tipoDoItem;
        this.Forca = Forca;
        this.Defesa = Defesa;
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
