package br.com.cadastroemailsenha.apis.contracts;

import br.com.cadastroemailsenha.apis.entities.CadastroAPI;
import br.com.cadastroemailsenha.services.exceptions.CadastroException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface ApiCadastro {

    @ApiOperation(value = "Salva um usuario com nome,  email e senha")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma mensagem se salvou o valor"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 406, message = "Quando uma regra for quebrada"),
            @ApiResponse(code = 500, message = "Retornará uma mensagem amigável para o usuário"),
    })
    ResponseEntity<CadastroAPI> salvarCadastro(CadastroAPI novoCadastro) throws CadastroException;

    @ApiOperation(value = "Faz o login do cliente usando email e senha")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Logado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar esta conta"),
            @ApiResponse(code = 500, message = "Retornará uma mensagem amigável para o usuário"),
    })
    ResponseEntity<CadastroAPI> login(String email, String senha) throws CadastroException;
}
