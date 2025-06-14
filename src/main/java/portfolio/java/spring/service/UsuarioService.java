package portfolio.java.spring.service;

import org.springframework.data.repository.query.Param;
import portfolio.java.spring.entity.Usuario;
import portfolio.java.spring.entity.dto.UsuarioDto;

public interface UsuarioService {
    Iterable<Usuario> buscarTodos(String nome);

    Usuario buscarPorId(Integer id);

    void inserir(UsuarioDto usuarioDto);

    void atualizar(Integer id, Usuario usuario);

    void deletar(Integer id);
}
