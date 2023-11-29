package com.example.web;

import com.example.Dominio.Individuo;
import com.example.Servicio.IndividuoServicio;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorRest {

    @Autowired
    private IndividuoServicio individuoServicio;

    @GetMapping("/")
    public String comienzo(Model modelo) {
        log.info("Estoy ejecutando el controlador MVC");
        // Accede a los datos utilizando métodos proporcionados por el repositorio
        List<Individuo> listaIndividuos = individuoServicio.listIndividuos();
        modelo.addAttribute("listaIndividuos", listaIndividuos);
        return "Indice";
    }

    @GetMapping("/anexar")
    public String anexar(Individuo individuo) {
        return "Cambiar";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Individuo individuo, Errors error) {
        if (error.hasErrors()) {
            return "Cambiar";
        }
        individuoServicio.save(individuo);
        return "redirect:/";
    }

    @GetMapping("/Cambiar/{idIndividuo}")
    public String cambiar(Individuo individuo, Model modelo) {
        individuo = individuoServicio.find(individuo);
        modelo.addAttribute("individuo", individuo);
        return "Cambiar";
    }

    @GetMapping("/Borrar/{idIndividuo}")
    public String borrar(Individuo individuo, Model modelo) {
        individuoServicio.delete(individuo);
        return "redirect:/";
    }

}
