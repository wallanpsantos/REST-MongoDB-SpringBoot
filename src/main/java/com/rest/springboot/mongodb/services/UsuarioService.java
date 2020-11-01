package com.rest.springboot.mongodb.services;

import com.rest.springboot.mongodb.domain.UsuarioDomain;
import com.rest.springboot.mongodb.exceptions.ObjetoNaoEncontradoException;
import com.rest.springboot.mongodb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Metodo responsavel por realizar a busca de toso os usuarios no servidor MongoDB
     *
     * @return usuarioRepository.findAll()
     */
    public List<UsuarioDomain> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    /**
     * Metodo Responsavel por realizar a busca de um usuario passando o Id como parametro
     *
     * @param id
     * @return usuarioDomain;
     */
    public Optional<UsuarioDomain> procuraUsuario(String id) {
        Optional<UsuarioDomain> usuarioDomain = usuarioRepository.findById(id);

        if (!usuarioDomain.isPresent()) {
            throw new ObjetoNaoEncontradoException("Usuario com identificação: " + id + " não encontrado!");
        }
        return usuarioDomain;
    }

    /**
     * Metodo resposanvel por adicionar um novo usuario ao banco de dados MongoDB
     *
     * @param usuarioDomain
     * @return usuarioRepository.insert(usuarioDomain)
     */
    public UsuarioDomain adicionaNovoUsuario(UsuarioDomain usuarioDomain) {

        return usuarioRepository.insert(usuarioDomain);
    }
}
