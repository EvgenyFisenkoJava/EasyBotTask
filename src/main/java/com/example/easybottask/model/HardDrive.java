package com.example.easybottask.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "hd")
@Data
@EqualsAndHashCode(callSuper = true)
public class HardDrive extends BaseEntity {
    @Column(name = "volume")
    private int volume;
}
