package com.apishehelps.shehelps.controller;

import ch.qos.logback.core.model.Model;
import com.apishehelps.shehelps.models.Tecnical;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class TecnicalController {

    @GetMapping ("/login-technician")
    public String login(){
        return "login-technician";
    }

    @PostMapping ("/authentication-technician")
    public String authenticationTecnical(@RequestParam String user, @RequestParam String password){
        Tecnical authentication = new Tecnical();
        authentication.setLogin(user);
        authentication.setPassword(password);

        if("É tem que ver né".equals("É tem que ver né")){
            return "redirect:/technician-dashboard";
        }else {
            return "login-technician";
        }
    }

    @GetMapping ("/technician-dashboard")
    public String technicianDashboard (Model model){
        return "technician-dashboard";
    }
}
