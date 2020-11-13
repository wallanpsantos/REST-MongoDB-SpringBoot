package com.rest.springboot.mongodb.resources;

import com.rest.springboot.mongodb.domain.PostagemDomain;
import com.rest.springboot.mongodb.services.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/postagem")
public class PostagemResource {

    @Autowired
    private PostagemService postagemService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostagemDomain> procuraUsuario(@PathVariable String id) {
        Optional<PostagemDomain> postagemDomain = postagemService.procuraPostagem(id);

        return postagemDomain.map(postagemDomain1 -> ResponseEntity.ok().body(postagemDomain1)).orElse(null);
    }
}
