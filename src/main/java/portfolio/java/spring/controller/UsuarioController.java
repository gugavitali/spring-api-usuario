package portfolio.java.spring.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.java.spring.entity.Usuario;
import portfolio.java.spring.entity.dto.UsuarioDto;
import portfolio.java.spring.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping
    public ResponseEntity<Iterable<Usuario>> buscarTodos(@RequestParam(value = "nome", required = false) String nome) {
        return ResponseEntity.ok(usuarioService.buscarTodos(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarporId(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> inserir(@Valid @RequestBody UsuarioDto usuarioDto) {
        usuarioService.inserir(usuarioDto);
        return ResponseEntity.ok(usuarioDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Integer id,@RequestBody Usuario usuario) {
        usuarioService.atualizar(id, usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deletar(@PathVariable Integer id) {
        usuarioService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
