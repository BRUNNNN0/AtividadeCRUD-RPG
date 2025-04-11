package com.example.RPG.dto;

public class AtualizarPesonagemDTO {
    private String nomeAventureiro;


    public AtualizarPesonagemDTO() {
    }

    public AtualizarPesonagemDTO(String nomeAventureiro) {
        this.nomeAventureiro = nomeAventureiro;
    }

    public String getNomeAventureiro() {
        return nomeAventureiro;
    }

    public void setNomeAventureiro(String nomeAventureiro) {
        this.nomeAventureiro = nomeAventureiro;
    }
}
