package com.rest.springboot.mongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComentariosDTO implements Serializable {

    private static final Long SerialVersionUID = 1L;

    private String texto;
    private Date data;
    private AutorPostagemDTO autorPostagemDTO;


}
