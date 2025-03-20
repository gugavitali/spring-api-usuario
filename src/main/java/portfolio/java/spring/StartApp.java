package portfolio.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import portfolio.java.spring.model.Usuario;
import portfolio.java.spring.repository.UsuarioRepository;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UsuarioRepository repository;
    @Override
    public void run(String... args) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setName("Gustavo");
//        usuario.setUsername("gustavo");
//        usuario.setPassword("guga123");

        repository.save(usuario);

        for (Usuario u: repository.findAll()){
            System.out.println(u);
        }
    }
}
