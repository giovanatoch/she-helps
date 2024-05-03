package com.apishehelps.shehelps.service;

import com.apishehelps.shehelps.models.Persona;
import com.apishehelps.shehelps.models.Type;
import com.apishehelps.shehelps.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private PersonaRepository personaRepository;

    public void registerNewUser(String name, String email, String password, int typeId) {
        Persona user = new Persona();
        user.setNome(name);
        user.setEmail(email);
        user.setSenha(password);

        Type type = new Type();
        type.setId(typeId);
        user.setType(type);

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
