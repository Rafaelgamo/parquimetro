package com.parquimetro.api.infra.errors.exceptions;

public class RecursoJaCadastrado extends RuntimeException {

    public <T> RecursoJaCadastrado(Class<T> entidade, String campo, Object valor) {
        super(entidade.getName() + " ja cadastrado(a) com esse" + campo + "(" + valor + ")");
    }

}
