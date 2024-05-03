package com.apishehelps.shehelps.repositories;

import com.apishehelps.shehelps.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    @Query("SELECT p FROM Pessoa p WHERE p.Email = :email")
    Persona findByEmail(String email);

    @Query("SELECT p FROM Pessoa p WHERE p.Nome = :nome")
    Persona findByNome(String name);
}
