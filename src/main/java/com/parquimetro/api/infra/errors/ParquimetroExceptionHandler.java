package com.parquimetro.api.infra.errors;

import com.parquimetro.api.infra.errors.exceptions.ErroDeValidacao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@RestControllerAdvice
public class ParquimetroExceptionHandler {

    @ExceptionHandler(EnumConstantNotPresentException.class)
    public ResponseEntity<Object> tratarError404() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Erro("Recurso não encontrado"));
    }

    @ExceptionHandler(ErroDeValidacao.class)
    public ResponseEntity<Object> tratarErroDeValidacao(ErroDeValidacao ex) {
        return ResponseEntity.badRequest().body(new Erro(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> tratarErro400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao :: new).toList());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleBadRequest2(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(new Erro(ex.getMessage()));
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<Object> handleBadRequest3(HandlerMethodValidationException ex) {
        return ResponseEntity.badRequest().body(new Erro("Bad Request: Verificar formatações do corpo da requisição"));
    }

    private record DadosErroValidacao(String campo, String mensagem){
        public DadosErroValidacao(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }

    private record Erro(String erro) {}
}
