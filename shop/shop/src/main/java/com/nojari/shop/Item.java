package com.nojari.shop;

import jakarta.persistence.*;

@Entity
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;//id컬럼에 강요


    public String title;
    public Integer price;

}


