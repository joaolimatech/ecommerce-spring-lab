package com.joaolima.dscommerce.controllers.handlers;

import com.joaolima.dscommerce.dto.CustomError;
import com.joaolima.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice //Esse anotacao do Spring transforma essa classe em um tratadorGlobal de excecoes.Qualquer classe com anotacao @Controller ou RestController e der excecao, vai cair aqui
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) //Quando, em uma Controller, lançar uma excecao do tipo ResourceNotFoundException, execute este metodo
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) { //metodo que trata nossa excecao da classe resourceNotFound. HttpServletRequest dá acesso aos detlhes da requisicao. Tipo URL
        HttpStatus status = HttpStatus.NOT_FOUND; //Define o status de resposta como not found (404)
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(),  request.getRequestURI());
        return ResponseEntity.status(status).body(err); //Monta e retorna o a respota HTTP final com status 404 e o body comi detalhes do objetoErr
    }
}