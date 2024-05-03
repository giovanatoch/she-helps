package com.apishehelps.shehelps.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import javax.naming.Name;

@Getter
@Setter
@Entity
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column
    private String Name;
}
