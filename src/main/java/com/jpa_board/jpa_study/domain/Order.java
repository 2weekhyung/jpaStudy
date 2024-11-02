package com.jpa_board.jpa_study.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="orders")
@Data
public class Order {

    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    private Delivery delivery;

    private LocalDateTime orderDate;
    // 주문시간
    @Enumerated(EnumType.STRING)
    private OrderStatus status;         // 주문 상태
}
