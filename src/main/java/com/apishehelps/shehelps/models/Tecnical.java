package com.apishehelps.shehelps.models;
import jakarta.persistence.*;

public class Tecnical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String user;

    @Column
    private String login;

    @Column
    private String password;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
