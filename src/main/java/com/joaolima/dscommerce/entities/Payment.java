package com.joaolima.dscommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name= "tb_payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;

    @OneToOne
    @MapsId  //Mapeando as chaves primarias. A chave primaria do Pagamento, será tbm uma chave estrangeira com o msm id de Order
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOrder() {
        return order;
    }

    public Payment(){}
}
