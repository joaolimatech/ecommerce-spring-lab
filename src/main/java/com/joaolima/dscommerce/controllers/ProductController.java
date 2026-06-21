package com.joaolima.dscommerce.controllers;

import com.joaolima.dscommerce.dto.ProductDTO;
import com.joaolima.dscommerce.entities.Product;
import com.joaolima.dscommerce.repositories.ProductRepository;
import com.joaolima.dscommerce.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController   //anotation que o que eu implementar nessa classe, estara respondendo pela Web
@RequestMapping(value = "/products")   //rota que deve ser respondida URI
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping (value = "/{id}") //Isso é uma URI -> /products/{id}
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) //configurando parametro para casar com o parametro que receberei no endpoint
    {
        ProductDTO p = productService.findById(id);
       return ResponseEntity.ok(p); //Resposta 200
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable)
    {
        Page<ProductDTO> p = productService.findAll(pageable);
        return ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto)//RequestBody configura q isso será o corpo da requiscao e instancia o dto
    {
        dto = productService.insert(dto);
        log.info("Adicionado o produto {} / {}", dto.getId(), dto.getName());
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()                    // Pega a URL atual da requisição (ex: /products)
                .path("/{id}")                           // Adiciona / {id} no final
                .buildAndExpand(dto.getId())             // Substitui {id} pelo ID real do produto
                .toUri();                                // Converte para objeto URI
        return ResponseEntity.status(HttpStatus.CREATED).location(uri).body(dto);
    }

}
