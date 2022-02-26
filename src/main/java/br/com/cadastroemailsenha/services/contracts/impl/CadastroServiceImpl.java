package br.com.cadastroemailsenha.services.contracts.impl;

import br.com.cadastroemailsenha.adapters.cadastro.CadastroEntityAdapter;
import br.com.cadastroemailsenha.adapters.cadastro.CadastroServiceAdapter;
import br.com.cadastroemailsenha.db.contracts.RepositorioCadastroEntity;
import br.com.cadastroemailsenha.services.contracts.CadastroService;
import br.com.cadastroemailsenha.services.entities.Cadastro;
import br.com.cadastroemailsenha.services.exceptions.CadastroException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroServiceImpl implements CadastroService {

    private final RepositorioCadastroEntity cadastroRepositorio;

    private static CadastroService instance;

    @Autowired
    public CadastroServiceImpl(RepositorioCadastroEntity cadastroRepositorio){
        this.cadastroRepositorio = cadastroRepositorio;
    }

    public static CadastroService getInstance(RepositorioCadastroEntity cadastroRepositorio){
        if(instance == null){
            instance = new CadastroServiceImpl(cadastroRepositorio);
        }
        return instance;
    }

    @Override
    public Cadastro salvarCadastro(Cadastro cadastro) throws CadastroException {

        cadastroRepositorio.save(new CadastroEntityAdapter(cadastro).getCadastroEntity());
        return new CadastroServiceAdapter(new CadastroEntityAdapter(cadastro).getCadastroEntity()).getCadastro();

    }

    @Override
    public Cadastro login(String email, String senha) throws CadastroException {

        if(cadastroRepositorio.findByEmailESenha(email, senha) == null){
            throw new CadastroException("Cadastro Inexistente");
        }

        return new CadastroServiceAdapter(cadastroRepositorio.findByEmailESenha(email, senha)).getCadastro();
    }

    @Override
    public void verificaDuplicados(String email) throws CadastroException {

        if(cadastroRepositorio.findByDuplicates(email) > 0){
            throw new CadastroException("Cadastro Duplicado");
        }

    }
}
