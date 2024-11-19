package com.wirtz.t05ej54.controller;

import com.wirtz.t05ej54.model.Pais;
import com.wirtz.t05ej54.service.PaisService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("paises", paisService.getPaises());
        return "index";
    }

    @PostMapping("/")
    public String seleccionarPais(@RequestParam("nombre") String nombre, Model model) {
        Pais pais = paisService.getPais(nombre);
        model.addAttribute("paises", paisService.getPaises());
        if (pais != null) {
            model.addAttribute("paisSeleccionado", pais);
        } else {
            model.addAttribute("error", "País no encontrado");
        }
        return "index";
    }
    
}
