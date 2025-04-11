package com.example.RPG.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ItemMagico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Item tipoDoItem;
    private Integer Forca;
    private Integer Defesa;

    @ManyToOne
    @JoinColumn(name = "personagem_id")
    @JsonIgnore
    private Personagem personagem;

    public ItemMagico(Long id, String nome, Item tipoDoItem, Integer forca, Integer defesa) {
        this.id = id;
        this.nome = nome;
        this.tipoDoItem = tipoDoItem;
        this.Forca = forca;
        this.Defesa = defesa;
    }

    public ItemMagico() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
}
