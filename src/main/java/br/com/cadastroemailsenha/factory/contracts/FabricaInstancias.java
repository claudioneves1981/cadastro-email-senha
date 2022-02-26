package br.com.cadastroemailsenha.factory.contracts;

import br.com.cadastroemailsenha.services.contracts.CadastroService;

public interface FabricaInstancias {

    CadastroService getCadastroServiceImple();

}
