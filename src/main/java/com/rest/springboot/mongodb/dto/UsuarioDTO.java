package com.rest.springboot.mongodb.dto;

import com.rest.springboot.mongodb.domain.UsuarioDomain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class UsuarioDTO implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    private String id;

    private String nome;
    private String email;

    public UsuarioDTO(UsuarioDomain usuarioDomain) {
        this.id = usuarioDomain.getId();
        this.nome = usuarioDomain.getNome();
        this.email = usuarioDomain.getEmail();
    }

    /**
     * Metodo responsavel por realizar a instancia de um usuario
     * utilizado para inserção de novos usuarios
     *
     * @param usuarioDTO
     * @return new UsuarioDomain()
     */
    public UsuarioDomain UsarioInstanciaDTO(UsuarioDTO usuarioDTO) {

        UsuarioDomain usuarioDomain = new UsuarioDomain();

        usuarioDomain.setId(usuarioDTO.getId());
        usuarioDomain.setNome(usuarioDTO.getNome());
        usuarioDomain.setEmail(usuarioDTO.getEmail());

        return usuarioDomain;
    }
}
