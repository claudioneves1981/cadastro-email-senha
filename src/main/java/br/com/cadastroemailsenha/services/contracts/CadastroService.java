package br.com.cadastroemailsenha.services.contracts;

import br.com.cadastroemailsenha.services.entities.Cadastro;
import br.com.cadastroemailsenha.services.exceptions.CadastroException;

public interface CadastroService {

    Cadastro salvarCadastro(Cadastro cadastro) throws CadastroException;

    void verificaDuplicados(String email) throws CadastroException;

    Cadastro login(String email, String senha) throws CadastroException;
}