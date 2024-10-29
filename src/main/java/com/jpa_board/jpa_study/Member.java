package com.jpa_board.jpa_study;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Member {

    // 자동생ㅇ성
    @Id @GeneratedValue
    private Long id;
    private String username;
}
