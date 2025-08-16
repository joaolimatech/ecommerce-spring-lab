package com.joaolima.dscommerce.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="tb_order_item")
public class OrderItem {

    @EmbeddedId
    private OrderItemPK id= new OrderItemPK(); //APONTA PRA PRODUTO e pro order
    private Integer quantity;
    private Double price;

    public OrderItem(){}

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
       id.setOrder(order);
       id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    //Verificar o pedido por id na table Order
    public Order getOrder(){
        return id.getOrder();
    }

    public Product getProduct(){
        return id.getProduct();
    }
    public void setOrder(Order ord){
        id.setOrder(ord);
    }

    public void setProduct(Product prod){
        id.setProduct(prod);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof OrderItem orderItem)) return false;

        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
