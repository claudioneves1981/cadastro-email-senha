package br.com.cadastroemailsenha.services.exceptions;

public class CadastroException extends Exception {
    private String msg;

    public CadastroException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
