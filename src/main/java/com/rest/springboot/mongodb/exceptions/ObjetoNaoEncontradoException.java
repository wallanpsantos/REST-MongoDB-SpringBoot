package com.rest.springboot.mongodb.exceptions;

/**
 * Classe reponsavel por lançar excecao quando objeto não encontrado
 */
public class ObjetoNaoEncontradoException extends RuntimeException {

    private static final Long serialVersionUID = 1L;

    public ObjetoNaoEncontradoException(String message) {
        super(message);
    }
}
