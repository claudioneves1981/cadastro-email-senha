package br.com.cadastroemailsenha.adapters.cadastro;

import br.com.cadastroemailsenha.apis.entities.CadastroAPI;
import br.com.cadastroemailsenha.db.entities.CadastroEntity;
import br.com.cadastroemailsenha.services.entities.Cadastro;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CadastroServiceAdapter {

    private Cadastro cadastro;
    private List<Cadastro> cadastros;


    public CadastroServiceAdapter(CadastroAPI cadastroAPI) {
        this.cadastro = convertCadastroApiEmCadastro(cadastroAPI);
    }

    public CadastroServiceAdapter(CadastroEntity cadastroEntity) {
        this.cadastro = convertCadastroEntityEmCadastro(cadastroEntity);
    }

    public CadastroServiceAdapter(List<CadastroEntity> cadastroEntities) {
        setCadastros(convertListEntityEmListCadastro(cadastroEntities));
    }

    private List<Cadastro> convertListEntityEmListCadastro(List<CadastroEntity> cadastroEntityList) {
        cadastros = new ArrayList<>();
        for (CadastroEntity cadastroEntity : cadastroEntityList) {
            cadastros.add(convertCadastroEntityEmCadastro(cadastroEntity));
        }
        return cadastros;
    }

    private Cadastro convertCadastroApiEmCadastro(CadastroAPI cadastroAPI) {
        return Cadastro.builder()
                .numeroCadastro(cadastroAPI.getNumeroCadastro())
                .nome(cadastroAPI.getNome())
                .email(cadastroAPI.getEmail())
                .senha(cadastroAPI.getSenha())
                .erro(cadastroAPI.getErro())
                .build();
    }



    private Cadastro convertCadastroEntityEmCadastro(CadastroEntity cadastroEntity) {
        return Cadastro.builder()
                .numeroCadastro(cadastroEntity.getNumeroCadastro())
                .nome(cadastroEntity.getNome())
                .email(cadastroEntity.getEmail())
                .senha(cadastroEntity.getSenha())
                .erro(cadastroEntity.getErro())
                .build();
    }
}