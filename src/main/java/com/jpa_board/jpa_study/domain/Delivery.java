package com.jpa_board.jpa_study.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Delivery {

    @Id @GeneratedValue
    @Column(name="delivery_id")
    private Long id;

    @OneToMany
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
