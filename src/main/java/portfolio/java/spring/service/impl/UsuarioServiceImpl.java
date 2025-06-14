package portfolio.java.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import portfolio.java.spring.entity.Endereco;
import portfolio.java.spring.entity.Usuario;
import portfolio.java.spring.entity.dto.UsuarioDto;
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
    public Iterable<Usuario> buscarTodos(String nome) {
        if (nome == null){
            return usuarioRepository.findAll();
        } else {
            return usuarioRepository.findByNomeContainingIgnoreCase(nome);
        }
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.get();
    }

    @Override
    public void inserir(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDto.getNome());
        usuario.setCpf(usuarioDto.getCpf());

        Endereco endereco = new Endereco();
        endereco.setCep(usuarioDto.getCep());
        usuario.setEndereco(endereco);

        salvarUsuarioComCep(usuario);
    }

    @Override
    public void atualizar(Integer id, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
        if (usuarioBd.isPresent()) {
            salvarUsuarioComCep(usuario);
        }
    }

    private void salvarUsuarioComCep(Usuario usuario) {
        String cep = usuario.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            return enderecoRepository.save(novoEndereco);
        });
        usuario.setEndereco(endereco);
        usuarioRepository.save(usuario);
    }

    @Override
    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
