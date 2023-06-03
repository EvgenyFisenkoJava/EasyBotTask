package com.example.easybottask.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "hd")
@Data
public class HardDrive extends BaseEntity {
    @Column(name = "volume")
    private int volume;
}
