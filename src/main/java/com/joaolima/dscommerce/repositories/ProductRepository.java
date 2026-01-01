package com.joaolima.dscommerce.repositories;

import com.joaolima.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {     //extendo a JPARepository pasando parametro do tipo do dado (Product) e o tipo do ID do dado
}
