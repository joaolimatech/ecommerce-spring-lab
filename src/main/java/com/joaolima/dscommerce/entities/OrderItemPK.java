package com.joaolima.dscommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//Criamos essa classe pq esse objeto será uma Chave Primaria composta, recebendo Pk de Order e de Product
@Embeddable  //Fala q será uma entidade nao a virar uma tabela, mas sim para ser adc em uma talvez
public class OrderItemPK {

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    public OrderItemPK(){}

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
