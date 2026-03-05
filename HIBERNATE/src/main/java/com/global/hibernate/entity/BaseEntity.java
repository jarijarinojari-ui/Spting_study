package com.global.hibernate.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@Getter
public abstract class BaseEntity {

    @Column(name = "CREATE_DATE", insertable = false, updatable = false)
    private LocalDate createDate;
}