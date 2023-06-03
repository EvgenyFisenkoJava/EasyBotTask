package com.example.easybottask.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "laptop")
@Data
public class Laptop extends BaseEntity {

    @Column(name = "size")
    private int size;
}
