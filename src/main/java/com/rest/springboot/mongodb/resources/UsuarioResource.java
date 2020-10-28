package com.rest.springboot.mongodb.resources;

import com.rest.springboot.mongodb.domain.UsuarioDomain;
import com.rest.springboot.mongodb.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * ResponseEntity<T> Esse objeto encapsula toda a estrutura necessaria
     * para retorna respostas HTTP com possiveis cabeçalhos e erros.
     */
    @GetMapping
    public ResponseEntity<List<UsuarioDomain>> procuraTodosUsuarios() {
        List<UsuarioDomain> listaUsuarios = usuarioService.buscarTodosUsuarios();

        return ResponseEntity.ok().body(listaUsuarios);
    }

}
