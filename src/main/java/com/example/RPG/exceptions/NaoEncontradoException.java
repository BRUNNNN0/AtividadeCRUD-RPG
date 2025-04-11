package com.example.RPG.exceptions;

public class NaoEncontradoException extends RuntimeException {

    public NaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}

