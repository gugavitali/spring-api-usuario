package portfolio.java.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import portfolio.java.spring.model.Endereco;
import portfolio.java.spring.model.Usuario;
import portfolio.java.spring.repository.EnderecoRepository;
import portfolio.java.spring.repository.UsuarioRepository;
import portfolio.java.spring.service.UsuarioService;
import portfolio.java.spring.service.ViaCepService;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.get();
    }

    @Override
    public void inserir(Usuario usuario) {
        salvarUsuarioComCep(usuario);
    }

    @Override
    public void atualizar(Integer id, Usuario usuario) {
        Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
        if (usuarioBd.isPresent()){
            salvarUsuarioComCep(usuario);
        }
    }

    private void salvarUsuarioComCep(Usuario usuario) {
        String cep = usuario.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(Integer.valueOf(cep)).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        usuario.setEndereco(endereco);
        usuarioRepository.save(usuario);
    }

    @Override
    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
