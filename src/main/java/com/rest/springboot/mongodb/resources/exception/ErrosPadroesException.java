package com.rest.springboot.mongodb.resources.exception;

import lombok.*;

import java.io.Serializable;

/**
 * Classe responsavel por mapear erros padroes na chamada de uma rota
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrosPadroesException implements Serializable {

    private static final Long serialVersionUID = 1L;

    private String timestamp;
    private Integer status;
    private String error;
    private String mensagem;
    private String caminho;
}
