package br.com.cadastroemailsenha.apis.contracts.impl;

import br.com.cadastroemailsenha.adapters.cadastro.CadastroApiAdapter;
import br.com.cadastroemailsenha.adapters.cadastro.CadastroServiceAdapter;
import br.com.cadastroemailsenha.apis.contracts.ApiCadastro;
import br.com.cadastroemailsenha.apis.entities.*;
import br.com.cadastroemailsenha.services.contracts.CadastroService;
import br.com.cadastroemailsenha.services.entities.Cadastro;
import br.com.cadastroemailsenha.services.exceptions.CadastroException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/cadastros")
@CrossOrigin(origins = "http://localhost:8080")
public class ApiCadastroImpl implements ApiCadastro {

    private final CadastroService cadastroService;

   @Autowired
       public ApiCadastroImpl(CadastroService cadastroService) {
       this.cadastroService = cadastroService;
   }

    @PostMapping(value = "/salvarcadastro")
    @Override
    public ResponseEntity<CadastroAPI> salvarCadastro(@RequestBody CadastroAPI cadastroAPI) throws CadastroException {

        try {
            cadastroService.verificaDuplicados(cadastroAPI.getEmail());
            CadastroServiceAdapter adapter = new CadastroServiceAdapter(cadastroAPI);
            cadastroService.salvarCadastro(adapter.getCadastro());
        }catch(CadastroException e){
           return ResponseEntity.status(406).body(CadastroAPI.builder()
                   .erro(e.getMessage())
                   .build());
        }
        return ResponseEntity.ok(cadastroAPI);
    }

    @GetMapping(value = "/login/{email}/{senha}")
    @ResponseBody
    @Override
    public ResponseEntity<CadastroAPI> login(@PathVariable String email, @PathVariable String senha) throws CadastroException {

       Cadastro cadastro;

        try {

            cadastro = cadastroService.login(email, senha);

        }catch(CadastroException e){
           cadastro = Cadastro.builder()
                   .erro("Cadastro Inexistente")
                   .build();
            return ResponseEntity.status(403).body(new CadastroApiAdapter(cadastro).getCadastroAPI());
        }

        return ResponseEntity.ok(new CadastroApiAdapter(cadastro).getCadastroAPI());


    }
}
