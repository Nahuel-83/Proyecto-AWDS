package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.model.FormInfo;

@Controller
@Scope("session")
public class MasterMindController {

    @Autowired
    public MasterMindService masterMindService;

    @GetMapping("/")
    public String showHome() {
        return "indexView";
    }

    @GetMapping("/juego")
    public String showGame(Model model) {
        model.addAttribute("formInfo", new FormInfo());
        model.addAttribute("listaIntentos", masterMindService.masterMind.getListaIntentos());
        model.addAttribute("errorMessage", masterMindService.getErrorMessage());
        model.addAttribute("estadoJuego", masterMindService.masterMind.getEstadoJuego());
        return "juegoView";
    }

    @PostMapping("/juego")
    public String newTry(FormInfo formInfo, Model model) {
        boolean intentoValido = masterMindService.comprobarIntento(formInfo.getIntento());
        if (!intentoValido) {
            model.addAttribute("errorMessage", masterMindService.getErrorMessage());
        }
        return "redirect:/juego";

    }

    @PostMapping("/nuevoJuego")
    public String newGame(@RequestParam("intentos") int intentos, @RequestParam("digitos") int digitos) {
        masterMindService.nuevoJuego(intentos, digitos); 
        return "redirect:/juego";
    }
}
