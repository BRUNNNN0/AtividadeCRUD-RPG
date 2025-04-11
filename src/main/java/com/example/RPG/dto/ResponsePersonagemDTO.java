package com.example.RPG.dto;

import com.example.RPG.model.ClassePerso;

import java.util.List;

public class ResponsePersonagemDTO {

    private Long id;
    private String Nome;
    private String nomeAventureiro;
    private ClassePerso classePerso;
    private Integer level;
    private Integer forca;
    private Integer defesa;
    private List<ResponseITEMDTO> listaItemMagico;

    public List<ResponseITEMDTO> getListaItemMagico() {
        return listaItemMagico;
    }

    public void setListaItemMagico(List<ResponseITEMDTO> listaItemMagico) {
        this.listaItemMagico = listaItemMagico;
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

    public ClassePerso getClassePerso() {
        return classePerso;
    }

    public void setClassePerso(ClassePerso classePerso) {
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
}
