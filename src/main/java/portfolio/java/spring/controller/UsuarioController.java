//package portfolio.java.spring.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import portfolio.java.spring.model.Usuario;
//import portfolio.java.spring.service.UsuarioService;
//
//@RestController
//@RequestMapping("usuarios")
//public class UsuarioController {
//    @Autowired
//    private UsuarioService usuarioService;
//
//    @GetMapping
//    public ResponseEntity<Iterable<Usuario>> buscarTodos() {
//        return ResponseEntity.ok(usuarioService.buscarTodos());
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Usuario> buscarporId(@PathVariable Integer id) {
//        return ResponseEntity.ok(usuarioService.buscarPorId(id));
//    }
//    @PostMapping
//    public ResponseEntity<Usuario> inserir(@RequestBody Usuario usuario) {
//        usuarioService.inserir(usuario);
//        return ResponseEntity.ok(usuario);
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Usuario> atualizar(@PathVariable Integer id,@RequestBody Usuario usuario) {
//        usuarioService.atualizar(id, usuario);
//        return ResponseEntity.ok(usuario);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Usuario> deletar(@PathVariable Integer id) {
//        usuarioService.deletar(id);
//        return ResponseEntity.ok().build();
//    }
//}
