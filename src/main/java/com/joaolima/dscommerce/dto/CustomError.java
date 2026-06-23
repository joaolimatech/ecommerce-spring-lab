package com.joaolima.dscommerce.dto;

import lombok.Getter;

import java.time.Instant;

@Getter
public class CustomError {

    //Esses sao os erros que retornam na response ao chamarmos no POstman
    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

    public CustomError( Instant timestamp, Integer status,String error, String path) {
        this.error = error;
        this.timestamp = timestamp;
        this.status = status;
        this.path = path;
    }

    //Como só temos o get, tirei o Construtor vazio pois estou exigindo que esse cara só seja instanciado pelo Construtor com todos argumentos. Sem sets
}
