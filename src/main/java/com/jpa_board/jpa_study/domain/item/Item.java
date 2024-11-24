package com.jpa_board.jpa_study.domain.item;

import com.jpa_board.jpa_study.domain.Category;
import com.jpa_board.jpa_study.exception.NotEnoughStockException;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    // 비즈니스 로직

    /**
     * 증가
     * @param qunantity
     */
    public void addStock(int qunantity){
        this.stockQuantity += qunantity;
    }

    /**
     * 감소
     * @param quantity
     */
    public void removeStock(int quantity){
        int resTStock = this.stockQuantity-quantity;
        if(resTStock<0){
            throw  new NotEnoughStockException("need more stock");
        }
        this.stockQuantity=resTStock;
    }
}
