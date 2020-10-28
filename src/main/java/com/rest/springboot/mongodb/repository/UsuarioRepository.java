package com.rest.springboot.mongodb.repository;


import com.rest.springboot.mongodb.domain.UsuarioDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface UsuarioRepository extends MongoRepository<UsuarioDomain, String> {


}
