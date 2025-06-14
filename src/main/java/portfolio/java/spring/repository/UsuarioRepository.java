package portfolio.java.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import portfolio.java.spring.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Iterable<Usuario> findByNomeContainingIgnoreCase(String nome);

//    @Query("SELECT u FROM Usuario u WHERE u.nome LIKE CONCAT('%', :nome, '%')")
//    Iterable<Usuario> findByName(@Param("nome") String nome);

//    public Iterable<Usuario> findByNome(String nome);

}
