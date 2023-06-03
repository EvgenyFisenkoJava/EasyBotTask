package com.example.easybottask.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@MappedSuperclass
@Data
@EqualsAndHashCode
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "serial")
    private long serialNumber;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "price")
    @Positive
    @NotNull(message = "no quantity entered")
    private BigDecimal price;
    @Column(name = "quantity")
    @Positive
    @NotNull(message = "no quantity entered")
    private Integer quantity;
}
