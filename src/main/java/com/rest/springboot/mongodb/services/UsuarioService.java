package com.rest.springboot.mongodb.services;

import com.rest.springboot.mongodb.domain.UsuarioDomain;
import com.rest.springboot.mongodb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDomain> buscarTodosUsuarios() {

        return usuarioRepository.findAll();
    }
}
