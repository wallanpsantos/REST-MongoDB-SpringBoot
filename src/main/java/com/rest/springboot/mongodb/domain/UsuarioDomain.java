package com.rest.springboot.mongodb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usuario")
public class UsuarioDomain implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    private String id;
    private String nome;
    private String email;

    /**
     * @DBRef(lazy = true) -> faz com que as postagens carreguem quando são acessadas,
     * cas  o queria carregar tudo de uma unica quando o usuario é acessado deixe false
     */
    @DBRef(lazy = true)
    private List<PostagemDomain> postagens = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioDomain)) return false;
        UsuarioDomain that = (UsuarioDomain) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
