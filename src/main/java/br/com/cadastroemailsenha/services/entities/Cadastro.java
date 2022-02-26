package br.com.cadastroemailsenha.services.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cadastro {

    private Long numeroCadastro;
    private String nome;
    private String email;
    private String senha;
    private String erro;
}
