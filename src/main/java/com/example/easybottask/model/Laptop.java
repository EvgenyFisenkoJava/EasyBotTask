package com.example.easybottask.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "laptop")
@Data
@EqualsAndHashCode(callSuper = true)
public class Laptop extends BaseEntity {
    @Column(name = "size")
    private int size;
}
