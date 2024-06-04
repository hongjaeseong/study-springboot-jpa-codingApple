package com.apple.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK & Auto Increment 설정
    @Column // @Column() 으로 컬럼에 제약설정 가능
    private Long id; // title, price 가 동일 시 id 로(PK) 구분

    @Column(nullable = false, length = 1000) //  not null
    private String title;

    @Column
    private Integer price; // 컬럼명 변수에는 int x > Integer o
}
