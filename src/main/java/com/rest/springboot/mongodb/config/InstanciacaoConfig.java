package com.rest.springboot.mongodb.config;

import com.rest.springboot.mongodb.domain.UsuarioDomain;
import com.rest.springboot.mongodb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

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

    public InstanciacaoConfig(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
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

        for (UsuarioDomain usuarioDomain : listaUsuarioDomain) {
            usuarioRepository.insert(usuarioDomain);
        }
    }
}
