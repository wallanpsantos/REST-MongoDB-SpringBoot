package com.rest.springboot.mongodb.repository;

import com.rest.springboot.mongodb.domain.PostagemDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Um Repository (Repositório) é um objeto que isola os objetos ou
 * entidades do domínio do código que acessa o banco de dados.
 * <p>
 * Um repositório não deve incluir as regras de negócio no sentido de tomar decisões,
 * aplicar algoritmos de transformação dos dados ou prover serviços diretamente a outras camadas ou
 * módulos da aplicação. Mapear entidades de domínio e
 * prover as funcionalidades da aplicação são responsabilidades distintas.
 *
 * @Author encurtador.com.br/behzM
 */
@Repository
public interface PostagemRepository extends MongoRepository<PostagemDomain, String> {
}