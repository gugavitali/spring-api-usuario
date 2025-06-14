package portfolio.java.spring.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Generated("jsonschema2pojo")
@Entity
@Table(name = "tb_enderecos")
public class Endereco {
    @Id
    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
}