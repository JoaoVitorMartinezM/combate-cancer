package br.com.tivit.mvpsaude.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class PersonalException extends RuntimeException {

    protected final LocalDateTime momento;

    protected PersonalException(String mensagem) {
        super(mensagem);
        momento = LocalDateTime.now();
    }

}
