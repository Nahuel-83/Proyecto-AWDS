package bbbt04e01.bbbt04e01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bbbt04e01.bbbt04e01.service.CalculosService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculos")
public class CalculosController {

    @Autowired
    CalculosService calculosService;

    @PostMapping("/primo")
    public String esPrimo(@RequestParam(required = false) Integer numero, Model model) {
        if (numero == null) {
            model.addAttribute("error", "Debes proporcionar un número.");
        } else if (numero <= 0) {
            model.addAttribute("error", "El número debe ser mayor que cero.");
        } else {
            boolean esPrimo = calculosService.esPrimo(numero);
            model.addAttribute("numero", numero);
            model.addAttribute("esPrimo", esPrimo);
        }
        return "index";
    }

    @PostMapping("/hipotenusa")
    public String calcularHipotenusa(@RequestParam double cateto1, @RequestParam double cateto2, Model model) {
        if (cateto1 <= 0 || cateto2 <= 0) {
            model.addAttribute("error", "Ambos catetos deben ser mayores que cero.");
        } else {
            double hipotenusa = Math.round(calculosService.calcularHipotenusa(cateto1, cateto2));
            model.addAttribute("cateto1", cateto1);
            model.addAttribute("cateto2", cateto2);
            model.addAttribute("hipotenusa", hipotenusa);
        }
        return "index";
    }

    @PostMapping("/divisores")
    public String obtenerDivisores(@RequestParam int numero, Model model) {
        if (numero <= 0) {
            model.addAttribute("error", "El número debe ser mayor que cero.");
        } else {
            List<Integer> divisores = calculosService.obtenerDivisores(numero);
            model.addAttribute("numero", numero);
            model.addAttribute("divisores", divisores);
        }
        return "index";
    }
}