package br.com.cadastroemailsenha.apis.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CadastroAPI {

    private Long numeroCadastro;
    private String nome;
    private String email;
    private String senha;
    private String erro;

}
