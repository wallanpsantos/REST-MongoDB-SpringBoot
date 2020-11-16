package com.rest.springboot.mongodb.domain;

import com.rest.springboot.mongodb.dto.AutorPostagemDTO;
import com.rest.springboot.mongodb.dto.ComentariosDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe resposanvel por mapear uma postagem de usuario
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class PostagemDomain implements Serializable {

    private static final Long SerialVersionUID = 1L;

    @Id
    private String id;
    private Date dataPostagem;
    private String titulo;
    private String conteudo;
    private AutorPostagemDTO autorPostagemDTO;

    private List<ComentariosDTO> comentariosDTOS = new ArrayList<>();
}
