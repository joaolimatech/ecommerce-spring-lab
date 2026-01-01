package com.joaolima.dscommerce.services;

import com.joaolima.dscommerce.dto.ProductDTO;
import com.joaolima.dscommerce.entities.Product;
import com.joaolima.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional (readOnly = true)  //como é operacao somente de leitura, dou um lock de leitura para ficar mais rapido
    public ProductDTO findById(Long id){
        Product productEntidade = productRepository.findById(id).get();   // lembrando q esse metodo sempre recebe um Optional<>, por isso estou ja dando o get() dentro desse optional. Mas, dessa forma, nao estou tratando a excecao
//        ProductDTO dto = new ProductDTO(productEntidade.getId(), productEntidade.getName(), productEntidade.getDescription(), productEntidade.getPrice(), productEntidade.getImgUrl());
        ProductDTO dto = new ProductDTO(productEntidade);
        return  dto;

    }

}
