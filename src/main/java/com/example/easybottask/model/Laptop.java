package com.example.easybottask.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "laptop")
@Data
public class Laptop extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private LaptopSize size;
}
