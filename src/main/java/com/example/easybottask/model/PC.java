package com.example.easybottask.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pc")
@Data
public class PC extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private PCType type;
}
