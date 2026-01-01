package com.joaolima.dscommerce.controllers;

import com.joaolima.dscommerce.dto.ProductDTO;
import com.joaolima.dscommerce.entities.Product;
import com.joaolima.dscommerce.repositories.ProductRepository;
import com.joaolima.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController   //anotation que o que eu implementar nessa classe, estara respondendo pela Web
@RequestMapping(value = "/products")   //rota que deve ser respondida
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping (value = "/{id}")
    public ProductDTO findById(@PathVariable Long id) //configurando parametro para casar com o parametro que receberei no endpoint
    {
       return productService.findById(id);
    }
}
