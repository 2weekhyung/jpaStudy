package com.jpa_board.jpa_study.domain.item;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
@Data
public abstract class Item {
    @Id @GeneratedValue
    @Column(name="item_id")
    private  Long id;

    private String name;
    private int price;
    private int stockQuantity;

}
