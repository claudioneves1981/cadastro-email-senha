package br.com.cadastroemailsenha.adapters.cadastro;

import br.com.cadastroemailsenha.apis.entities.CadastroAPI;
import br.com.cadastroemailsenha.services.entities.Cadastro;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CadastroApiAdapter {

    private CadastroAPI cadastroAPI;
    private List<CadastroAPI> cadastrosAPI;

    public CadastroApiAdapter(Cadastro cadastro) {
        cadastroAPI = convertCadastroParaCadastroAPI(cadastro);
    }

    public CadastroApiAdapter(List<Cadastro> cadastro) {
        cadastrosAPI = convertListCadastroParaListCadastroAPI(cadastro);
    }

    private List<CadastroAPI> convertListCadastroParaListCadastroAPI(List<Cadastro> cadastros) {
        List<CadastroAPI> cadastrosAPI = new ArrayList<>();
        for (Cadastro cadastro : cadastros) {
            cadastrosAPI.add(convertCadastroParaCadastroAPI(cadastro));
        }
        return cadastrosAPI;
    }

    private CadastroAPI convertCadastroParaCadastroAPI(Cadastro cadastro) {
        return CadastroAPI.builder()
                .numeroCadastro(cadastro.getNumeroCadastro())
                .nome(cadastro.getNome())
                .email(cadastro.getEmail())
                .senha(cadastro.getSenha())
                .erro(cadastro.getErro())
                .build();
    }
}