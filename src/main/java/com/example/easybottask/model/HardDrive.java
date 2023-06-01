package com.example.easybottask.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "hd")
@Data
public class HardDrive extends BaseEntity {
    @Column(name = "volume")
    private int volume;
}
