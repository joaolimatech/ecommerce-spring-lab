package com.joaolima.dscommerce.dto;

import com.joaolima.dscommerce.entities.Product;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    public ProductDTO(Long id, String name, String description,Double price, String imgUrl) {
        this.price = price;
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product entidade) {
        this.price = entidade.getPrice();
        this.id = entidade.getId();
        this.name = entidade.getName();
        this.description = entidade.getDescription();
        this.imgUrl = entidade.getImgUrl();
    }

    public ProductDTO( ) {
    }

    public String getName() {
        return name;
    }



    public Long getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }



    public Double getPrice() {
        return price;
    }



    public String getImgUrl() {
        return imgUrl;
    }


}
