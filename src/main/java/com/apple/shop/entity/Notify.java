package com.apple.shop.entity;

import jakarta.persistence.*;
import lombok.ToString;

import java.sql.Date;

@ToString
@Entity
public class Notify {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column
    public String title;

    @Column
    public Date date;
}
