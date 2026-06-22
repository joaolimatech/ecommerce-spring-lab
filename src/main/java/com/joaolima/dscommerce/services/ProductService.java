package com.joaolima.dscommerce.services;

import com.joaolima.dscommerce.dto.ProductDTO;
import com.joaolima.dscommerce.entities.Product;
import com.joaolima.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional (readOnly = true)  //como é operacao somente de leitura, dou um lock de leitura para ficar mais rapido
    public ProductDTO findById(Long id){
        Product productEntidade = productRepository.findById(id).get();   // lembrando q esse metodo sempre recebe um Optional<>, por isso estou ja dando o get() dentro desse optional. Mas, dessa forma, nao estou tratando a excecao
//        ProductDTO dto = new ProductDTO(productEntidade.getId(), productEntidade.getName(), productEntidade.getDescription(), productEntidade.getPrice(), productEntidade.getImgUrl());
        return new ProductDTO(productEntidade);

    }

    @Transactional (readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> resultList = productRepository.findAll(pageable);    //Para retornar todos Dados paginados.
        return  resultList.map(p -> new ProductDTO(p));

    }

    @Transactional
    public ProductDTO insert(ProductDTO dto){

        Product produtoEntity = new Product(dto);

        produtoEntity = productRepository.save(produtoEntity);
        return new ProductDTO(produtoEntity);

    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto){

        Product produtoEntity = productRepository.getReferenceById(dto.getId()); //Essa operação é != do findById pois ele nao vai no banco ainda.
        //Copy to entity (?)
        copyToEntity(dto, produtoEntity);
        produtoEntity = productRepository.save(produtoEntity);
        return new ProductDTO(produtoEntity);

    }

    private void copyToEntity(ProductDTO dto, Product entidade){
        entidade.setDescription(dto.getDescription());
        entidade.setName(dto.getName());
        entidade.setPrice(dto.getPrice());
        entidade.setImgUrl(dto.getImgUrl());
    }

    @Transactional
    public void delete(Long id){
           productRepository.deleteById(id);
        }

}
