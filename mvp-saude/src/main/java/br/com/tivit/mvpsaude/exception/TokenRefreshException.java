package br.com.tivit.mvpsaude.exception;

public class TokenRefreshException extends PersonalException {

    public TokenRefreshException(String message) {
        super(String.format("Falha de autenticação: %s", message));
    }
}