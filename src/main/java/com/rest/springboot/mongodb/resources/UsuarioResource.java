package com.rest.springboot.mongodb.resources;

import com.rest.springboot.mongodb.domain.UsuarioDomain;
import com.rest.springboot.mongodb.dto.UsuarioDTO;
import com.rest.springboot.mongodb.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<UsuarioDTO>> procuraTodosUsuarios() {
        List<UsuarioDomain> listaUsuarios = usuarioService.buscarTodosUsuarios();
        List<UsuarioDTO> listaUsuarioDTO = listaUsuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaUsuarioDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> procuraUsuario(@PathVariable String id) {
        Optional<UsuarioDomain> usuarioDomain = usuarioService.procuraUsuario(id);

        return ResponseEntity.ok().body(new UsuarioDTO(usuarioDomain.get()));
    }

}
