package com.parquimetro.api.infra.errors.exceptions;

public class EntidadeJaExiste extends RuntimeException {
    public <T> EntidadeJaExiste(Class<T> entidade, String campo, Object valor) {
        super(entidade.getName() + " ja cadastrado(a) com esse" + campo + "(" + valor + ")");
    }
}
