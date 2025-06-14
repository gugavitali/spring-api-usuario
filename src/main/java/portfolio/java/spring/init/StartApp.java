//package portfolio.java.spring.init;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//import portfolio.java.spring.model.Usuario;
//import portfolio.java.spring.repository.UsuarioRepository;
//
//@Component
//public class StartApp implements CommandLineRunner {
//    @Autowired
//    private UsuarioRepository repository;
//    @Override
//    public void run(String... args) throws Exception {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        Usuario user = repository.findByUsername("admin");
//        if(user==null){
//            user = new Usuario();
//            user.setName("ADMIN");
//            user.setUsername("admin");
//            user.setPassword(passwordEncoder.encode("master123"));
//            user.getRoles().add("USERS");
//            user.getRoles().add("MANAGERS");
//            repository.save(user);
//        }
//        user = repository.findByUsername("user");
//        if(user ==null) {
//            user = new Usuario();
//            user.setName("USER");
//            user.setUsername("user");
//            user.setPassword(passwordEncoder.encode("user123"));
//            user.getRoles().add("USERS");
//            repository.save(user);
//        }
//    }
//}