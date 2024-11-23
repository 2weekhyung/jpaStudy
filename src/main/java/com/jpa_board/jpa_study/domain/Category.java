package com.jpa_board.jpa_study.domain;

import com.jpa_board.jpa_study.domain.item.Item;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Category {

    @Id  @GeneratedValue
    @Column(name="cateory_id")
    private Long id;

    @ManyToMany
    @JoinTable(name="category_item", joinColumns = @JoinColumn(name="category_id"), inverseJoinColumns = @JoinColumn(name="item_id"))
    private List<Item> items = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
}
