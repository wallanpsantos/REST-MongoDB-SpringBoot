package com.rest.springboot.mongodb.services;

import com.rest.springboot.mongodb.domain.PostagemDomain;
import com.rest.springboot.mongodb.exceptions.ObjetoNaoEncontradoException;
import com.rest.springboot.mongodb.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    /**
     * Metodo Responsavel por realizar a busca de um usuario passando o Id como parametro
     *
     * @param id
     * @return usuarioDomain;
     */
    public Optional<PostagemDomain> procuraPostagem(String id) {
        Optional<PostagemDomain> postagemDomain = postagemRepository.findById(id);

        if (!postagemDomain.isPresent()) {
            throw new ObjetoNaoEncontradoException("Postagem com identificação: " + id + " não encontrado!");
        }
        return postagemDomain;
    }

    /**
     * Metodo responsavel por retornar uma lista de postagem por titulo
     *
     * @param titulo
     * @return postagemRepository
     */
    public List<PostagemDomain> procuraPorTitulo(String titulo) {
        return postagemRepository.findByTituloContainingIgnoreCase(titulo);
    }

    /**
     * Metodo responsavel por procurar titulo de postagem utilizando Regex
     * do https://docs.mongodb.com/manual/reference/operator/query/regex/
     *
     * @param titulo
     * @return postagemRepository
     */
    public List<PostagemDomain> regexProcuraPorTitulo(String titulo) {
        return postagemRepository.searchTitulo(titulo);
    }

    /**
     * Metodo responsal por procurar com muito criterios de aceite
     * por titulo ou corpo da postagem e diferença de data
     *
     * @param titulo
     * @param dataMinima
     * @param dataMaxima
     * @return postagemRepository
     */
    public List<PostagemDomain> fullSearch(String titulo, Date dataMinima, Date dataMaxima) {
        dataMaxima = new Date(dataMaxima.getTime() + (24 * 60 * 60 * 1000));

        return postagemRepository.fullSearch(titulo, dataMinima, dataMaxima);
    }
}
