package portfolio.java.spring.entity.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    @NotEmpty(message = "Preencha o campo corretamente.")
    @Size(min = 3, max = 50, message = "'{%validateValue}' é precisa estar entre {min} e {max} caracteres.")
    private String nome;

    @NotEmpty(message = "Preencha o campo corretamente.")
    @CPF(message = "'${validatedValue}' já está cadastrado ou é inválido!.")
    private String cpf;

    @NotNull(message = "O campo CEP é obrigatório.")
    @Pattern(regexp = "\\d{8}", message = "O CEP deve conter exatamente 8 dígitos numéricos.") // se quiser apenas números
    private String cep;

}