package com.nojari.shop;

import jakarta.persistence.*;

@Entity
public class Gongzi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(length = 1000)
    public String title;
    public String Day;

}
