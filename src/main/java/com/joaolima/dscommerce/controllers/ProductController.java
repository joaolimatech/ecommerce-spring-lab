package com.joaolima.dscommerce.controllers;

import com.joaolima.dscommerce.dto.ProductDTO;
import com.joaolima.dscommerce.entities.Product;
import com.joaolima.dscommerce.repositories.ProductRepository;
import com.joaolima.dscommerce.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
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

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable)
    {
        return productService.findAll(pageable);
    }

    @PostMapping
    public ProductDTO insert(@RequestBody ProductDTO dto)//RequestBody configura q isso será o corpo da requiscao e instancia o dto
    {
        dto = productService.insert(dto);
        log.info("Adicionado o produto {} / {}", dto.getId(), dto.getName());
        return dto;
    }

}
