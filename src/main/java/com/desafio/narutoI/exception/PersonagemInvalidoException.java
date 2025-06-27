package com.desafio.narutoI.exception;

public class PersonagemInvalidoException extends RuntimeException {
    public PersonagemInvalidoException(String mensagem) {
        super(mensagem);
    }
}