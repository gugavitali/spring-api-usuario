package portfolio.java.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio.java.spring.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
