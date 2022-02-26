package br.com.cadastroemailsenha.adapters.cadastro;

import br.com.cadastroemailsenha.db.entities.CadastroEntity;
import br.com.cadastroemailsenha.services.entities.Cadastro;
import lombok.Data;

@Data
public class CadastroEntityAdapter {

    private CadastroEntity cadastroEntity;

    public CadastroEntityAdapter(Cadastro cadastro) {
       this.cadastroEntity = converteCadastroEmCadastroEntity(cadastro);
    }

    private CadastroEntity converteCadastroEmCadastroEntity(Cadastro cadastro) {
        return   CadastroEntity.builder()
                .numeroCadastro(cadastro.getNumeroCadastro())
                .nome(cadastro.getNome())
                .email(cadastro.getEmail())
                .senha(cadastro.getSenha())
                .erro(cadastro.getErro())
                .build();

    }
}
