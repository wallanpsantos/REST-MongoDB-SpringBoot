package com.rest.springboot.mongodb.dto;

import com.rest.springboot.mongodb.domain.UsuarioDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutorPostagemDTO implements Serializable {

    private static final Long SerialVersionUID = 1L;

    private String id;
    private String nome;

    public AutorPostagemDTO(UsuarioDomain usuarioDomain) {
        this.id = usuarioDomain.getId();
        this.nome = usuarioDomain.getNome();
    }

}
