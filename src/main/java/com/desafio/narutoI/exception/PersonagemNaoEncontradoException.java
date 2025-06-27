package com.desafio.narutoI.exception;

public class PersonagemNaoEncontradoException extends RuntimeException{

    public PersonagemNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
