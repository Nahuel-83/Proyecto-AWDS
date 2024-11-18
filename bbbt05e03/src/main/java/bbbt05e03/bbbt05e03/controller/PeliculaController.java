package bbbt05e03.bbbt05e03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bbbt05e03.bbbt05e03.FormInfo;
import bbbt05e03.bbbt05e03.service.PeliculasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/pelicula")
public class PeliculaController {

    @Autowired
    private PeliculasService peliculaService;

    @GetMapping("")
    public String verFormulario(Model model) {

        model.addAttribute("formInfo", new FormInfo());
        return "index";
    }

    @PostMapping("/voto")
    public String votar(@RequestParam("pelicula") int pelicula,
            @RequestParam("email") String email,
            Model model) {

        // Verifica se o usuario xa votou
        if (!peliculaService.votarPelicula(email, pelicula)) {
            model.addAttribute("error", "Ya has votado con este correo electrónico.");
        }

        FormInfo formInfo = peliculaService.obtenerInfoVotos();
        model.addAttribute("votoSPM1", formInfo.getVotoSPM1());
        model.addAttribute("votoSPM2", formInfo.getVotoSPM2());
        model.addAttribute("votoSPM3", formInfo.getVotoSPM3());

        return "index"; 
    }
}
