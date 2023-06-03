package com.example.easybottask.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "pc")
@Data
@EqualsAndHashCode(callSuper = true)
public class PC extends BaseEntity {
    @Column(name = "type")
    private String type;
}
