package com.apishehelps.shehelps.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
@Entity
@Table(name = "chamado")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String describe;

    private int priority;

    private LocalDateTime dataInicio;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Sector sector;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status statusTicket;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Persona tecnical;

    @Setter
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Persona user;

    public LocalDateTime getDataInicio() {
        return LocalDateTime.now();
    }

    public String getNomeSolicitante() {
        return (user != null) ? user.getNome() : null;
    }
}
