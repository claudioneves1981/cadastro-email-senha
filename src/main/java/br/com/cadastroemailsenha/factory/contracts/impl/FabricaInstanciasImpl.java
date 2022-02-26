package br.com.cadastroemailsenha.factory.contracts.impl;

import br.com.cadastroemailsenha.db.contracts.RepositorioCadastroEntity;
import br.com.cadastroemailsenha.factory.contracts.FabricaInstancias;
import br.com.cadastroemailsenha.services.contracts.CadastroService;
import br.com.cadastroemailsenha.services.contracts.impl.CadastroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FabricaInstanciasImpl implements FabricaInstancias {

    private final RepositorioCadastroEntity repositorioCadastroEntity;
 

    @Autowired
    private FabricaInstanciasImpl(RepositorioCadastroEntity repositorioCadastroEntity){
        this.repositorioCadastroEntity = repositorioCadastroEntity;
    }


    @Override
    public CadastroService getCadastroServiceImple() {
        return CadastroServiceImpl.getInstance(this.repositorioCadastroEntity);
    }

}
