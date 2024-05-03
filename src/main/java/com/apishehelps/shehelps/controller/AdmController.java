package com.apishehelps.shehelps.controller;

import ch.qos.logback.core.model.Model;
import com.apishehelps.shehelps.models.Ticket;
import com.apishehelps.shehelps.repositories.StatusRepository;
import com.apishehelps.shehelps.repositories.TicketRepository;
import com.apishehelps.shehelps.service.TicketService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdmController {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketService ticketService;

    @Autowired
    StatusRepository statusRepository;

    private static boolean ticketsregistered = false;

    @GetMapping("/pagina-adm")
    public String pageAdm(@RequestParam(required = false) String nome, Model model, HttpServletRequest request) {
        return "ainda não sei o que colocar aqui kkkkk";
    }
}
