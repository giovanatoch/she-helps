package com.apishehelps.shehelps.service;

import com.apishehelps.shehelps.models.Persona;
import com.apishehelps.shehelps.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private PersonaRepository personaRepository;

    public void registerNewUser(String nome, String email, String senha) {
        Persona user = new Persona();
        user.setNome(nome);
        user.setEmail(email);
        user.setSenha(senha);

        personaRepository.save(user);
    }

    public boolean checkIfEmailAlreadyExists(String email) {
        Persona userExists = personaRepository.findByEmail(email);
        return userExists != null;
    }

    public boolean confirmedPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
}
