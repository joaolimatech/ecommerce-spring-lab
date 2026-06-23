package com.joaolima.dscommerce.services.exceptions;

public class ResourceNotFoundException extends RuntimeException //RuntimeException Nao exige tryCatch
{

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
