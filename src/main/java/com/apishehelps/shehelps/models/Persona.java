package com.apishehelps.shehelps.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column
    private String Nome;

    @Column
    private String Email;

    @Column
    private String Senha;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private Type type;

    public Type getTipo() {
        return type;
    }

    public void setTipo(Type type) {
        this.type = type;
    }
}
