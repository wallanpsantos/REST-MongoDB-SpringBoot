package com.rest.springboot.mongodb.resources;

import com.rest.springboot.mongodb.domain.PostagemDomain;
import com.rest.springboot.mongodb.resources.utils.UrlResourceUtils;
import com.rest.springboot.mongodb.services.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
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

    @GetMapping(value = "/tituloPostagem")
    public ResponseEntity<List<PostagemDomain>> procuraTituloPostagem(@RequestParam(value = "titulo") String titulo) {
//        titulo = UrlResourceUtils.encodificarParametro(titulo);
        titulo = UrlResourceUtils.decondificarParametro(titulo);

//        List<PostagemDomain> postagens = postagemService.regexProcuraPorTitulo(titulo);
        List<PostagemDomain> postagens = postagemService.procuraPorTitulo(titulo);

        return ResponseEntity.ok().body(postagens);
    }

    @GetMapping(value = "/pesquisaFiltrada")
    public ResponseEntity<List<PostagemDomain>> pesquisaFiltrada(
            @RequestParam(value = "texto", defaultValue = "") String texto,
            @RequestParam(value = "dataMinima", defaultValue = "") String dataMinima,
            @RequestParam(value = "dataMaxima", defaultValue = "") String dataMaxima) {

        texto = UrlResourceUtils.decondificarParametro(texto);
        Date minDate = UrlResourceUtils.converteData(dataMinima, new Date(0L));
        Date maxDate = UrlResourceUtils.converteData(dataMaxima, new Date());

        List<PostagemDomain> postagens = postagemService.fullSearch(texto, minDate, maxDate);

        return ResponseEntity.ok().body(postagens);
    }
}
