package com.example.easybottask.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "display")
@Data
public class Display extends BaseEntity {
    @Column(name = "size")
    private float size;
}
