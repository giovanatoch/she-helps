package com.apishehelps.shehelps.controller;

import com.apishehelps.shehelps.models.Persona;
import com.apishehelps.shehelps.repositories.PersonaRepository;
import com.apishehelps.shehelps.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    AuthenticationService autenticacaoService;
    @Autowired
    PersonaRepository pessoaRepository;

    @PostMapping("/usuario/cadastro")
    public ResponseEntity<Object> save(@RequestParam String nome,
                                       @RequestParam String email,
                                       @RequestParam String senha,
                                       @RequestParam String confirmacaoSenha){
        logger.debug("Recebido pedido de registro de novo usuário.");

        if (nome == null ) {
            logger.error("Nome é obrigatório.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Por favor, preencha todos os campos obrigatórios.");
        }
        if (email == null ) {
            logger.error("Email é obrigatório.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Por favor, preencha todos os campos obrigatórios.");
        }
        if (senha == null ) {
            logger.error("Senha é obrigatório.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Por favor, preencha todos os campos obrigatórios.");
        }

        if (autenticacaoService.checkIfEmailAlreadyExists(email)) {
            logger.error("Este email já foi utilizado. Por favor, digite outro email.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Este email já foi utilizado. Por favor, digite outro email.");
        }

        if (! autenticacaoService.confirmedPassword(senha, confirmacaoSenha)) {
            logger.error("As senhas não correspondem.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("As senhas não correspondem.");
        }


        try {
            autenticacaoService.registerNewUser(nome, email, senha);
            logger.info("Usuário registrado com sucesso: " + email);
            return ResponseEntity.status(HttpStatus.OK).body("Usuário registrado com sucesso.");
        } catch (Exception e) {
            logger.error("Erro ao registrar o usuário.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao registrar o usuário. Por favor, tente novamente mais tarde.");
        }
    }

    @PostMapping("/usuario/login")
    public ResponseEntity<Object> login(@RequestParam String loginEmail,
                                        @RequestParam String loginSenha){
        logger.debug("Recebido pedido de login de usuário.");

        if (loginEmail.isEmpty() || loginSenha.isEmpty()) {
            logger.error("Email e senha são obrigatórios.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Por favor, preencha todos os campos obrigatórios.");
        }

        // Busca o usuário pelo email no banco de dados
        Persona usuario = pessoaRepository.findByEmail(loginEmail);

        // Verifica se o usuário foi encontrado e se a senha está correta
        if (usuario != null && usuario.getSenha().equals(loginSenha)) {
            logger.info("Usuário autenticado com sucesso: " + loginEmail);
            return ResponseEntity.status(HttpStatus.OK).body("Login efetuado com sucesso.");
        } else {
            logger.error("Credenciais inválidas.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciais inválidas. Por favor, verifique seu email e senha.");
        }

    }
}