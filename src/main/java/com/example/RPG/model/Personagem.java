package com.example.RPG.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nome;
    private String nomeAventureiro;
    @NotNull(message = "A classe do personagem é obrigatória.")
    private ClassePerso classePerso;
    private Integer level;
    private Integer forca;
    private Integer defesa;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL)
    private List<ItemMagico> listaItemMagico = new ArrayList<>();


    public void adicionarItem(ItemMagico item) {
        item.setPersonagem(this);
        this.listaItemMagico.add(item);
    }

    public void removerItem(ItemMagico item) {
        item.setPersonagem(null);
        this.listaItemMagico.remove(item);
    }

    public Personagem() {
    }

    public Personagem(Long id, String nome, String nomeAventureiro, ClassePerso classePerso, Integer level, Integer forca, Integer defesa) {
        this.id = id;
        Nome = nome;
        this.nomeAventureiro = nomeAventureiro;
        this.classePerso = classePerso;
        this.level = level;
        this.forca = forca;
        this.defesa = defesa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getNomeAventureiro() {
        return nomeAventureiro;
    }

    public void setNomeAventureiro(String nomeAventureiro) {
        this.nomeAventureiro = nomeAventureiro;
    }

    public ClassePerso getClasse() {
        return classePerso;
    }

    public void setClasse(ClassePerso classePerso) {
        this.classePerso = classePerso;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public List<ItemMagico> getListaItemMagico() {
        return listaItemMagico;
    }

    public void setListaItemMagico(List<ItemMagico> listaItemMagico) {
        this.listaItemMagico = listaItemMagico;
    }
}
