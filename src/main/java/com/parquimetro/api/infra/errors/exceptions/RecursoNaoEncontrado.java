package com.parquimetro.api.infra.errors.exceptions;

public class RecursoNaoEncontrado extends RuntimeException {
    public <T> RecursoNaoEncontrado(Class<T> entidade, String campo, Object valor) {
        super(entidade.getName() + " nao encontardo(a) com esse '" + campo + "': " + valor);
    }

    public RecursoNaoEncontrado(String s) {
        super(s);
    }
}
