package com.rest.springboot.mongodb.resources.exception;


import com.rest.springboot.mongodb.exceptions.ObjetoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * O bean @ControllerAdvice faz com que a classe seja
 * responsavel por tratar possiveis erros nas requisições
 */
@ControllerAdvice
public class ResourceExceptionHandler {

    private static final String MENSAGEM_NOT_FOUND = "Objeto não encontrado";

    /**
     * Metodo responsavel por retorna uma mensagem personalizada para status code 404 quando o objeto não for encontrado
     *
     * @param objetoNaoEncontradoException
     * @param httpServletRequest
     * @return ResponseEntity.ok().body(errosPadroesException)
     */
    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    private ResponseEntity<ErrosPadroesException> objetoNaoEncontrado(ObjetoNaoEncontradoException objetoNaoEncontradoException, HttpServletRequest httpServletRequest) {

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        ErrosPadroesException errosPadroesException = new ErrosPadroesException();
        errosPadroesException.setTimestamp(getDataHoraAtual());
        errosPadroesException.setStatus(httpStatus.value());
        errosPadroesException.setError(MENSAGEM_NOT_FOUND);
        errosPadroesException.setMensagem(objetoNaoEncontradoException.getMessage());
        errosPadroesException.setCaminho(httpServletRequest.getRequestURI());

        return ResponseEntity.status(httpStatus).body(errosPadroesException);
    }

    /**
     * Metodo reponsavel por fazer a conversão da data atual para modelo do Brasil
     *
     * @return String.valueOf(simpleDateFormat)
     */
    private String getDataHoraAtual() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", new Locale("pt", "BR"));
        Date date = new Date(System.currentTimeMillis());

        return String.valueOf(simpleDateFormat.format(date));
    }
}
