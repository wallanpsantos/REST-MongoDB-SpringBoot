package com.rest.springboot.mongodb.config;

import com.rest.springboot.mongodb.domain.PostagemDomain;
import com.rest.springboot.mongodb.domain.UsuarioDomain;
import com.rest.springboot.mongodb.repository.PostagemRepository;
import com.rest.springboot.mongodb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 * Carga inicial de banco de dados
 * Normalmente utilizado para realização de testes
 * <p>
 * Nesse caso deleta dados no MongoDB e adiciona os dados
 * para realização de teste antes do start da aplicação em si.
 */
@Configuration
public class InstanciacaoConfig implements CommandLineRunner {

    @Autowired()
    private final UsuarioRepository usuarioRepository;

    @Autowired()
    private final PostagemRepository postagemRepository;

    public InstanciacaoConfig(UsuarioRepository usuarioRepository, PostagemRepository postagemRepository) {
        this.usuarioRepository = usuarioRepository;
        this.postagemRepository = postagemRepository;
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {

        usuarioRepository.deleteAll();
        postagemRepository.deleteAll();

        for (UsuarioDomain usuarioDomain : usuarioIniciais()) {
            usuarioRepository.insert(usuarioDomain);
        }

        for (PostagemDomain postagemDomain : postagensIniciais()) {
            postagemRepository.insert(postagemDomain);
        }
    }

    /**
     * Metodo reposanvel por instanciar alguns usuario na base da dados para fins de testes
     *
     * @return listaUsuarioDomain
     */
    public List<UsuarioDomain> usuarioIniciais() {

        List<UsuarioDomain> listaUsuarioDomain = new ArrayList<>();

        UsuarioDomain usuarioDomain1 = new UsuarioDomain();
        usuarioDomain1.setId(null);
        usuarioDomain1.setNome("Luffy");
        usuarioDomain1.setEmail("luffy@gmail.com");
        listaUsuarioDomain.add(usuarioDomain1);

        UsuarioDomain usuarioDomain2 = new UsuarioDomain();
        usuarioDomain2.setId(null);
        usuarioDomain2.setNome("Nami");
        usuarioDomain2.setEmail("nami@gmail.com");
        listaUsuarioDomain.add(usuarioDomain2);

        UsuarioDomain usuarioDomain3 = new UsuarioDomain();
        usuarioDomain3.setId(null);
        usuarioDomain3.setNome("Zoro");
        usuarioDomain3.setEmail("zoro@gmail.com");
        listaUsuarioDomain.add(usuarioDomain3);

        return listaUsuarioDomain;
    }

    /**
     * Metodo reposnavel por retornar uma lista de postagens
     *
     * @return listaDePostagens
     * @throws ParseException
     */
    public List<PostagemDomain> postagensIniciais() throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("BRT"));

        List<UsuarioDomain> usuarioDomain = usuarioIniciais();

        List<PostagemDomain> listaDePostagens = new ArrayList<>();

        PostagemDomain postagemDomain1 = new PostagemDomain();
        postagemDomain1.setId(null);
        postagemDomain1.setDataPostagem(simpleDateFormat.parse("02/11/2020 17:30"));
        postagemDomain1.setTitulo("Em busca do One Piece");
        postagemDomain1.setConteudo("Me torna os rei dos piratas!!!");
        postagemDomain1.setAutor(usuarioDomain.get(0));
        listaDePostagens.add(postagemDomain1);

        PostagemDomain postagemDomain2 = new PostagemDomain();
        postagemDomain2.setId(null);
        postagemDomain2.setDataPostagem(simpleDateFormat.parse("07/10/2180 11:30"));
        postagemDomain2.setTitulo("Grande sonho");
        postagemDomain2.setConteudo("Se o maior piratas de todos");
        postagemDomain2.setAutor(usuarioDomain.get(1));
        listaDePostagens.add(postagemDomain2);

        PostagemDomain postagemDomain3 = new PostagemDomain();
        postagemDomain3.setId(null);
        postagemDomain3.setDataPostagem(simpleDateFormat.parse("25/11/2750 13:00"));
        postagemDomain3.setTitulo("Mapas");
        postagemDomain3.setConteudo("Quero desenhar o maior mapa do mundo!");
        postagemDomain3.setAutor(usuarioDomain.get(1));
        listaDePostagens.add(postagemDomain3);

        return listaDePostagens;
    }
}
