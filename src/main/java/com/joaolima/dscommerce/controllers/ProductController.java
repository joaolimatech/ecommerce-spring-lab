package com.joaolima.dscommerce.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   //anotation que o que eu implementar nessa classe, estara respondendo pela Web
@RequestMapping(value = "/products")   //rota que deve ser respondida
public class ProductController {

    @GetMapping
    public String teste(){
        return "Hello World";
    }
}
