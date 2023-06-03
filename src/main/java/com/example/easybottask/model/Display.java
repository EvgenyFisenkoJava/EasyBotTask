package com.example.easybottask.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "display")
@Data
@EqualsAndHashCode(callSuper = true)
public class Display extends BaseEntity {
    @Column(name = "size")
    private float size;
}
