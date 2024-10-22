package com.mbn.dawlify.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        // Agregar el año actual al modelo para que Thymeleaf lo use en la vista
        model.addAttribute("currentYear", LocalDate.now().getYear());
        return "index"; 
    }


    @GetMapping("/quienes-somos")
    public String quienesSomos() {
        return "quienes-somos"; 
    }
}
