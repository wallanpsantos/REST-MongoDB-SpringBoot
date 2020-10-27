package com.rest.springboot.mongodb.resources;

import com.rest.springboot.mongodb.domain.UsuarioDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioResource {

    /**
     * ResponseEntity<T> Esse objeto encapsula toda a estrutura necessaria
     * para retorna respostas HTTP com possiveis cabeçalhos e erros.
     */
    @GetMapping
    public ResponseEntity<List<UsuarioDomain>> procuraTodosUsuarios() {
        List<UsuarioDomain> listaUsuarios = new ArrayList<>();

        UsuarioDomain primeiroUsuario = new UsuarioDomain(1, "Luffy", "luffy@gmail.com");
        UsuarioDomain segundoUsuario = new UsuarioDomain(2, "Nami", "nami@gmail.com");

        listaUsuarios.addAll(Arrays.asList(primeiroUsuario, segundoUsuario));

        return ResponseEntity.ok().body(listaUsuarios);
    }
}
