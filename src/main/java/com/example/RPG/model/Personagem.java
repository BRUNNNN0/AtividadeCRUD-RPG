package com.example.RPG.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nome;
    private String nomeAventureiro;
    private Classe classe;
    private Integer level;
    private Integer forca;
    private Integer defesa;
    private List<ItemMagico> listaItemMagico = new ArrayList<>();

    public Personagem(Long id, String nome, String nomeAventureiro, Classe classe, Integer level, Integer forca, Integer defesa) {
        this.id = id;
        Nome = nome;
        this.nomeAventureiro = nomeAventureiro;
        this.classe = classe;
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

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
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
